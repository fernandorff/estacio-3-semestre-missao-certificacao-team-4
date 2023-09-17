package com.EstacioMCTeam4.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "id")
@Entity
@Table(name = "processo")
public class Processo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numero;

  @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
  private List<Parte> partes;

  @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
  private List<Notificacao> notificacoes;
}
