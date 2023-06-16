package com.teste.dimensa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    private String nome;

    private String email;

    private String telefone;

    private String dataNascimento;

    private List<EnderecoDTO> enderecos;
}
