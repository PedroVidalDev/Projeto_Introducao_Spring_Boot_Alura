package com.pedro.demo.domain.schedule;

import com.pedro.demo.domain.medic.Medic;
import com.pedro.demo.domain.medic.MedicRepository;
import com.pedro.demo.domain.patients.Patient;
import com.pedro.demo.domain.patients.PatientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void makeSchedule(ScheduleDataInput data){
        System.out.println(data);
        if(!patientRepository.existsById(data.idPatient())){
           throw new ValidationExceptionSchedule("ID do paciente informado nao existe.");
        }

        if(data.idMedic() != null && !medicRepository.existsById(data.idMedic())){
            throw new ValidationExceptionSchedule("ID do medico informado nao existe.");
        }

        Medic medic = choiceMedic(data);
        Patient patient = patientRepository.findById(data.idPatient()).get();

        Schedule schedule = new Schedule(null, medic, patient, null, data.date());
        repository.save(schedule);
    }

    private Medic choiceMedic(ScheduleDataInput data){
        if(data.idMedic() != null){
            return medicRepository.getReferenceById(data.idMedic());
        }
        if(data.especialidade() == null){
            throw new ValidationException("Especialidade eh obrigatoria");
        }
        return medicRepository.choiceRandomMedic(data.especialidade(), data.date());
    }

    public void cancelSchedule(ScheduleDeleteDataInput data){
        if(!repository.existsById(data.idSchedule())){
            throw new ValidationException("Consulta nao existe.");
        }

        var schedule = repository.getReferenceById(data.idSchedule());
        schedule.cancelar(data.cancelMotive());
    }
}
