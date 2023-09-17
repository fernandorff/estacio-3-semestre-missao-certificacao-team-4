package com.EstacioMCTeam4.entity;

import com.EstacioMCTeam4.entity.enums.Cargo;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Entity
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String cpf;

  @Enumerated(EnumType.STRING)
  private Cargo cargo;

  private BigDecimal salario;
}
