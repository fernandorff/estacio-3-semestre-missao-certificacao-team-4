package com.MissaoCertificacaoTeam4.service.funcionario;

import com.MissaoCertificacaoTeam4.dto.request.AlterarFuncionarioRequest;
import com.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper;
import com.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import com.MissaoCertificacaoTeam4.service.funcionario.helper.FuncionarioHelper;
import org.springframework.stereotype.Service;

import static com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper.criarFuncionarioResponse;

@Service
public class AlterarFuncionarioService {

    private final FuncionarioHelper funcionarioHelper;

    private final FuncionarioRepository funcionarioRepository;

    public AlterarFuncionarioService(FuncionarioHelper funcionarioHelper, FuncionarioRepository funcionarioRepository) {
        this.funcionarioHelper = funcionarioHelper;
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioResponse alterar(Long id, AlterarFuncionarioRequest request) {

        Funcionario funcionario = funcionarioHelper.retornarFuncionarioValidoPorId(id);

        FuncionarioMapper.alterarFuncionarioEntidade(funcionario, request);

        funcionarioRepository.save(funcionario);

        return criarFuncionarioResponse(funcionario);
    }
}
