package com.pedro.demo.domain.patients;

import com.pedro.demo.domain.endereco.Endereco;

public record PatientDTO (Long id, String nome, String email, String telefone, String crm, Endereco endereco, int quarto){
    public PatientDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCrm(), patient.getEndereco(), patient.getQuarto());
    }
}
