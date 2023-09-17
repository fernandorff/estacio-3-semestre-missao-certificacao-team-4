package com.EstacioMCTeam4.controller.notificacao;

import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NotificacaoResponse {

  private Long id;

  private Boolean notificado;

  private Long parteId;

  private Long processoId;

  private LocalDateTime dataHoraCriacao;
}
