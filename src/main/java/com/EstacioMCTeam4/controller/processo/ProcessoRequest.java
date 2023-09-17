package com.EstacioMCTeam4.controller.processo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProcessoRequest {

  @NotBlank(message = "O campo número não pode estar vazio.")
  String numero;
}
