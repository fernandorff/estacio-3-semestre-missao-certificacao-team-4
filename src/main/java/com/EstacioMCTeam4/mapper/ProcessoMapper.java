package com.EstacioMCTeam4.mapper;

import com.EstacioMCTeam4.controller.parte.ParteResponse;
import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Processo;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessoMapper {

  public static Processo toEntity(ProcessoRequest request) {

    Processo entity = new Processo();

    updateEntity(entity, request);

    return entity;
  }

  public static void updateEntity(Processo entity, ProcessoRequest request) {

    entity.setNumero(request.getNumero());
  }

  public static ProcessoResponse toResponse(Processo entity, boolean mapPartes) {

    if (entity == null) {
      return null;
    }

    ProcessoResponse response = new ProcessoResponse();

    response.setId(entity.getId());
    response.setNumero(entity.getNumero());

    if (mapPartes) {
      Set<ParteResponse> parteResponses =
          entity.getPartes().stream()
              .map(parte -> ParteMapper.toResponse(parte, false))
              .collect(Collectors.toSet());
      response.setPartes(parteResponses);
    }

    response.setDataHoraCriacao(entity.getDataHoraCriacao());

    return response;
  }
}
