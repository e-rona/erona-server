package com.sg.erona.domain.service.command;

import com.sg.erona.domain.auth.EronaToken;
import com.sg.erona.domain.auth.JwtTokenProvider;
import com.sg.erona.domain.persistence.entity.UserInfo;
import com.sg.erona.domain.persistence.repository.UserInfoRepository;
import com.sg.erona.domain.service.command.co.TimeCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public EronaToken registerUser(String userId){

        String accessToken = jwtTokenProvider.createAccessToken(userId);
        String refreshToken = jwtTokenProvider.createRefreshToken();

        Optional<UserInfo> userInfo = userInfoRepository.findByUserId(userId);
        UserInfo registerUser = null;
        if(userInfo.isPresent()){
            registerUser = userInfo.get();
            registerUser.setRefreshToken(refreshToken);
        } else {
            registerUser = UserInfo.builder()
                    .userId(userId)
                    .refreshToken(refreshToken)
                    .useTime(0L)
                    .count(0L)
                    .build();
        }

        userInfoRepository.save(registerUser);

        return EronaToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void registerTimeRecord(String accessToken, TimeCommand timeCommand){
        String payload = jwtTokenProvider.getPayload(accessToken);
        Optional<UserInfo> userInfo = userInfoRepository.findByUserId(payload);
        if(userInfo.isPresent()){
            UserInfo updateUser = userInfo.get();
            Long newCount = updateUser.getCount() + timeCommand.getCount();
            Long newUseTime = updateUser.getUseTime() + timeCommand.getUseTime();
            updateUser.setUseTime(newUseTime);
            updateUser.setCount(newCount);
            userInfoRepository.save(updateUser);
        }
    }
}
