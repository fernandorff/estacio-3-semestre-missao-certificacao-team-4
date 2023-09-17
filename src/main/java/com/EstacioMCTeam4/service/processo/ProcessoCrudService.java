package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import java.util.List;

public interface ProcessoCrudService {

  List<ProcessoResponse> list();

  ProcessoResponse getById(Long id);

  ProcessoResponse create(ProcessoRequest request);

  ProcessoResponse update(Long id, ProcessoRequest request);

  ProcessoResponse delete(Long id);

  ProcessoResponse addPartes(Long id, List<Long> parteIds);
}
