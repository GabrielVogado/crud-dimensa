package com.teste.dimensa.controller;

import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.iservice.IEnderecoService;
import com.teste.dimensa.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EnderecoControllerTest {
    @Mock
    private IEnderecoService enderecoService;

    @InjectMocks
    private EnderecoController enderecoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarEndereco() {

        List<Endereco> enderecoList = Arrays.asList(new Endereco(), new Endereco());
        when(enderecoService.listaEndereco()).thenReturn(enderecoList);

        List<Endereco> result = enderecoController.listarEndereco();

        assertEquals(enderecoList.size(), result.size());
        verify(enderecoService, times(1)).listaEndereco();
    }

    @Test
    void testBuscaEndereco() {

        Optional<Endereco> endereco = Optional.of(new Endereco());
        when(enderecoService.buscaEndereco(1)).thenReturn(endereco);

        Optional<Endereco> result = enderecoController.buscaEndereco(1);

        assertTrue(result.isPresent());
        verify(enderecoService, times(1)).buscaEndereco(1);
    }

    @Test
    void testAlterarEndereco() {

        EnderecoService enderecoService = Mockito.mock(EnderecoService.class);
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        Integer id = 123;

        Endereco enderecoRetornado = new Endereco();
        Mockito.when(enderecoService.alterarEndereco(Mockito.eq(enderecoDTO), Mockito.eq(id))).thenReturn(enderecoRetornado);

        Endereco resultado = enderecoService.alterarEndereco(enderecoDTO, id);
        assertEquals(enderecoRetornado, resultado);

    }

    @Test
    void testExcluirEndereco() {

        enderecoController.excluirEndereco(1);
        verify(enderecoService, times(1)).excluirEndereco(1);
    }
}
