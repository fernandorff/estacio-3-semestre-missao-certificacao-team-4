package com.EstacioMCTeam4.entity;

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
  private Long id;

  private Boolean notificado;

  @ManyToOne private Parte parte;

  @ManyToOne private Processo processo;
}
