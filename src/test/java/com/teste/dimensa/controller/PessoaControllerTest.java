package com.teste.dimensa.controller;

import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.iservice.IPessoaService;
import com.teste.dimensa.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class PessoaControllerTest {

    @Mock
    private IPessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarPessoa() {
        // Mock do serviço de pessoa para retornar uma lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(Pessoa.builder().id(1).nome("João").build());
        pessoas.add(Pessoa.builder().id(2).nome("Maria").build());
        Mockito.when(pessoaService.listaPessoa()).thenReturn(pessoas);

        // Chamada do método listarPessoa() no controlador
        List<Pessoa> resultado = pessoaController.listarPessoa().getBody();

        // Verificação do resultado
        assertEquals(pessoas, resultado);
    }

    @Test
    public void testBuscaPessoaExistente() {
        // Mock do serviço de pessoa para retornar um objeto Optional contendo uma pessoa
        Pessoa pessoa = Pessoa.builder().id(1).nome("João").build();
        Mockito.when(pessoaService.buscaPessoa(1)).thenReturn(Optional.of(pessoa));

        // Chamada do método buscaPessoa() no controlador
        ResponseEntity<Pessoa> resultado = pessoaController.buscaPessoa(1);

        // Verificação do resultado
        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(pessoa, resultado.getBody());
    }

    @Test
    public void testBuscaPessoaInexistente() {
        // Mock do serviço de pessoa para retornar um objeto Optional vazio
        Mockito.when(pessoaService.buscaPessoa(1)).thenReturn(Optional.empty());

        // Chamada do método buscaPessoa() no controlador
        ResponseEntity<Pessoa> resultado = pessoaController.buscaPessoa(1);

        // Verificação do resultado
        assertEquals(HttpStatus.NOT_FOUND, resultado.getStatusCode());
    }

    @Test
    public void testSalvarPessoa() {
        // Mock do DTO de pessoa para salvar
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("João");

        // Mock do serviço de pessoa para retornar a pessoa salva
        Pessoa pessoaSalva = Pessoa.builder().id(1).nome("João").build();
        Mockito.when(pessoaService.insere(pessoaDTO)).thenReturn(pessoaSalva);

        // Chamada do método salvarPessoa() no controlador
        Pessoa resultado = pessoaController.salvarPessoa(pessoaDTO).getBody();

        // Verificação do resultado
        assertEquals(pessoaSalva, resultado);
    }

    @Test
    public void testAlterarPessoa() {

        UpdatePessoaDTO pessoaDTO = new UpdatePessoaDTO();
        pessoaDTO.setNome("João");
        pessoaDTO.setTelefone("6199999999");

        Integer id = 123;

        PessoaService pessoaService = Mockito.mock(PessoaService.class);
        Pessoa pessoaEsperada = new Pessoa();
        Mockito.when(pessoaService.alterar(pessoaDTO, id)).thenReturn(pessoaEsperada);

        // Execução
        Pessoa pessoaAtual = pessoaService.alterar(pessoaDTO, id);

        // Verificação
        assertEquals(pessoaEsperada, pessoaAtual);
        verify(pessoaService).alterar(pessoaDTO, id);
    }

    @Test
    public void testExcluirPessoa() {
        Integer pessoaId = 1;

        pessoaController.excluirPessoa(pessoaId);

        verify(pessoaService).excluir(pessoaId);
    }


}

