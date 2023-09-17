package com.EstacioMCTeam4.controller.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ParteResponse {

  private Long id;

  private Long processoId;

  private String bairro;

  private String cep;

  private String cidade;

  private String documento;

  private String email;

  private String estado;

  private String nomeCompleto;

  private String nomeRua;

  private String numeroRua;
}
