package com.MissaoCertificacaoTeam4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(of = "id")
@Entity
@Table(name = "processo")
public class Processo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String numero;

  @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
  private List<Parte> partes;

  @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
  private List<Notificacao> notificacoes;

}
