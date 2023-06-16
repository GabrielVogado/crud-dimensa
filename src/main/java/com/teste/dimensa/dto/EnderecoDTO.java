package com.teste.dimensa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO {

    private String rua;

    private String numero;

    private String cep;
}
