package com.pedro.demo.patients;

import com.pedro.demo.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="patients")
@Entity(name="Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Endereco endereco;
    private int quarto;

    public Patient(PatientCreateDTO data){
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.endereco = new Endereco(data.endereco());
        this.quarto = data.quarto();
    }

    public void actualizeData(PatiendEditDTO data){
        if(data.nome() != null){
            this.nome = data.nome();
        }

        if(data.telefone() != null){
            this.telefone = data.telefone();
        }

        // Cant add a quarto validation here
    }
}
