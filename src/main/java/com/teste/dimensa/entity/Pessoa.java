package com.teste.dimensa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

  /*  @Column(name = "dataNascimento")
    private LocalDate dataNascimento;*/

    @OneToMany
    private List<Endereco> enderecoList;
}
