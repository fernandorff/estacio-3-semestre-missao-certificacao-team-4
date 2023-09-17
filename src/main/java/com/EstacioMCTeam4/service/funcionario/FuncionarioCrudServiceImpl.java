package com.EstacioMCTeam4.service.funcionario;

import static com.EstacioMCTeam4.mapper.FuncionarioMapper.criarFuncionarioResponse;

import com.EstacioMCTeam4.controller.dto.request.FuncionarioRequest;
import com.EstacioMCTeam4.controller.dto.response.FuncionarioResponse;
import com.EstacioMCTeam4.entity.Funcionario;
import com.EstacioMCTeam4.mapper.FuncionarioMapper;
import com.EstacioMCTeam4.repository.FuncionarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FuncionarioCrudServiceImpl implements FuncionarioCrudService {

  private final FuncionarioRepository funcionarioRepository;

  private final FuncionarioHelper funcionarioHelper;

  @Transactional
  public List<FuncionarioResponse> listar() {

    return funcionarioRepository.findAll().stream()
        .map(FuncionarioMapper::criarFuncionarioResponse)
        .collect(Collectors.toList());
  }

  @Transactional
  public Page<FuncionarioResponse> listarPaginado(Pageable pageable) {

    Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);

    return funcionarios.map(FuncionarioMapper::criarFuncionarioResponse);
  }

  @Transactional
  public FuncionarioResponse obterPorId(Long id) {

    Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

    return criarFuncionarioResponse(funcionario);
  }

  @Transactional
  public FuncionarioResponse incluir(FuncionarioRequest request) {

    Funcionario funcionario = FuncionarioMapper.criarFuncionarioEntidade(request);

    funcionarioRepository.save(funcionario);

    return criarFuncionarioResponse(funcionario);
  }

  @Transactional
  public FuncionarioResponse alterar(Long id, FuncionarioRequest request) {

    Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

    FuncionarioMapper.alterarFuncionarioEntidade(funcionario, request);

    funcionarioRepository.save(funcionario);

    return criarFuncionarioResponse(funcionario);
  }

  @Transactional
  public FuncionarioResponse remover(Long id) {

    Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

    funcionarioRepository.deleteById(id);

    return criarFuncionarioResponse(funcionario);
  }
}
