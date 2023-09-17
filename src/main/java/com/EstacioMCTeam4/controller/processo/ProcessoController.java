package com.EstacioMCTeam4.controller.processo;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProcessoController {

  ProcessoResponse create(@Valid @RequestBody ProcessoRequest request);

  List<ProcessoResponse> list();

  ProcessoResponse getById(@PathVariable Long id);

  ProcessoResponse update(@PathVariable Long id, @Valid @RequestBody ProcessoRequest request);

  ProcessoResponse delete(@PathVariable Long id);
}
