package com.sg.erona.interfaces.api.command;

import com.sg.erona.domain.auth.EronaToken;
import com.sg.erona.domain.service.command.UserCommandService;
import com.sg.erona.domain.service.command.co.TimeCommand;
import com.sg.erona.interfaces.api.command.dto.TimeCommandDTO;
import com.sg.erona.interfaces.api.command.dto.UserCommandDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/command/time")
public class TimeRecordCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @PostMapping("/register")
    public void registerTimeRecord(@RequestHeader("accessToken") String accessToken, @RequestBody TimeCommandDTO timeCommandDTO){
        userCommandService.registerTimeRecord(accessToken, TimeCommand.builder()
                .useTime(Long.parseLong(timeCommandDTO.getUseTime()))
                .count(Long.parseLong(timeCommandDTO.getCount()))
                .build());
    }
}
