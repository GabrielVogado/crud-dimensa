package com.teste.dimensa.service;

import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.iservice.IEnderecoService;
import com.teste.dimensa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    /**
     * @return
     */
    @Override
    public List<Endereco> listaEndereco() {
        return enderecoRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Endereco> buscaEndereco(Integer id) {
        return enderecoRepository.findById(id);
    }

    /**
     * @param enderecoDTO
     * @param id
     * @return
     */
    @Override
    public Endereco alterarEndereco(EnderecoDTO enderecoDTO, Integer id) {
        return enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setCep(enderecoDTO.getCep());
                    endereco.setRua(enderecoDTO.getRua());
                    endereco.setNumero(enderecoDTO.getNumero());
                    Endereco endrecoUpdate = enderecoRepository.save(endereco);
                    return ResponseEntity.ok().body(endrecoUpdate);
                }).orElse(ResponseEntity.notFound().build()).getBody();

    }

    /**
     * @param id
     */
    @Override
    public void excluirEndereco(Integer id) {
    enderecoRepository.deleteById(id);
    }
}
