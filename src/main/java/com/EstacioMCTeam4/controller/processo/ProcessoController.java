package com.EstacioMCTeam4.controller.processo;

import java.util.Set;

public interface ProcessoController {

  ProcessoResponse create(ProcessoRequest request);

  Set<ProcessoResponse> list();

  ProcessoResponse getById(Long id);

  ProcessoResponse update(Long id, ProcessoRequest request);

  ProcessoResponse delete(Long id);

  ProcessoResponse addPartes(Long processoId, Set<Long> parteIds);
}
