package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;

import java.util.Set;

public interface ProcessoService {

    Set<ProcessoResponse> list();

    ProcessoResponse getById(Long id);

    ProcessoResponse create(ProcessoRequest request);

    ProcessoResponse update(Long id, ProcessoRequest request);

    ProcessoResponse delete(Long id);

    ProcessoResponse addPartes(Long id, Set<Long> parteIds);
}
