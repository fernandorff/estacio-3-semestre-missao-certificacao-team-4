package com.EstacioMCTeam4.controller.dto.response;

import com.EstacioMCTeam4.entity.enums.Cargo;
import java.math.BigDecimal;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FuncionarioResponse {

  private Long id;

  private String nome;

  private String cpf;

  private Cargo cargo;

  private String cargoString;

  private BigDecimal salario;
}
