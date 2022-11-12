package com.sg.erona.domain.persistence.repository;

import com.sg.erona.domain.configration.DatabaseSourceConfig;
import com.sg.erona.domain.persistence.entity.IdiomQuiz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Repository Test
// CRUD 관련 Repository 테스트는 JPA의 도움이 필요 -> @DataJpaTest 활용
// @DataJpaTest : 저장을 위한 JPA 연관 관계가 적절히 구성되었는지, Repository 메서드가 제대로 구현되었는지 확인하는 것이 목적

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Test에 실제 DB 사용
@Import(DatabaseSourceConfig.class) // DB configuration class import
//@ActiveProfiles("test")
class IdiomQuizRepositoryTest {

    @Autowired
    private IdiomQuizRepository idiomQuizRepository;

    @Test
    @DisplayName("게임 조회")
    public void create_new_member() {

        // given
        List<Long> ids = new ArrayList<>();
        ids.add(Long.valueOf(1));
        ids.add(Long.valueOf(2));

        // when
        List<IdiomQuiz> idiomQuizs = idiomQuizRepository.findAllByIdIn(ids);

        // then
        assertThat(idiomQuizs.get(0).getId()).isEqualTo(1);
        assertThat(idiomQuizs.get(1).getId()).isEqualTo(2);
    }


}