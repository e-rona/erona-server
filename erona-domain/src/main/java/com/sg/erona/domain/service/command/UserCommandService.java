package com.sg.erona.domain.service.command;

import com.sg.erona.domain.auth.EronaToken;

public interface UserCommandService {
    EronaToken registerUser(String userId);
}
