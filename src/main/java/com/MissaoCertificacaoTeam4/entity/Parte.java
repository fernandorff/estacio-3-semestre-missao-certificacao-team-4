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
@Table(name = "parte")
public class Parte {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nomeCompleto;

  private String documento;

  private String email;

  private String cep;

  private String numeroRua;

  private String nomeRua;

  private String bairro;

  private String cidade;

  private String estado;

  @OneToMany(mappedBy = "parte", cascade = CascadeType.ALL)
  private List<Notificacao> notificacoes;

  @ManyToOne()
  private Processo processo;

}