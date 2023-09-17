package com.EstacioMCTeam4.controller.parte;

import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ParteResponse {

  private Long id;

  private String nomeCompleto;

  private String documento;

  private String email;

  private String numeroEndereco;

  private String complementoEndereco;

  @JsonIgnoreProperties({"partes"})
  private EnderecoBaseCep enderecoBaseCEP;

  @JsonIgnoreProperties({"partes"})
  private ProcessoResponse processo;

  private LocalDateTime dataHoraCriacao;
}
