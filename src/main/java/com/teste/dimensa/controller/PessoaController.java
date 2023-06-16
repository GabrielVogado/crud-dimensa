package com.teste.dimensa.controller;

import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    private IPessoaService pessoaService;

    @Autowired
    public PessoaController(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/lista-pessoa")
    public List<Pessoa> listarPessoa() {
        return pessoaService.listaPessoa();
    }

    @GetMapping("/pessoa/{id}")
    public Pessoa buscaPessoa(Integer id) {
        return pessoaService.buscaPessoa(id);
    }

    @PostMapping("/insere-pessoa")
    public Pessoa salvarPessoa(@RequestBody PessoaDTO pessoa) {
        return pessoaService.insere(pessoa);
    }

    @PutMapping("/altera-pessoa/{id}")
    public Pessoa alterarPessoa(@RequestBody PessoaDTO pessoa, @PathVariable Integer id) {
        return pessoaService.alterar(pessoa, id);
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Integer id) {
        pessoaService.excluir(id);
    }
}
