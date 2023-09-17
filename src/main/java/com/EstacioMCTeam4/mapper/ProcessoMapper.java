package com.EstacioMCTeam4.mapper;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Processo;

public class ProcessoMapper {

  public static Processo toEntity(ProcessoRequest request) {

    Processo entity = new Processo();

    updateEntity(entity, request);

    return entity;
  }

  public static void updateEntity(Processo entity, ProcessoRequest request) {

    entity.setNumero(request.getNumero());
  }

  public static ProcessoResponse toResponse(Processo entity) {

    if (entity == null) {
      return null;
    }

    ProcessoResponse response = new ProcessoResponse();

    response.setId(entity.getId());
    response.setNumero(entity.getNumero());
    response.setDataHoraCriacao(entity.getDataHoraCriacao());

    return response;
  }
}
