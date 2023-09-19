package com.EstacioMCTeam4.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Entity
public class Parte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String documento;

    private String email;

    private String numeroEndereco;

    private String complementoEndereco;

    @ManyToOne()
    private EnderecoBaseCep enderecoBaseCep;

    @ManyToOne()
    private Processo processo;

    @OneToMany(mappedBy = "parte", cascade = CascadeType.ALL)
    private Set<Notificacao> notificacoes;

    private LocalDateTime dataHoraCriacao = LocalDateTime.now();
}
