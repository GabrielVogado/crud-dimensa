package com.teste.dimensa.iservice;

import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.entity.Pessoa;

import java.util.List;

public interface IPessoaService {
    List<Pessoa> listaPessoa();

    Pessoa insere(PessoaDTO pessoa);

    Pessoa alterar(PessoaDTO pessoa, Integer id);

    void excluir(Integer id);

    Pessoa buscaPessoa(Integer id);
}
