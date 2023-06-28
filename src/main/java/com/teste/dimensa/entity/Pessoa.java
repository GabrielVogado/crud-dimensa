package com.teste.dimensa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "Pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    @NotNull(message = "nome não pode ser nulo")
    @NotBlank(message = "nome não pode estar em Branco")
    @NotEmpty(message = "nome não pode estar vazio")
    private String nome;

    @Column(name = "email")
    @NotNull(message = "email não pode ser nulo")
    @NotBlank(message = "email não pode estar em Branco")
    @NotEmpty(message = "email não pode estar  Vazio")
    @Email(message = "Invalid email")
    private String email;

    @Column(name = "telefone")
    @NotNull(message = "telefone não pode ser nulo")
    @NotBlank(message = "telefone não pode estar em Branco")
    @NotEmpty(message = "telefone não pode estar Vazio")
    private String telefone;

    @Column(name = "data_nascimento")
    @NotBlank(message = "Data Nascimento não pode estar em Branco")
    @NotNull(message = "Data Nascimento não pode ser nulo")
    @NotEmpty(message = "Data Nascimento não pode ser vazio")
    private String dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> enderecos;
}
