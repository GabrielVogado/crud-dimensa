package com.teste.dimensa.iservice;

import com.teste.dimensa.entity.Pessoa;

import java.util.List;

public interface IPessoaService {
    List<Pessoa> listaPessoa();

    Pessoa insere(Pessoa pessoa);

    Pessoa alterar(Pessoa pessoa);

    void excluir(Integer id);

    Pessoa buscaPessoa(Integer id);
}
