package com.sg.erona.domain.service.query;

import com.sg.erona.domain.service.query.vo.TimeRecordVO;

public interface UserQueryService {
    TimeRecordVO getTimeRecord(String accessToken);
}
