package com.EstacioMCTeam4.service.funcionario;

import com.EstacioMCTeam4.entity.Funcionario;
import com.EstacioMCTeam4.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FuncionarioHelper {

  private final FuncionarioRepository funcionarioRepository;

  public Funcionario retornarFuncionarioValidoPorId(Long id) {

    return funcionarioRepository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
  }
}
