package com.sg.erona.interfaces.api.query;

import com.sg.erona.domain.persistence.repository.UserInfoRepository;
import com.sg.erona.domain.service.query.QuizQueryService;
import com.sg.erona.domain.service.query.UserQueryService;
import com.sg.erona.domain.service.query.vo.QuizVO;
import com.sg.erona.domain.service.query.vo.TimeRecordVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/query/time")
public class TimeRecordQueryController {

    @Autowired
    private UserQueryService userQueryService;

    @GetMapping("/history")
    public TimeRecordVO getTimeRecord(@RequestHeader("accessToken") String accessToken){
        return userQueryService.getTimeRecord(accessToken);
    }

}
