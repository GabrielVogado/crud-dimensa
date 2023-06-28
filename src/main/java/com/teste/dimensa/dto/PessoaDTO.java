package com.teste.dimensa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    @NotNull(message = "Parametro nome não pode ser Nulo")
    @NotBlank(message = "Parametro nome não pode estar em Branco")
    @NotEmpty
    private String nome;

    @NotNull(message = "Parametro email não pode ser Nulo ou Formato Invalido")
    @NotBlank(message = "Parametro email não pode estar em Branco")
    @Email(message = "Invalid email")
    @NotEmpty
    private String email;

    @NotNull(message = "Parametro telefone não pode ser Nulo")
    @NotBlank(message = "Parametro telefone não pode estar em Branco")
    @NotEmpty
    private String telefone;

    @NotNull(message = "Parametro dataNascimento não pode ser Nulo")
    private LocalDate dataNascimento;

    private List<EnderecoDTO> enderecos;
}
