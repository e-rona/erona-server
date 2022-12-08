package com.sg.erona.domain.service.command.co;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimeCommand {
    private Long useTime;
    private Long count;
}
