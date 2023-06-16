package com.teste.dimensa.service;


import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import com.teste.dimensa.repository.EnderecoRepository;
import com.teste.dimensa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements IPessoaService {

    private final PessoaRepository pessoaRepository;
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
    public Pessoa insere(PessoaDTO pessoa) {
        List<Endereco> enderecoEntity = preencheListaEndereco(pessoa.getEnderecos());
        Pessoa pessoaEntity = Pessoa.builder()
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .email(pessoa.getEmail())
                .telefone(pessoa.getTelefone())
                .enderecos(enderecoEntity).build();
        return pessoaRepository.save(pessoaEntity);
    }

    private List<Endereco> preencheListaEndereco(List<EnderecoDTO> enderecos) {
        List<Endereco> enderecoList = new ArrayList<>();
        for (EnderecoDTO endereco : enderecos) {
            Endereco enderecoentity = Endereco.builder()
                    .cep(endereco.getCep())
                    .rua(endereco.getRua())
                    .numero(endereco.getNumero()).build();
            enderecoList.add(enderecoentity);
        }
        return enderecoList;
    }

    /**
     * @param pessoa
     * @return
     */
    @Override
    public Pessoa alterar(PessoaDTO pessoa, Integer id) {
        Optional<Pessoa> pessoaUpdate = pessoaRepository.findById(id);
        if (pessoaUpdate.isPresent()) {
            Pessoa pessoaEntity = Pessoa.builder()
                    .id(id)
                    .nome(pessoa.getNome())
                    .dataNascimento(pessoa.getDataNascimento())
                    .email(pessoa.getEmail())
                    .telefone(pessoa.getTelefone())
                    .enderecos(updateEndereco(pessoa, id)).build();
           return pessoaRepository.save(pessoaEntity);
        }else {
            throw new IllegalArgumentException("Pessoa já cadastrada");
        }
    }

    private List<Endereco> updateEndereco(PessoaDTO pessoaUpdate, Integer id) {
        List<Endereco> enderecos = new ArrayList<>();
            for (EnderecoDTO endereco: pessoaUpdate.getEnderecos()){
                Endereco endrecoBuilder = Endereco.builder()
                        .pessoa_id(BigInteger.valueOf(id))
                        .rua(endereco.getRua())
                        .cep(endereco.getCep())
                        .numero(endereco.getNumero()).build();

                enderecos.add(endrecoBuilder);
            }
            return enderecos;
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
