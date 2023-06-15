package com.teste.dimensa.controller;

import com.teste.dimensa.document.PessoaDocument;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
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
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.insere(pessoa);
    }

    @PutMapping("/altera-pessoa")
    public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.alterar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Integer id) {
        pessoaService.excluir(id);
    }
}
