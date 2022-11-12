package com.sg.erona.interfaces.api.query.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class QuizQueryDTOTest {

    @DisplayName("DTO 테스트")
    @Test
    public void quizQueryDTOTest(){
        //given
        String userId = "12345";

        //when
        QuizQueryDTO quizQueryDTO = new QuizQueryDTO(userId);

        //then
        assertThat(quizQueryDTO.getUserId()).isEqualTo(userId);
    }

}