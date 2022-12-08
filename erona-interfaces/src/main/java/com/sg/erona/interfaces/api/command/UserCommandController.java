package com.sg.erona.interfaces.api.command;

import com.sg.erona.domain.auth.EronaToken;
import com.sg.erona.domain.service.command.UserCommandService;
import com.sg.erona.domain.service.query.vo.QuizVO;
import com.sg.erona.interfaces.api.command.dto.UserCommandDTO;
import com.sg.erona.interfaces.api.query.dto.QuizQueryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @PostMapping("/register")
    public EronaToken registerUser(@RequestBody UserCommandDTO userCommandDTO){
        return userCommandService.registerUser(userCommandDTO.getUserId());
    }

}
