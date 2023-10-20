package com.pedro.demo.medic;

import com.pedro.demo.endereco.DadosEndereco;
import com.pedro.demo.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DataEditMedic (
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){
}
