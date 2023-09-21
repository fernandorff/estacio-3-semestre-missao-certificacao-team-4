package com.EstacioMCTeam4.entity;

import com.EstacioMCTeam4.entity.enums.TipoNotificacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean notificado;

    private TipoNotificacao tipoNotificacao;

    @JsonIgnore
    @ManyToOne
    private Parte parte;

    private LocalDateTime dataHoraCriacao = LocalDateTime.now();
}
