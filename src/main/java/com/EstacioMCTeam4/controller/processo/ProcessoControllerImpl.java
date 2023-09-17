package com.EstacioMCTeam4.controller.processo;

import com.EstacioMCTeam4.service.processo.ProcessoCrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesos")
@Tag(name = "Processo", description = "API para gerenciamento de processos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProcessoControllerImpl implements ProcessoController {

  private final ProcessoCrudService procesoCrudService;

  @PostMapping
  @Operation(summary = "criar processo", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public ProcessoResponse create(@Valid @RequestBody ProcessoRequest request) {

    return procesoCrudService.create(request);
  }

  @GetMapping
  @Operation(summary = "Listar processos", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public List<ProcessoResponse> list() {

    return procesoCrudService.list();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obter processo por ID", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public ProcessoResponse getById(@PathVariable Long id) {

    return procesoCrudService.getById(id);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Alterar processo por ID", method = "PUT")
  @ResponseStatus(HttpStatus.OK)
  public ProcessoResponse update(
      @PathVariable Long id, @Valid @RequestBody ProcessoRequest request) {

    return procesoCrudService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Remover processo por ID", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public ProcessoResponse delete(@PathVariable Long id) {

    return procesoCrudService.delete(id);
  }

  @PutMapping("/{id}/partes")
  @Operation(summary = "Adicionar partes a um processo", method = "PUT")
  @ResponseStatus(HttpStatus.CREATED)
  public ProcessoResponse addPartes(
      @PathVariable("id") Long processoId, @RequestParam("parteIds") List<Long> parteIds) {

    return procesoCrudService.addPartes(processoId, parteIds);
  }
}
