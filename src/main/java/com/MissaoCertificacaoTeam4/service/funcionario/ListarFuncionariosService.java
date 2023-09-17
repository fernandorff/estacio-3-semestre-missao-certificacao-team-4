package com.MissaoCertificacaoTeam4.service.funcionario;

import com.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper;
import com.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarFuncionariosService {

    private final FuncionarioRepository funcionarioRepository;

    public ListarFuncionariosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioResponse> listar() {

        return funcionarioRepository.findAll().stream()
                .map(FuncionarioMapper::criarFuncionarioResponse)
                .collect(Collectors.toList());
    }

    public Page<FuncionarioResponse> listarPaginado(Pageable pageable) {

        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);

        return funcionarios.map(FuncionarioMapper::criarFuncionarioResponse);
    }
}
