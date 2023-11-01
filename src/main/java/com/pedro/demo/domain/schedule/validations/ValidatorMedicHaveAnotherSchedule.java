package com.pedro.demo.domain.schedule.validations;

import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ScheduleRepository;
import com.pedro.demo.domain.schedule.ValidationExceptionSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorMedicHaveAnotherSchedule implements ValidatorSchedule{

    @Autowired
    private ScheduleRepository repository;

    public void validar(ScheduleDataInputDTO data){
        var medicHaveAnotherSchedule = repository.existsByMedicIdAndDate(data.idMedic(), data.date());

        if(medicHaveAnotherSchedule){
            throw new ValidationExceptionSchedule("Medico ja tem uma consulta marcada para esse momento");
        }
    }
}
