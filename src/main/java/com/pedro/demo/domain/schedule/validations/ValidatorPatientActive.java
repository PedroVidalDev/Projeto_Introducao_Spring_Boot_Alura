package com.pedro.demo.domain.schedule.validations;

import com.pedro.demo.domain.patients.Patient;
import com.pedro.demo.domain.patients.PatientRepository;
import com.pedro.demo.domain.schedule.ScheduleDataInputDTO;
import com.pedro.demo.domain.schedule.ValidationExceptionSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPatientActive implements ValidatorSchedule{

    @Autowired
    private PatientRepository patientRepository;

    public void validar(ScheduleDataInputDTO data){
        var patientIsActive = patientRepository.existsById(data.idPatient());

        if(!patientIsActive){
            throw new ValidationExceptionSchedule("Consulta nao pode ser feita com paciente inexiste");
        }
    }

}
