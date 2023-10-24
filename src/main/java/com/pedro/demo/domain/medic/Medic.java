package com.pedro.demo.domain.medic;

import com.pedro.demo.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medics")
@Entity(name="Medic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean lativo;

    public Medic(DataRegisterMedic data) {
        this.lativo = true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    public void actualizeData(DataEditMedic data){
        if(data.nome() != null){
            this.nome = data.nome();
        }

        if(data.telefone() != null){
            this.telefone = data.telefone();
        }

        if(data.endereco() != null){
            this.endereco.actualizeData(data.endereco());
        }
    }

    public void actualizeLativo(){
        if(this.lativo){
            this.lativo = false;
        } else{
            this.lativo = true;
        }

    }
}
