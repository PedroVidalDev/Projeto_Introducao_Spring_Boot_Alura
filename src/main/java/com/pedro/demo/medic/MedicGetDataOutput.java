package com.pedro.demo.medic;

import ch.qos.logback.core.joran.spi.ElementSelector;

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
