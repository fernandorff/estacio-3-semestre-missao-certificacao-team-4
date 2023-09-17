package com.MissaoCertificacaoTeam4.service.funcionario;

import com.MissaoCertificacaoTeam4.dto.request.IncluirFuncionarioRequest;
import com.MissaoCertificacaoTeam4.dto.response.FuncionarioResponse;
import com.MissaoCertificacaoTeam4.entity.Funcionario;
import com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper;
import com.MissaoCertificacaoTeam4.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.MissaoCertificacaoTeam4.mapper.FuncionarioMapper.criarFuncionarioResponse;

@Service
public class IncluirFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public IncluirFuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioResponse incluir(IncluirFuncionarioRequest request) {

        Funcionario funcionario = FuncionarioMapper.criarFuncionarioEntidade(request);

        funcionarioRepository.save(funcionario);

        return criarFuncionarioResponse(funcionario);
    }
}
