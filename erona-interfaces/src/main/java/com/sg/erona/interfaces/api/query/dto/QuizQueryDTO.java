package com.sg.erona.interfaces.api.query.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizQueryDTO {
    private String userId;
}
