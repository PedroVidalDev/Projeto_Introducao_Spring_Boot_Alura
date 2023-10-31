package com.pedro.demo.domain.schedule;

import jakarta.validation.constraints.NotNull;

public record ScheduleDeleteDataInput(
        @NotNull Long idSchedule,
        @NotNull ScheduleCancelMotive cancelMotive
) {
}
