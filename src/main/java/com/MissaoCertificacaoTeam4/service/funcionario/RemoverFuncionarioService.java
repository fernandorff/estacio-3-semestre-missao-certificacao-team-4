package com.MissaoCertificacaoTeam4.service.funcionario;

import com.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import com.MissaoCertificacaoTeam4.service.funcionario.helper.FuncionarioHelper;
import org.springframework.stereotype.Service;

import static com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper.criarFuncionarioResponse;

@Service
public class RemoverFuncionarioService {

    private final FuncionarioHelper funcionarioHelper;

    private final FuncionarioRepository funcionarioRepository;

    public RemoverFuncionarioService(FuncionarioHelper funcionarioHelper, FuncionarioRepository funcionarioRepository) {
        this.funcionarioHelper = funcionarioHelper;
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioResponse remover(Long id) {

        Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

        funcionarioRepository.deleteById(id);

        return criarFuncionarioResponse(funcionario);
    }
}
