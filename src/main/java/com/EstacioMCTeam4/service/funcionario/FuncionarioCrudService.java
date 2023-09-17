package com.EstacioMCTeam4.service.funcionario;

import com.EstacioMCTeam4.controller.dto.request.funcionario.FuncionarioRequest;
import com.EstacioMCTeam4.controller.dto.response.funcionario.FuncionarioResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioCrudService {

  List<FuncionarioResponse> listar();

  Page<FuncionarioResponse> listarPaginado(Pageable pageable);

  FuncionarioResponse obterPorId(Long id);

  FuncionarioResponse incluir(FuncionarioRequest request);

  FuncionarioResponse alterar(Long id, FuncionarioRequest request);

  FuncionarioResponse remover(Long id);
}
