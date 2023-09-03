package com.funcionarios.MissaoCertificacaoTeam4.controller;

import com.funcionarios.MissaoCertificacaoTeam4.dto.request.AlterarFuncionarioRequest;
import com.funcionarios.MissaoCertificacaoTeam4.dto.request.IncluirFuncionarioRequest;
import com.funcionarios.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.funcionarios.MissaoCertificacaoTeam4.service.funcionario.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionário", description = "API para gerenciamento de funcionários")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    private final IncluirFuncionarioService incluirFuncionarioService;

    private final ListarFuncionariosService listarFuncionariosService;

    private final ObterFuncionarioService obterFuncionarioService;

    private final AlterarFuncionarioService alterarFuncionarioService;

    private final RemoverFuncionarioService removerFuncionarioService;

    public FuncionarioController(IncluirFuncionarioService incluirFuncionarioService, ListarFuncionariosService listarFuncionariosService, ObterFuncionarioService obterFuncionarioService, AlterarFuncionarioService alterarFuncionarioService, RemoverFuncionarioService removerFuncionarioService) {
        this.incluirFuncionarioService = incluirFuncionarioService;
        this.listarFuncionariosService = listarFuncionariosService;
        this.obterFuncionarioService = obterFuncionarioService;
        this.alterarFuncionarioService = alterarFuncionarioService;
        this.removerFuncionarioService = removerFuncionarioService;
    }

    @PostMapping
    @Operation(summary = "Incluir funcionário", method = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioResponse incluir(@Valid @RequestBody IncluirFuncionarioRequest request) {
        return incluirFuncionarioService.incluir(request);
    }

    @GetMapping
    @Operation(summary = "Listar funcionários", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioResponse> listar() {
        return listarFuncionariosService.listar();
    }

    @GetMapping("/paginado")
    @Operation(summary = "Listar funcionários com paginação", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public Page<FuncionarioResponse> listarPaginado(Pageable pageable) {
        return listarFuncionariosService.listarPaginado(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter funcionário por ID", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse obter(@PathVariable Long id) {
        return obterFuncionarioService.obter(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar funcionário por ID", method = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse alterar(@PathVariable Long id, @Valid @RequestBody AlterarFuncionarioRequest request) {
        return alterarFuncionarioService.alterar(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover funcionário por ID", method = "DELETE")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponse remover(@PathVariable Long id) {
        return removerFuncionarioService.remover(id);
    }
}
