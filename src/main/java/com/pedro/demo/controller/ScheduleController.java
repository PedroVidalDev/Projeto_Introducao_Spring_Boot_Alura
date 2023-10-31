package com.pedro.demo.controller;

import com.pedro.demo.domain.schedule.ScheduleDataInput;
import com.pedro.demo.domain.schedule.ScheduleDataOutput;
import com.pedro.demo.domain.schedule.ScheduleDeleteDataInput;
import com.pedro.demo.domain.schedule.ScheduleService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping
    @Transactional
    public ResponseEntity toSchedule(@RequestBody @Valid ScheduleDataInput data){
        System.out.println(data);
        service.makeSchedule(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity deleteSchedule(@RequestBody @Valid ScheduleDeleteDataInput data){
        service.cancelSchedule(data);
        return ResponseEntity.noContent().build();
    }
}
