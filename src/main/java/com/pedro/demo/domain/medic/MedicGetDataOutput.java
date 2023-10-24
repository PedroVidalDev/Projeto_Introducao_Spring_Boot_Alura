package com.pedro.demo.domain.medic;

public record MedicGetDataOutput(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public MedicGetDataOutput(Medic medic){
        this(medic.getId(), medic.getNome(), medic.getEmail(), medic.getCrm(), medic.getEspecialidade());
    }

}
