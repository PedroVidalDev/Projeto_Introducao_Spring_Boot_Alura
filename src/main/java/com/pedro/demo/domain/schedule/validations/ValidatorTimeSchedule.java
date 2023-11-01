package com.pedro.demo.domain.schedule.validations;

import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ValidationExceptionSchedule;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidatorTimeSchedule implements ValidatorSchedule{
    public void validar(ScheduleDataInputDTO data){
        var dateSchedule = data.date();
        var sunday = dateSchedule.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeClinicOpening = dateSchedule.getHour() < 7;
        var afterClinicClosing = dateSchedule.getHour() > 18;

        if(sunday || beforeClinicOpening || afterClinicClosing){
            throw new ValidationExceptionSchedule("Consulta fora do horario de funcionamento");
        }
    }
}
