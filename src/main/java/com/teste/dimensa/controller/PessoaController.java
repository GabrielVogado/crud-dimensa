package com.teste.dimensa.controller;

import com.teste.dimensa.iservice.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    private IPessoaService pessoaService;

    @Autowired
    public PessoaController(IPessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
}
