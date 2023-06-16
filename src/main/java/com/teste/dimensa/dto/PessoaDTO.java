package com.teste.dimensa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    @NotNull(message = "Parametro nome não pode ser Nulo")
    @NotBlank(message = "Parametro nome não pode estar em Branco")
    private String nome;

    @NotNull(message = "Parametro email não pode ser Nulo")
    @NotBlank(message = "Parametro email não pode estar em Branco")
    private String email;

    @NotNull(message = "Parametro telefone não pode ser Nulo")
    @NotBlank(message = "Parametro telefone não pode estar em Branco")
    private String telefone;

    @NotNull(message = "Parametro dataNascimento não pode ser Nulo")
    @NotBlank(message = "Parametro dataNascimento não pode estar em Branco")
    private String dataNascimento;

    @NotNull(message = "Parametro enderecos não pode ser Nulo")
    @NotBlank(message = "Parametro enderecos não pode estar em Branco")
    private List<EnderecoDTO> enderecos;
}
