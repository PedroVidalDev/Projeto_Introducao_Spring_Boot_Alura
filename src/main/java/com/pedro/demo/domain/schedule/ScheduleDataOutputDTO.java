package com.pedro.demo.domain.schedule;

import java.time.LocalDateTime;

public record ScheduleDataOutputDTO(
        Long id,
        Long idMedic,
        Long idPatient,
        LocalDateTime date
){
    public ScheduleDataOutputDTO(Schedule schedule) {
        this(schedule.getId(), schedule.getMedic().getId(), schedule.getPatient().getId(), schedule.getDate());
    }
}
