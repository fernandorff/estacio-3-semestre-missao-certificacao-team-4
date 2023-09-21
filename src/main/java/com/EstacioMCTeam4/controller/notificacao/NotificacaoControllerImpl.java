package com.EstacioMCTeam4.controller.notificacao;

import com.EstacioMCTeam4.entity.Notificacao;
import com.EstacioMCTeam4.service.notificacao.NotificacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/notificacoes")
@Tag(name = "Notificacao", description = "API para gerenciamento de notificacoes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NotificacaoControllerImpl implements NotificacaoController {

    private final NotificacaoService notificacaoService;

    @GetMapping("/realizadas")
    @Operation(summary = "Retorna todas as notificações já realizadas", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> getAllNotificados() {
        Set<Notificacao> notificacoes = notificacaoService.getAllNotificados();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/pendentes")
    @Operation(summary = "Retorna todas as notificações pendentes", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> getAllNaoNotificados() {
        Set<Notificacao> notificacoes = notificacaoService.getAllNaoNotificados();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/ecarta")
    @Operation(summary = "Exibe todas as notificações pendentes a serem executadas pelo E-Carta", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> getNotificacoesECarta() {
        Set<Notificacao> notificacoes = notificacaoService.getNotificacoesECarta();
        return ResponseEntity.ok(notificacoes);
    }

    @PutMapping("/notificar-e-carta")
    @Operation(summary = "Verifica se existem no mínimo 10 notificações a serem enviadas pelo E-Carta, caso sim, envia as notificações.", method = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> notificarByECarta() {
        Set<Notificacao> notificacoes = notificacaoService.notificarByECarta();
        return ResponseEntity.ok(notificacoes);
    }

    @GetMapping("/dje")
    @Operation(summary = "Exibe todas as notificações pendentes a serem realizadas pelo DJE.", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> getNotificacoesDje() {
        Set<Notificacao> notificacoes = notificacaoService.getNotificacoesDje();
        return ResponseEntity.ok(notificacoes);
    }

    @PutMapping("/notificar-dje")
    @Operation(summary = "Efetiva todas as notificações pendentes no DJE", method = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> notificarByDje() {
        Set<Notificacao> notificacoes = notificacaoService.notificarByDje();
        return ResponseEntity.ok(notificacoes);
    }

    @PostMapping("/notificar-processo/{processoId}")
    @Operation(summary = "Registra notificações para todas as partes do processo.", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<Notificacao>> notifyPartesByProcesso(Long processoId) {
        Set<Notificacao> notificacoes = notificacaoService.notifyPartesByProcesso(processoId);
        return ResponseEntity.ok(notificacoes);
    }
}
