package com.sg.erona.interfaces.api.command.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimeCommandDTO {
    private String useTime;
    private String count;
}
