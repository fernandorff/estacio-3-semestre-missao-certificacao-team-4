package com.EstacioMCTeam4.repository;

import com.EstacioMCTeam4.entity.Notificacao;
import com.EstacioMCTeam4.entity.enums.TipoNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    Set<Notificacao> findByNotificadoFalse();

    Set<Notificacao> findByNotificadoTrue();

    Set<Notificacao> findByTipoNotificacaoAndNotificadoFalse(TipoNotificacao tipoNotificacao);
}

