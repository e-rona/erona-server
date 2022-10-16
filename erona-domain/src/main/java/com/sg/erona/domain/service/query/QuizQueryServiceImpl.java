package com.sg.erona.domain.service.query;

import com.sg.erona.domain.persistence.entity.ConnectionTestQuiz;
import com.sg.erona.domain.persistence.repository.ConnectionTestQuizRepository;
import com.sg.erona.domain.service.query.vo.QuizDetailVO;
import com.sg.erona.domain.service.query.vo.QuizVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QuizQueryServiceImpl implements QuizQueryService {

    @Autowired
    private ConnectionTestQuizRepository connectionTestQuizRepository;

    @Override
    public QuizVO getQuizList() {
        List<Long> ids = new ArrayList<>();
        // test
        ids.add(Long.parseLong("1"));
        ids.add(Long.parseLong("2"));
        ids.add(Long.parseLong("3"));
        ids.add(Long.parseLong("4"));
        ids.add(Long.parseLong("5"));
        List<ConnectionTestQuiz> connectionTestQuizs = connectionTestQuizRepository.findAllByIdIn(ids);

        List<QuizDetailVO> quizDetailVOS = new ArrayList<>();

        quizDetailVOS = connectionTestQuizs.stream().map(x->
                QuizDetailVO.builder()
                    .quiz(x.getTestQuiz())
                    .answer(x.getTestAnswer())
                .build()
            ).collect(Collectors.toList());


        return QuizVO.builder()
                .gameCode(Long.parseLong("1"))
                .gameList(quizDetailVOS)
                .build();
    }


    /*
    // TODO : 사칙연산 게임
    private List<QuizDetailVO> getArithmeticGame(){

    }
     */

    /*
    // TODO : 속담&사자성어 게임
    private List<QuizDetailVO> getProverbGame(){

    }
     */


}
