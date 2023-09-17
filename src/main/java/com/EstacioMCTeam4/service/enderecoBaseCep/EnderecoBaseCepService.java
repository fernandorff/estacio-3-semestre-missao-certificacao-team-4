package com.EstacioMCTeam4.service.enderecoBaseCep;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.EnderecoBaseCep;

import java.util.List;

public interface EnderecoBaseCepService {

  EnderecoBaseCep findOrCreateEnderecoBaseCepByCep(String cep);
}
