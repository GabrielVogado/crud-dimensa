package com.teste.dimensa.document;

import com.teste.dimensa.dto.EnderecoDTO;
import com.teste.dimensa.entity.Endereco;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface EnderecoDocument {

    @Operation(summary = "Busca uma Lista de Enderecos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class)) }),
            @ApiResponse(responseCode = "204", description = "Lista não encontrada",
                    content = @Content) })
    List<Endereco> listarEndereco();

    @Operation(summary = "Busca Endereco por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class)) }),
            @ApiResponse(responseCode = "204", description = "Endereco não encontrada",
                    content = @Content) })
    Optional<Endereco> buscaEndereco(Integer id);

    @Operation(summary = "Altera Dados de uma Endereco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco Alterada com Sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao Alterar Objeto",
                    content = @Content) })
    Endereco alterarEndereco(@Parameter(description = "Dados pertinentes para o Alteração de Enderecos") @RequestBody EnderecoDTO Endereco, Integer id);

    @Operation(summary = "Excluir Dados de uma Endereco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereco Excluida com Sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Endereco.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao Alterar Objeto",
                    content = @Content) })
    void excluirEndereco(@Parameter(description = "Dados pertinentes para o Exclusão de Enderecos") @PathVariable Integer id);
}
