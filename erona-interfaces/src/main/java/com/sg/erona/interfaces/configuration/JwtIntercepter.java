package com.sg.erona.interfaces.configuration;

import com.sg.erona.domain.auth.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtIntercepter implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // controller 진입 전에 실행됨. 반환 값이 true일 경우 controller로 진입하고, false인 경우 진입하지 않음

        log.info("==== preHandle ====");
        String accessToken = request.getHeader("accessToken");

        if (accessToken != null && jwtTokenProvider.validateToken(accessToken)) {
            log.info("==== TRUE ====");
            return true;
        }
        log.info("==== FALSE ====");

        response.setStatus(401);
        response.setHeader("AccessToken", accessToken);
        response.setHeader("msg", "Check the tokens.");
        return false;
    }
}
