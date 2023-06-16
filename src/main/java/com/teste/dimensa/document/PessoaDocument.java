package com.teste.dimensa.document;

import com.teste.dimensa.entity.Pessoa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PessoaDocument {

    @Operation(summary = "Busca uma Lista de Pessoas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pessoa.class)) }),
            @ApiResponse(responseCode = "204", description = "Lista não encontrada",
                    content = @Content) })
    List<Pessoa> listarPessoa();

    @Operation(summary = "Busca Pessoa por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pessoa.class)) }),
            @ApiResponse(responseCode = "204", description = "Pessoa não encontrada",
                    content = @Content) })
    Pessoa buscaPessoa(Integer id);

    @Operation(summary = "Insere Dados de uma Pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa Inserida com Sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pessoa.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao Inserir Objeto",
                    content = @Content) })
    Pessoa salvarPessoa(@Parameter(description = "Dados pertinentes para o cadastro de Pessoas") @RequestBody Pessoa pessoa);

    @Operation(summary = "Altera Dados de uma Pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa Alterada com Sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pessoa.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao Alterar Objeto",
                    content = @Content) })
    Pessoa alterarPessoa(@Parameter(description = "Dados pertinentes para o Alteração de Pessoas") @RequestBody Pessoa pessoa);

    @Operation(summary = "Excluir Dados de uma Pessoa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa Excluida com Sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Pessoa.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao Alterar Objeto",
                    content = @Content) })
    void excluirPessoa(@Parameter(description = "Dados pertinentes para o Exclusão de Pessoas") @PathVariable Integer id);
}
