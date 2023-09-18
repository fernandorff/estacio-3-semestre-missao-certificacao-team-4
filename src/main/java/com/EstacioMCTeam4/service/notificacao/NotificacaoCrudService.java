package com.EstacioMCTeam4.service.notificacao;

import com.EstacioMCTeam4.controller.notificacao.NotificacaoRequest;
import com.EstacioMCTeam4.controller.notificacao.NotificacaoResponse;
import jakarta.validation.Valid;

import java.util.Set;

public interface NotificacaoCrudService {

  Set<NotificacaoResponse> list();

  NotificacaoResponse getById(Long id);

  NotificacaoResponse create(@Valid NotificacaoRequest request);

  NotificacaoResponse update(Long id, NotificacaoRequest request);

  NotificacaoResponse delete(Long id);
}
