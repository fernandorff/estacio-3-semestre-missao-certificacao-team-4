package com.EstacioMCTeam4.controller.dto.response.notificacao;

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
}
