package com.sg.erona.interfaces.api.query;

import com.sg.erona.domain.service.query.QuizQueryService;
import com.sg.erona.domain.service.query.vo.QuizVO;
import com.sg.erona.interfaces.api.query.dto.QuizQueryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class QuizQueryController {

    @Autowired
    private QuizQueryService quizQueryService;

    @PostMapping("/game-list")
    public QuizVO getGameList(@RequestBody QuizQueryDTO quizQueryDTO){
        //TODO : 파라미터 변경
        return quizQueryService.getQuizList();
    }


}
