package com.teste.dimensa.service;


import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.dto.PessoaDTO;
import com.teste.dimensa.dto.UpdatePessoaDTO;
import com.teste.dimensa.entity.Pessoa;
import com.teste.dimensa.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListaPessoa() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(Pessoa.builder().nome("John").build());
        pessoas.add(Pessoa.builder().nome("Jane").build());

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> result = pessoaService.listaPessoa();

        assertEquals(pessoas, result);
        verify(pessoaRepository, times(1)).findAll();
    }

    @Test
    void testInsere() {

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("João");
        pessoaDTO.setDataNascimento(LocalDate.parse("1990-01-01"));
        pessoaDTO.setEmail("joao@example.com");
        pessoaDTO.setTelefone("1234567890");

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rua A");
        enderecoDTO.setNumero("123");
        enderecoDTO.setCep("123456");
        List<EnderecoDTO> enderecos = new ArrayList<>();
        enderecos.add(enderecoDTO);
        pessoaDTO.setEnderecos(enderecos);

        Pessoa pessoaSalva = new Pessoa();
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaSalva);

        Pessoa result = pessoaService.insere(pessoaDTO);

        assertEquals(pessoaSalva, result);
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void testAlterar() {
        UpdatePessoaDTO updatePessoaDTO = new UpdatePessoaDTO();
        updatePessoaDTO.setNome("John");

        Pessoa pessoa = Pessoa.builder().nome("Jane").build();

        when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa result = pessoaService.alterar(updatePessoaDTO, 1);

        assertEquals("John", result.getNome());
        verify(pessoaRepository, times(1)).findById(1);
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void testExcluir() {
        pessoaService.excluir(1);
        verify(pessoaRepository, times(1)).deleteById(1);
    }

    @Test
    void testBuscaPessoaExistente() {
        Integer id = 1;
        Pessoa pessoaExistente = Pessoa.builder().id(id).nome("Ana").build();
        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoaExistente));

        Optional<Pessoa> resultado = pessoaService.buscaPessoa(id);

        assertTrue(resultado.isPresent());
        assertEquals(pessoaExistente, resultado.get());
    }

    @Test
    void testBuscaPessoaInexistente() {
        Integer id = 2;
        when(pessoaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Pessoa> resultado = pessoaService.buscaPessoa(id);

        assertFalse(resultado.isPresent());
        assertEquals(Optional.empty(), resultado);
    }
}