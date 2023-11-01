package com.pedro.demo.domain.schedule.validations;

import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ScheduleRepository;
import com.pedro.demo.domain.schedule.ValidationExceptionSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPatientHaveAnotherSchedule implements ValidatorSchedule{

    @Autowired
    private ScheduleRepository repository;

    public void validar(ScheduleDataInputDTO data){
        var firstHour = data.date().withHour(7);
        var lastHour = data.date().withHour(18);

        var patientHaveAnotherSchedule = repository.existsByPatientIdAndDateBetween(data.idPatient(), firstHour, lastHour);

        if (patientHaveAnotherSchedule) {
            throw new ValidationExceptionSchedule("Paciente ja possui consulta nesse dia.");
        }
    }

}
