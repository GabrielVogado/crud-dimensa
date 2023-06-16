package com.teste.dimensa.iservice;

import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {
    List<Pessoa> listaPessoa();

    Pessoa insere(PessoaDTO pessoa);

    Pessoa alterar(UpdatePessoaDTO pessoa, Integer id);

    void excluir(Integer id);

    Optional<Pessoa> buscaPessoa(Integer id);
}
