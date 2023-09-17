package com.EstacioMCTeam4.controller;

import com.EstacioMCTeam4.controller.dto.request.FuncionarioRequest;
import com.EstacioMCTeam4.controller.dto.response.FuncionarioResponse;
import com.EstacioMCTeam4.service.funcionario.FuncionarioCrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionário", description = "API para gerenciamento de funcionários")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FuncionarioController {

  private final FuncionarioCrudService funcionarioCrudService;

  @PostMapping
  @Operation(summary = "Incluir funcionário", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public FuncionarioResponse incluir(@Valid @RequestBody FuncionarioRequest request) {

    return funcionarioCrudService.incluir(request);
  }

  @GetMapping
  @Operation(summary = "Listar funcionários", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public List<FuncionarioResponse> listar() {

    return funcionarioCrudService.listar();
  }

  @GetMapping("/paginado")
  @Operation(summary = "Listar funcionários com paginação", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public Page<FuncionarioResponse> listarPaginado(Pageable pageable) {

    return funcionarioCrudService.listarPaginado(pageable);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obter funcionário por ID", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public FuncionarioResponse obter(@PathVariable Long id) {

    return funcionarioCrudService.obterPorId(id);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Alterar funcionário por ID", method = "PUT")
  @ResponseStatus(HttpStatus.OK)
  public FuncionarioResponse alterar(
      @PathVariable Long id, @Valid @RequestBody FuncionarioRequest request) {

    return funcionarioCrudService.alterar(id, request);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Remover funcionário por ID", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public FuncionarioResponse remover(@PathVariable Long id) {

    return funcionarioCrudService.remover(id);
  }
}
