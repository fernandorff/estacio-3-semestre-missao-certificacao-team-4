package com.EstacioMCTeam4.service.enderecoBaseCep;

import com.EstacioMCTeam4.entity.EnderecoBaseCep;

public interface EnderecoBaseCepService {

    EnderecoBaseCep findOrCreateEnderecoBaseCepByCep(String cep);
}
