package com.funcionarios.MissaoCertificacaoTeam4.repository;

import com.funcionarios.MissaoCertificacaoTeam4.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
