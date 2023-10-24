package com.pedro.demo.domain.medic;

import com.pedro.demo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DataEditMedic (
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){
}
