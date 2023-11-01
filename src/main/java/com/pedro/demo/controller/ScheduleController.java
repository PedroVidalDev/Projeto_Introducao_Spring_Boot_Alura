package com.pedro.demo.controller;

import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ScheduleDeleteDataInputDTO;
import com.pedro.demo.domain.schedule.ScheduleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedules")
@SecurityRequirement(name = "bearer-key")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping
    @Transactional
    public ResponseEntity toSchedule(@RequestBody @Valid ScheduleDataInputDTO data){
        System.out.println(data);
        var dto = service.makeSchedule(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity deleteSchedule(@RequestBody @Valid ScheduleDeleteDataInputDTO data){
        service.cancelSchedule(data);
        return ResponseEntity.noContent().build();
    }
}
