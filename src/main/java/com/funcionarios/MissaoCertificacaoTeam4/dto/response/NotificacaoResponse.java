package com.funcionarios.MissaoCertificacaoTeam4.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NotificacaoResponse {

    private Integer id;
    private Boolean notificado;
    private Integer parte_id;
    private Integer processo_id;

}
