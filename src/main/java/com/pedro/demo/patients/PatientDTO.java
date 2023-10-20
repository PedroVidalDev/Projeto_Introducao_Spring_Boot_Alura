package com.pedro.demo.patients;

import com.pedro.demo.endereco.DadosEndereco;
import com.pedro.demo.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

public record PatientDTO (
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull @Valid DadosEndereco endereco,
        @NotNull int quarto
){
}
