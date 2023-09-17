package com.MissaoCertificacaoTeam4.service.funcionario.helper;

import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncionarioHelper {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioHelper(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario retornarFuncionarioValidoPorId(Long id) {

        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
    }
}
