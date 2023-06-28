package com.teste.dimensa.controller;

import com.teste.dimensa.document.PessoaDocument;
import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PessoaController implements PessoaDocument {

    private final IPessoaService pessoaService;

    @Autowired
    public PessoaController(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/lista-pessoa")
    public List<Pessoa> listarPessoa() {
        return pessoaService.listaPessoa();
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> buscaPessoa(@PathVariable Integer id) {
        return pessoaService.buscaPessoa(id).map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insere-pessoa")
    public @Valid @ResponseBody Pessoa salvarPessoa(@RequestBody @Valid PessoaDTO pessoa) {
        return pessoaService.insere(pessoa);
    }

    @PutMapping("/altera-pessoa/{id}")
    public Pessoa alterarPessoa(@RequestBody @Valid UpdatePessoaDTO pessoa, @PathVariable Integer id) {
        return pessoaService.alterar(pessoa, id);
    }

    @DeleteMapping("/excluir-pessoa/{id}")
    public void excluirPessoa(@PathVariable Integer id) {
        pessoaService.excluir(id);
    }
}
