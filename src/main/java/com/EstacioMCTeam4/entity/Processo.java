package com.EstacioMCTeam4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Entity
public class Processo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numero;

  @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
  private List<Parte> partes;

  private LocalDateTime dataHoraCriacao = LocalDateTime.now();
}
