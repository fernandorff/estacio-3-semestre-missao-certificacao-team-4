package com.EstacioMCTeam4.controller.notificacao;

import com.EstacioMCTeam4.controller.notificacao.NotificacaoResponse;
import com.EstacioMCTeam4.service.notificacao.NotificacaoCrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacacoes")
@Tag(name = "Notificacao", description = "API para gerenciamento de notificacoes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NotificacaoControllerImpl implements NotificacaoController {

  private final NotificacaoCrudService notificacaoCrudService;

  @PostMapping
  @Operation(summary = "criar notificacao", method = "POST")
  @ResponseStatus(HttpStatus.CREATED)
  public NotificacaoResponse create(@Valid @RequestBody NotificacaoRequest request) {

    return notificacaoCrudService.create(request);
  }

  @GetMapping
  @Operation(summary = "Listar intimacoes", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public Set<NotificacaoResponse> list() {

    return notificacaoCrudService.list();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Obter notificacao por ID", method = "GET")
  @ResponseStatus(HttpStatus.OK)
  public NotificacaoResponse getById(@PathVariable Long id) {

    return notificacaoCrudService.getById(id);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Alterar notificacao por ID", method = "PUT")
  @ResponseStatus(HttpStatus.OK)
  public NotificacaoResponse update(@PathVariable Long id, @Valid @RequestBody NotificacaoRequest request) {

    return notificacaoCrudService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Remover notificacao por ID", method = "DELETE")
  @ResponseStatus(HttpStatus.OK)
  public NotificacaoResponse delete(@PathVariable Long id) {

    return notificacaoCrudService.delete(id);
  }
}
