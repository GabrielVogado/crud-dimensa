package com.teste.dimensa.controller;

import com.teste.dimensa.iservice.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    private IEnderecoService enderecoService;

    @Autowired
    public EnderecoController(IEnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
}
