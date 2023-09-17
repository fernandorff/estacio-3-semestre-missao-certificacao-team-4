package com.EstacioMCTeam4.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TipoNotificacao {
  CORREIOS("Correios"),

  EMAIL("E-mail"),

  DJE("Diário da Justiça Eletrônico");

  private final String value;
}
