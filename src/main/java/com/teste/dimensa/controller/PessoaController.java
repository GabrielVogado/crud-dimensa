package com.teste.dimensa.controller;

import com.teste.dimensa.document.PessoaDocument;
import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController implements PessoaDocument {

    private final IPessoaService pessoaService;

    @Autowired
    public PessoaController(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/lista-pessoa")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<List<Pessoa>> listarPessoa() {
        List<Pessoa> listPessoa = pessoaService.listaPessoa();
        if (!listPessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(listPessoa);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listPessoa);
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> buscaPessoa(@PathVariable Integer id) {
        Optional<Pessoa> pessoa = pessoaService.buscaPessoa(id);
        return pessoa.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).body(null));
    }

    @PostMapping("/insere-pessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity<Pessoa> salvarPessoa(@RequestBody @Valid PessoaDTO pessoa) {

        Pessoa pessoaResponse = pessoaService.insere(pessoa);
        if (ObjectUtils.isEmpty(pessoaResponse)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pessoaResponse);

    }

    @PutMapping("/altera-pessoa/{id}")
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody @Valid UpdatePessoaDTO pessoa, @PathVariable Integer id) {
        Pessoa pessoaupdate = pessoaService.alterar(pessoa, id);
        if (ObjectUtils.isEmpty(pessoaupdate)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaupdate);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(pessoaupdate);

    }

    @DeleteMapping("/excluir-pessoa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirPessoa(@PathVariable Integer id) {
        pessoaService.excluir(id);
    }
}
