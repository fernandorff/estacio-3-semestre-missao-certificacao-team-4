package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.entity.Processo;
import com.EstacioMCTeam4.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProcessoHelper {

  private final ProcessoRepository processoRepository;

  public Processo returnValidProcessoById(Long id) {

    return processoRepository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Processo não encontrado"));
  }
}
