package com.EstacioMCTeam4.controller.notificacao;

import com.EstacioMCTeam4.controller.parte.ParteResponse;

import java.util.Set;

public interface NotificacaoController {

  NotificacaoResponse create(NotificacaoRequest request);

  Set<NotificacaoResponse> list();
  NotificacaoResponse getById(Long id);

  NotificacaoResponse update(Long id, NotificacaoRequest request);

  NotificacaoResponse delete(Long id);
}
