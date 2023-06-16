package com.teste.dimensa.iservice;

import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;

import java.util.List;
import java.util.Optional;

public interface IEnderecoService {
    List<Endereco> listaEndereco();

    Optional<Endereco> buscaEndereco(Integer id);

    Endereco alterarEndereco(EnderecoDTO pessoa, Integer id);

    void excluirEndereco(Integer id);
}
