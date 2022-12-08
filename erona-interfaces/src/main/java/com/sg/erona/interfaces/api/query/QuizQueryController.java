package com.sg.erona.interfaces.api.query;

import com.sg.erona.domain.service.query.QuizQueryService;
import com.sg.erona.domain.service.query.vo.QuizVO;
import com.sg.erona.interfaces.api.query.dto.QuizQueryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/query")
public class QuizQueryController {

    @Autowired
    private QuizQueryService quizQueryService;

    @GetMapping("/game-list")
    public QuizVO getGameList(){
        return quizQueryService.getQuizList();
    }


}
