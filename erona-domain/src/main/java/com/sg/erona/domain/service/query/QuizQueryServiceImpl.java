package com.sg.erona.domain.service.query;

import com.sg.erona.domain.service.query.vo.QuizDetailVO;
import com.sg.erona.domain.service.query.vo.QuizVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizQueryServiceImpl implements QuizQueryService {

    @Override
    public QuizVO getQuizList() {
        //TODO : DB 연결 후 수정

        List<QuizDetailVO> quizDetailVOS = new ArrayList<>();

        quizDetailVOS.add(QuizDetailVO.builder().quiz("이심").answer("전심").build());
        quizDetailVOS.add(QuizDetailVO.builder().quiz("가는말이 고와야").answer("오는말이 곱다").build());
        quizDetailVOS.add(QuizDetailVO.builder().quiz("작심").answer("삼일").build());
        quizDetailVOS.add(QuizDetailVO.builder().quiz("감언").answer("이설").build());
        quizDetailVOS.add(QuizDetailVO.builder().quiz("바늘 도둑이").answer("소도둑 된다").build());


        return QuizVO.builder()
                .gameCode(new Long(1))
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
