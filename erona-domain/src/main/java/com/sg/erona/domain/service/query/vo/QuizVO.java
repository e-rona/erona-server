package com.sg.erona.domain.service.query.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuizVO {
    private Long gameCode;
    private List<QuizDetailVO> gameList;
}
