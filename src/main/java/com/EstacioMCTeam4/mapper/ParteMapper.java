package com.EstacioMCTeam4.mapper;

import com.EstacioMCTeam4.controller.parte.ParteRequest;
import com.EstacioMCTeam4.controller.parte.ParteResponse;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Parte;

public class ParteMapper {

  public static Parte toEntity(ParteRequest request) {

    Parte entity = new Parte();

    updateEntity(entity, request);

    return entity;
  }

  public static void updateEntity(Parte entity, ParteRequest request) {

    entity.setNomeCompleto(request.getNomeCompleto());
    entity.setDocumento(request.getDocumento());
    entity.setEmail(request.getEmail());
    entity.setNumeroEndereco(request.getNumeroEndereco());
    entity.setComplementoEndereco(request.getComplementoEndereco());
  }

  public static ParteResponse toResponse(Parte entity, boolean mapProcesso) {

    if (entity == null) {
      return null;
    }

    ParteResponse response = new ParteResponse();

    response.setId(entity.getId());
    response.setNomeCompleto(entity.getNomeCompleto());
    response.setDocumento(entity.getDocumento());
    response.setEmail(entity.getEmail());
    response.setNumeroEndereco(entity.getNumeroEndereco());
    response.setComplementoEndereco(entity.getComplementoEndereco());

    if (mapProcesso) {
      ProcessoResponse processoResponse = ProcessoMapper.toResponse(entity.getProcesso(), false);
      response.setProcesso(processoResponse);
    }

    response.setEnderecoBaseCEP(entity.getEnderecoBaseCep());
    response.setDataHoraCriacao(entity.getDataHoraCriacao());

    return response;
  }
}
