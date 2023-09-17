package com.MissaoCertificacaoTeam4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = "id")
@Entity
@Table(name = "notificacao")
public class Notificacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private boolean notificado;

  @ManyToOne
  private Parte parte;

  @ManyToOne
  private Processo processo;

}