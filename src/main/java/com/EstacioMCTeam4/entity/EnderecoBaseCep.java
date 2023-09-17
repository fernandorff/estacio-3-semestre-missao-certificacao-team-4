package com.EstacioMCTeam4.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
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
public class EnderecoBaseCep {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cep;

  private String nomeRua;

  private String bairro;

  private String cidade;

  private String estado;

  private LocalDateTime dataHoraCriacao = LocalDateTime.now();

  @OneToMany(mappedBy = "enderecoBaseCep", cascade = CascadeType.ALL)
  private List<Parte> partes;
}
