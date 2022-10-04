package com.sg.erona.domain.service.query.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuizDetailVO {
    private String quiz;
    private String answer;
}
