package com.EstacioMCTeam4.controller.notificacao;

import com.EstacioMCTeam4.entity.Notificacao;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface NotificacaoController {

    ResponseEntity<Set<Notificacao>> getAllNotificados();

    ResponseEntity<Set<Notificacao>> getAllNaoNotificados();

    ResponseEntity<Set<Notificacao>> getNotificacoesECarta();

    ResponseEntity<Set<Notificacao>> notificarByECarta();

    ResponseEntity<Set<Notificacao>> getNotificacoesDje();

    ResponseEntity<Set<Notificacao>> notificarByDje();

    ResponseEntity<Set<Notificacao>> notifyPartesByProcesso(Long processoId);
}
