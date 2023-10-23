package com.pedro.demo.medic;

import com.pedro.demo.endereco.Endereco;

public record DataMedicComplete(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DataMedicComplete(Medic medic){
        this(medic.getId(), medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getTelefone(), medic.getEspecialidade(), medic.getEndereco());
    }
}
