package com.teste.dimensa.service;


import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import com.teste.dimensa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.teste.dimensa.utils.Utils.*;

@Service
public class PessoaService implements IPessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
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
                .dataNascimento(formatadorDeData(pessoa.getDataNascimento()))
                .email(isValidEmailAddress(pessoa.getEmail()) ? pessoa.getEmail() : null)
                .telefone(validarTelefone(pessoa.getTelefone())? pessoa.getTelefone() : null)
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
    public Pessoa alterar(UpdatePessoaDTO pessoa, Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoaUpdate -> {
                    pessoaUpdate.setNome(pessoa.getNome());
                    pessoaUpdate.setEmail(pessoa.getEmail());
                    pessoaUpdate.setTelefone(pessoa.getTelefone());
                    pessoaUpdate.setDataNascimento(String.valueOf(pessoa.getDataNascimento()));
                    Pessoa updated = pessoaRepository.save(pessoaUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build()).getBody();
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
    public Optional<Pessoa> buscaPessoa(Integer id) {
        return pessoaRepository.findById(id);
    }

}
