package com.pedro.demo.patients;

import com.pedro.demo.medic.MedicGetDataOutput;

public record PatientGetDTO (
    Long id,
    String nome,
    String email,
    String telefone,
    int quarto
){
    public PatientGetDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getQuarto());
    }
}
