package com.funcionarios.MissaoCertificacaoTeam4.service.funcionario.helper;

import com.funcionarios.MissaoCertificacaoTeam4.entity.Funcionario;
import com.funcionarios.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncionarioHelper {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario retornarFuncionarioValidoPorId(Long id) {

        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
    }
}
