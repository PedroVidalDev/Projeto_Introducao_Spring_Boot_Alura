package com.pedro.demo.controller;

import com.pedro.demo.patients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody PatientCreateDTO data, UriComponentsBuilder uriBuilder){
        Patient patient = new Patient(data);

        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDTO(patient));
    }

    @GetMapping
    public ResponseEntity<List<PatientGetDTO>> read(){
        var page = repository.findAll().stream().map(PatientGetDTO::new).toList();
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editPatient(@RequestBody @Valid PatiendEditDTO data, @PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.actualizeData(data);

        return ResponseEntity.ok(new PatientDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
