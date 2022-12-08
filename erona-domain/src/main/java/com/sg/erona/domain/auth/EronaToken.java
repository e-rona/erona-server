package com.sg.erona.domain.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EronaToken {
    private String accessToken;
    private String refreshToken;
}
