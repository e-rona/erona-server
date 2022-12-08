package com.sg.erona.domain.service.command;

import com.sg.erona.domain.auth.EronaToken;
import com.sg.erona.domain.auth.JwtTokenProvider;
import com.sg.erona.domain.persistence.entity.UserInfo;
import com.sg.erona.domain.persistence.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        UserInfo userInfo = UserInfo.builder()
                .userId(userId)
                .refreshToken(refreshToken)
                .useTime(0L)
                .count(0L)
                .build();

        userInfoRepository.save(userInfo);

        return EronaToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
