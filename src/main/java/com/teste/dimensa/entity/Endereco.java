package com.teste.dimensa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "Endereco")
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {

    @Id
    private Integer id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "pessoaID", foreignKey = @ForeignKey(name = "FK_Pessoa_Endereco"))
    private Pessoa pessoa;
}
