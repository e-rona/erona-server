package com.sg.erona.domain.service.query;

import com.sg.erona.domain.auth.JwtTokenProvider;
import com.sg.erona.domain.persistence.entity.UserInfo;
import com.sg.erona.domain.persistence.repository.UserInfoRepository;
import com.sg.erona.domain.service.query.vo.TimeRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public TimeRecordVO getTimeRecord(String accessToken){
        String payload = jwtTokenProvider.getPayload(accessToken);
        Optional<UserInfo> userInfo = userInfoRepository.findByUserId(payload);
        String useTime = "";
        String count = "";
        if(userInfo.isPresent()){
            UserInfo getUser = userInfo.get();
            useTime = getUser.getUseTime().toString();
            count = getUser.getCount().toString();
        }
        return TimeRecordVO.builder()
                .useTime(useTime)
                .count(count)
                .build();
    }
}
