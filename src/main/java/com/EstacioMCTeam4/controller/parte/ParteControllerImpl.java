package com.EstacioMCTeam4.controller.parte;

import com.EstacioMCTeam4.service.parte.ParteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/partes")
@Tag(name = "Parte", description = "API para gerenciamento de partes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ParteControllerImpl implements ParteController {

    private final ParteService parteService;

    @PostMapping
    @Operation(summary = "criar parte", method = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public ParteResponse create(@Valid @RequestBody ParteRequest request) {

        return parteService.create(request);
    }

    @GetMapping
    @Operation(summary = "Listar partes", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public Set<ParteResponse> list() {

        return parteService.list();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter parte por ID", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ParteResponse getById(@PathVariable Long id) {

        return parteService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar parte por ID", method = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public ParteResponse update(@PathVariable Long id, @Valid @RequestBody ParteRequest request) {

        return parteService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover parte por ID", method = "DELETE")
    @ResponseStatus(HttpStatus.OK)
    public ParteResponse delete(@PathVariable Long id) {

        return parteService.delete(id);
    }
}
