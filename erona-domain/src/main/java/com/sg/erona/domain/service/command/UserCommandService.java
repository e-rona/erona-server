package com.sg.erona.domain.service.command;

import com.sg.erona.domain.auth.EronaToken;
import com.sg.erona.domain.service.command.co.TimeCommand;

public interface UserCommandService {
    EronaToken registerUser(String userId);
    void registerTimeRecord(String accessToken, TimeCommand timeCommand);
}
