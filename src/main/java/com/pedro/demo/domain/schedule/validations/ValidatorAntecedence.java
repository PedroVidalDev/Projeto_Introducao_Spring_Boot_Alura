package com.pedro.demo.domain.schedule.validations;

import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ValidationExceptionSchedule;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidatorAntecedence implements ValidatorSchedule{
    public void validar(ScheduleDataInputDTO data){
        var dateSchedule = data.date();
        var now = LocalDateTime.now();

        var differenceInMinutes = Duration.between(now, dateSchedule).toMinutes();

        if(differenceInMinutes < 30){
            throw new ValidationExceptionSchedule("Consulta deve ser agendada com antecedencia de 30 minutos.");
        }
    }
}
