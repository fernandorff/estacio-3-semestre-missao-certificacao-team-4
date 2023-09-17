package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.entity.Processo;
import com.EstacioMCTeam4.mapper.ProcessoMapper;
import com.EstacioMCTeam4.repository.ProcessoRepository;
import com.EstacioMCTeam4.service.parte.ParteHelper;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProcessoCrudServiceImpl implements ProcessoCrudService {

  private final ProcessoRepository processoRepository;

  private final ProcessoHelper processoHelper;

  private final ParteHelper parteHelper;

  @Transactional
  public Set<ProcessoResponse> list() {

    return processoRepository.findAll().stream()
        .map((Processo processo) -> ProcessoMapper.toResponse(processo, true))
        .collect(Collectors.toSet());
  }

  @Transactional
  public ProcessoResponse getById(Long id) {

    Processo processo = processoHelper.returnValidProcessoById(id);
    return ProcessoMapper.toResponse(processo, true);
  }

  @Transactional
  public ProcessoResponse create(ProcessoRequest request) {

    Processo processo = ProcessoMapper.toEntity(request);

    processoRepository.save(processo);

    return ProcessoMapper.toResponse(processo, true);
  }

  @Transactional
  public ProcessoResponse update(Long id, ProcessoRequest request) {

    Processo processo = processoHelper.returnValidProcessoById(id);

    ProcessoMapper.updateEntity(processo, request);

    processoRepository.save(processo);

    return ProcessoMapper.toResponse(processo, true);
  }

  @Transactional
  public ProcessoResponse delete(Long id) {

    Processo processo = processoHelper.returnValidProcessoById(id);

    processoRepository.deleteById(id);

    return ProcessoMapper.toResponse(processo, true);
  }

  @Transactional
  public ProcessoResponse addPartes(Long id, Set<Long> parteIds) {

    Processo processo = processoHelper.returnValidProcessoById(id);

    Set<Parte> partes = new HashSet<>();

    parteIds.forEach(
        parteId -> {
          Parte parte = parteHelper.returnValidParteSemProcessoById(parteId);
          parte.setProcesso(processo);
          partes.add(parte);
        });

    processo.getPartes().addAll(partes);

    processoRepository.save(processo);

    return ProcessoMapper.toResponse(processo, true);
  }
}
