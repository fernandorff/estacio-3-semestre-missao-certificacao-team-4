package com.funcionarios.MissaoCertificacaoTeam4.dto.response;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ParteResponse {
    private Integer id;
    private Integer processo_id;
    private String bairro;
    private String cep;
    private String cidade;
    private String documento;
    private String email;
    private String estado;
    private String nome_completo;
    private String nome_rua;
    private String numero_rua;
}
