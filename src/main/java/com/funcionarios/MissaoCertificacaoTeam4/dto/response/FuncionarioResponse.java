package com.funcionarios.MissaoCertificacaoTeam4.dto.response;

import com.funcionarios.MissaoCertificacaoTeam4.entity.enums.Cargo;
import lombok.*;

import java.math.BigDecimal;

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
