package com.teste.dimensa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO {

    @NotNull(message = "Parametro Rua não pode ser Nulo")
    @NotBlank(message = "Parametro Rua não pode estar em Branco")
    private String rua;

    @NotNull(message = "Parametro Numero não pode ser Nulo")
    @NotBlank(message = "Parametro Numero não pode estar em Branco")
    private String numero;

    @NotNull(message = "Parametro Cep não pode ser Nulo")
    @NotBlank(message = "Parametro Cep não pode estar em Branco")
    private String cep;
}
