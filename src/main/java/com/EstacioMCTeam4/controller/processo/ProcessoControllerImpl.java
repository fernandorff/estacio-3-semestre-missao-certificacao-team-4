package com.EstacioMCTeam4.controller.processo;

import com.EstacioMCTeam4.service.processo.ProcessoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/processos")
@Tag(name = "Processo", description = "API para gerenciamento de processos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProcessoControllerImpl implements ProcessoController {

    private final ProcessoService processoService;

    @PostMapping
    @Operation(summary = "criar processo", method = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoResponse create(@Valid @RequestBody ProcessoRequest request) {

        return processoService.create(request);
    }

    @GetMapping
    @Operation(summary = "Listar processos", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProcessoResponse> list() {

        return processoService.list();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter processo por ID", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ProcessoResponse getById(@PathVariable Long id) {

        return processoService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar processo por ID", method = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public ProcessoResponse update(
            @PathVariable Long id, @Valid @RequestBody ProcessoRequest request) {

        return processoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover processo por ID", method = "DELETE")
    @ResponseStatus(HttpStatus.OK)
    public ProcessoResponse delete(@PathVariable Long id) {

        return processoService.delete(id);
    }

    @PutMapping("/{id}/adicionar-partes")
    @Operation(summary = "Adicionar partes a um processo", method = "PUT")
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoResponse addPartes(
            @PathVariable("id") Long processoId, @RequestBody Set<Long> parteIds) {

        return processoService.addPartes(processoId, parteIds);
    }
}
