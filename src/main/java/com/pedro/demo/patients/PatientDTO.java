package com.pedro.demo.patients;

import com.pedro.demo.endereco.Endereco;

public record PatientDTO (Long id, String nome, String email, String telefone, String crm, Endereco endereco, int quarto){
    public PatientDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCrm(), patient.getEndereco(), patient.getQuarto());
    }
}
