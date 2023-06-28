package com.teste.dimensa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rua")
    @NotNull(message = "Rua não pode ser Nulo")
    @NotBlank(message = "Rua não pode estar em Branco")
    @NotEmpty
    private String rua;

    @Column(name = "numero")
    @NotNull(message = "numero não pode ser Nulo")
    @NotBlank(message = "numero não pode estar em Branco")
    @NotEmpty
    private String numero;

    @Column(name = "cep")
    @NotNull(message = "cep não pode ser Nulo")
    @NotBlank(message = "cep não pode estar em Branco")
    @NotEmpty
    private String cep;

    @Column(name = "pessoa_id")
    private Integer pessoa_id;

}
