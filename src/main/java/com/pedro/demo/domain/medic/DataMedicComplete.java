package com.pedro.demo.domain.medic;

import com.pedro.demo.domain.endereco.Endereco;

public record DataMedicComplete(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DataMedicComplete(Medic medic){
        this(medic.getId(), medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getTelefone(), medic.getEspecialidade(), medic.getEndereco());
    }
}
