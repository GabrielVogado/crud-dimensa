package com.teste.dimensa.service;

import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;
import com.teste.dimensa.repository.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Criar uma classe de teste para EnderecoService
class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListaEndereco() {
        // Arrange
        List<Endereco> listaEsperada = new ArrayList<>();
        when(enderecoRepository.findAll()).thenReturn(listaEsperada);

        // Act
        List<Endereco> listaObtida = enderecoService.listaEndereco();

        // Assert
        assertEquals(listaEsperada, listaObtida);
        verify(enderecoRepository).findAll();
    }

    @Test
    public void testBuscaEndereco() {
        // Arrange
        Integer id = 1;
        Endereco enderecoEsperado = new Endereco();
        when(enderecoRepository.findById(id)).thenReturn(Optional.of(enderecoEsperado));

        // Act
        Optional<Endereco> enderecoObtido = enderecoService.buscaEndereco(id);

        // Assert
        assertEquals(Optional.of(enderecoEsperado), enderecoObtido);
        verify(enderecoRepository).findById(id);
    }

    @Test
    public void testAlterarEndereco() {
        // Arrange
        Integer id = 1;
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        Endereco enderecoExistente = new Endereco();
        when(enderecoRepository.findById(id)).thenReturn(Optional.of(enderecoExistente));
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(enderecoExistente);

        // Act
        Endereco enderecoAtualizado = enderecoService.alterarEndereco(enderecoDTO, id);

        // Assert
        assertEquals(enderecoExistente, enderecoAtualizado);
        verify(enderecoRepository).findById(id);
        verify(enderecoRepository).save(enderecoExistente);
    }

    @Test
    public void testExcluirEndereco() {
        // Arrange
        Integer id = 1;

        // Act
        enderecoService.excluirEndereco(id);

        // Assert
        verify(enderecoRepository).deleteById(id);
    }
}