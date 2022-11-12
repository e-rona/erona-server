package com.sg.erona.domain.service.query;

import com.sg.erona.domain.persistence.entity.IdiomQuiz;
import com.sg.erona.domain.persistence.repository.IdiomQuizRepository;
import com.sg.erona.domain.service.query.vo.QuizVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuizQueryServiceTest {

    @Autowired
    private QuizQueryService quizQueryService;

    @Mock
    private IdiomQuizRepository idiomQuizRepository;

    @Test
    @DisplayName("게임 랜덤 반환 서비스 테스트")
    public void getQuizListTest() {
        assertThat(quizQueryService.getQuizList().getGameList().size()).isEqualTo(3);
    }

}