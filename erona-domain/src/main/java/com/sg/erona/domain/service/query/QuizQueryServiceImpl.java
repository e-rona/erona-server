package com.sg.erona.domain.service.query;

import com.sg.erona.domain.persistence.entity.ConnectionTestQuiz;
import com.sg.erona.domain.persistence.entity.IdiomQuiz;
import com.sg.erona.domain.persistence.entity.MovieQuiz;
import com.sg.erona.domain.persistence.repository.ConnectionTestQuizRepository;
import com.sg.erona.domain.persistence.repository.IdiomQuizRepository;
import com.sg.erona.domain.persistence.repository.MovieQuizRepository;
import com.sg.erona.domain.service.query.vo.QuizDetailVO;
import com.sg.erona.domain.service.query.vo.QuizVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QuizQueryServiceImpl implements QuizQueryService {

    @Autowired
    private ConnectionTestQuizRepository connectionTestQuizRepository;

    @Autowired
    private IdiomQuizRepository idiomQuizRepository;

    @Autowired
    private MovieQuizRepository movieQuizRepository;

    @Override
    public QuizVO getQuizList() {

        // 게임 종류 선택
        Long randomGame = Double.valueOf(Math.random()*4 + 1).longValue();

        List<QuizDetailVO> quizDetailVOS = new ArrayList<>();
        if(randomGame == 1){
            //사자성어 게임
            quizDetailVOS = this.getIdiomGame();
        } else if (randomGame == 2) {
            // 사칙연산 게임
            quizDetailVOS = this.getArithmeticGame();
        } else if (randomGame == 3) {
            // 영화 명대사 게임
            quizDetailVOS = this.getMovieGame();
        } else {
            // TODO : 게임 추가 예정
        }

        return QuizVO.builder()
                .gameCode(randomGame)
                .gameList(quizDetailVOS)
                .build();
    }


    // TYPE 1 : 사자성어 게임
    private List<QuizDetailVO> getIdiomGame(){
        Long count = idiomQuizRepository.countBy();
        List<Long> ids = this.getRandomNumbers(count);

        List<IdiomQuiz> connectionTestQuizs = idiomQuizRepository.findAllByIdIn(ids);

        List<QuizDetailVO> quizDetailVOS = connectionTestQuizs.stream().map(x->
                QuizDetailVO.builder()
                        .quiz(x.getQuiz())
                        .answer(x.getAnswer())
                        .build()
        ).collect(Collectors.toList());


        return quizDetailVOS;
    }

    // TYPE 2 : 사칙연산 게임
    private List<QuizDetailVO> getArithmeticGame() {

        List<QuizDetailVO> quizDetailVOS = new ArrayList<>();

        for(int i=0;i<5;i++){
            Long a = Double.valueOf(Math.random()*100 + 1).longValue();
            Long b = Double.valueOf(Math.random()*100 + 1).longValue();
            Long op = Double.valueOf(Math.random()*4 + 1).longValue();
            Long ans = new Long(0);
            String opc = "";

            if(op == 1) {
                ans = a + b;
                opc = "+";
            } else if (op == 2) {
                if(b > a) {
                    Long temp = a;
                    a = b;
                    b = temp;
                }
                ans = a - b;
                opc = "-";
            } else if (op == 3){
                b = b%10;
                ans = a * b;
                opc = "*";
            } else {
                b = b%20;
                if(b > a) {
                    Long temp = a;
                    a = b;
                    b = temp;
                }
                a -= a%b;
                ans = a / b;
                opc = "/";
            }

            String quiz = "";
            quiz = quiz.concat(a.toString()).concat(opc).concat(b.toString());
            quizDetailVOS.add(QuizDetailVO.builder()
                    .quiz(quiz)
                    .answer(ans.toString())
                    .build());
        }

        return quizDetailVOS;
    }

    // TYPE 3 : 영화 명대사 게임
    private List<QuizDetailVO> getMovieGame(){
        Long count = movieQuizRepository.countBy();
        List<Long> ids = this.getRandomNumbers(count);

        List<MovieQuiz> connectionTestQuizs = movieQuizRepository.findAllByIdIn(ids);

        List<QuizDetailVO> quizDetailVOS = connectionTestQuizs.stream().map(x->
                QuizDetailVO.builder()
                        .quiz(x.getQuiz())
                        .answer(x.getAnswer())
                        .build()
        ).collect(Collectors.toList());


        return quizDetailVOS;
    }

    private List<Long> getRandomNumbers(Long max){
        Set<Long> set = new HashSet<>();

        while (set.size() < 5) {
            Double d = Math.random() * max + 1;
            set.add(d.longValue());
        }

        List<Long> list = new ArrayList<>(set);

        return list;
    }

}
