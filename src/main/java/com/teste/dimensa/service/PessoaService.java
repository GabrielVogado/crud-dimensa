package com.teste.dimensa.service;

import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import com.teste.dimensa.repository.EnderecoRepository;
import com.teste.dimensa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements IPessoaService {

    private PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository,
                         EnderecoRepository enderecoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    /**
     * @return
     */
    @Override
    public List<Pessoa> listaPessoa() {
        return pessoaRepository.findAll();
    }

    /**
     * @param pessoa
     * @return
     */
    @Override
    public Pessoa insere(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    /**
     * @param pessoa
     * @return
     */
    @Override
    public Pessoa alterar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    /**
     * @param id
     */
    @Override
    public void excluir(Integer id) {
        pessoaRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Pessoa buscaPessoa(Integer id) {
        return pessoaRepository.findById(id).get();
    }

}
