package com.pedro.demo.controller;

import com.pedro.demo.medic.MedicGetDataOutput;
import com.pedro.demo.patients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody PatientDTO data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public List<PatientGetDTO> read(){
        return repository.findAll().stream().map(PatientGetDTO::new).toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public void editPatient(@RequestBody @Valid PatiendEditDTO data, @PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.actualizeData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id){
        repository.deleteById(id);
    }
}
