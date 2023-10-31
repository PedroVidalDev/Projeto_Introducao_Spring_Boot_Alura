package com.pedro.demo.domain.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ScheduleDataOutput (
        Long id,
        Long idMedic,
        Long idPatient,
        LocalDateTime date
){
}
