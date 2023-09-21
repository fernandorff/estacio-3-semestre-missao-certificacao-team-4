package com.EstacioMCTeam4.service.notificacao;

import com.EstacioMCTeam4.entity.Notificacao;

import java.util.Set;

public interface NotificacaoService {

    Set<Notificacao> getAllNotificados();

    Set<Notificacao> getAllNaoNotificados();

    Set<Notificacao> getNotificacoesECarta();

    Set<Notificacao> notificarByECarta();

    Set<Notificacao> getNotificacoesDje();

    Set<Notificacao> notificarByDje();

    Set<Notificacao> notifyPartesByProcesso(Long processoId);
}
