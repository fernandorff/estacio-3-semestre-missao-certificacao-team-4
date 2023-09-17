package com.MissaoCertificacaoTeam4.service.funcionario;

import com.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.service.funcionario.helper.FuncionarioHelper;
import org.springframework.stereotype.Service;

import static com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper.criarFuncionarioResponse;

@Service
public class ObterFuncionarioService {

    private final FuncionarioHelper funcionarioHelper;

    public ObterFuncionarioService(FuncionarioHelper funcionarioHelper) {
        this.funcionarioHelper = funcionarioHelper;
    }

    public FuncionarioResponse obter(Long id) {

        Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

        return criarFuncionarioResponse(funcionario);
    }
}
