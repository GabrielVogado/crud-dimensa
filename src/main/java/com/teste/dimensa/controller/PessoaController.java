package com.teste.dimensa.controller;

import com.teste.dimensa.document.PessoaDocument;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaController implements PessoaDocument {

    private IPessoaService pessoaService;

    @Autowired
    public PessoaController(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/lista-pessoa")
    public List<Pessoa> listarPessoa() {
        return pessoaService.listaPessoa();
    }

    @PostMapping("/insere-pessoa")
    public Pessoa cadastrarContato(@RequestBody Pessoa pessoa) {
        return pessoaService.insere(pessoa);
    }

}
