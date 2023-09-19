package com.EstacioMCTeam4.repository;

import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoBaseCepRepository extends JpaRepository<EnderecoBaseCep, Long> {

    EnderecoBaseCep findByCep(String cep);
}
