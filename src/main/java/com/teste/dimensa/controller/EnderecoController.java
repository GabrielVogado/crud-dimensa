package com.teste.dimensa.controller;

import com.teste.dimensa.document.EnderecoDocument;
import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.iservice.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController implements EnderecoDocument {

    private final IEnderecoService enderecoService;

    @Autowired
    public EnderecoController(IEnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @GetMapping("/lista-endereco")
    public List<Endereco> listarEndereco() {
        return enderecoService.listaEndereco();
    }

    @GetMapping("/endereco/{id}")
    public Optional<Endereco> buscaEndereco(@Valid @PathVariable Integer id) {
        return enderecoService.buscaEndereco(id);
    }

    @PutMapping("/altera-endereco/{id}")
    public Endereco alterarEndereco(@Valid@RequestBody EnderecoDTO Endereco, @Valid@PathVariable Integer id) {
        return enderecoService.alterarEndereco(Endereco, id);
    }

    @DeleteMapping("/excluir-endereco/{id}")
    public void excluirEndereco(@Valid @PathVariable Integer id) {
        enderecoService.excluirEndereco(id);
    }

}
