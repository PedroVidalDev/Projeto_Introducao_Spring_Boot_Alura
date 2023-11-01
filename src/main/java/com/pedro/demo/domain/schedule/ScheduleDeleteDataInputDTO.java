package com.pedro.demo.domain.schedule;

import jakarta.validation.constraints.NotNull;

public record ScheduleDeleteDataInputDTO(
        @NotNull Long idSchedule,
        @NotNull ScheduleCancelMotive cancelMotive
) {
}
