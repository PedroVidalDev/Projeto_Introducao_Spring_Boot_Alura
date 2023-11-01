package com.pedro.demo.domain.schedule;

import com.pedro.demo.domain.medic.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ScheduleDataInputDTO(
        Long idMedic,
        @NotNull Long idPatient,
        @NotNull @Future LocalDateTime date,
        Especialidade especialidade) {
}
