package com.EstacioMCTeam4.mapper;

import com.EstacioMCTeam4.controller.dto.request.FuncionarioRequest;
import com.EstacioMCTeam4.controller.dto.response.FuncionarioResponse;
import com.EstacioMCTeam4.entity.Funcionario;

public class FuncionarioMapper {

  public static Funcionario criarFuncionarioEntidade(FuncionarioRequest request) {

    Funcionario entity = new Funcionario();
    entity.setNome(request.getNome());
    entity.setCpf(request.getCpf());
    entity.setCargo(request.getCargo());
    entity.setSalario(request.getSalario());

    return entity;
  }

  public static void alterarFuncionarioEntidade(Funcionario entity, FuncionarioRequest request) {

    entity.setNome(request.getNome());
    entity.setCpf(request.getCpf());
    entity.setCargo(request.getCargo());
    entity.setSalario(request.getSalario());
  }

  public static FuncionarioResponse criarFuncionarioResponse(Funcionario entity) {

    FuncionarioResponse dto = new FuncionarioResponse();

    dto.setId(entity.getId());
    dto.setNome(entity.getNome());
    dto.setCpf(entity.getCpf());
    dto.setCargo(entity.getCargo());
    dto.setCargoString(entity.getCargo().getValue());
    dto.setSalario(entity.getSalario());

    return dto;
  }
}
