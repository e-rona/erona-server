package com.sg.erona.domain.service.query.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimeRecordVO {
    private String useTime;
    private String count;
}
