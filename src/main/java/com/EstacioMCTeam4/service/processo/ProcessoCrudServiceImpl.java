package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Processo;
import com.EstacioMCTeam4.mapper.ProcessoMapper;
import com.EstacioMCTeam4.repository.ProcessoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProcessoCrudServiceImpl implements ProcessoCrudService {

  private final ProcessoRepository processoRepository;

  private final ProcessoHelper processoHelper;

  @Transactional
  public List<ProcessoResponse> list() {

    return processoRepository.findAll().stream()
        .map(ProcessoMapper::toResponse)
        .collect(Collectors.toList());
  }

  @Transactional
  public ProcessoResponse getById(Long id) {

    Processo processo = processoHelper.returnValidProcessoById(id);
    return ProcessoMapper.toResponse(processo);
  }

  @Transactional
  public ProcessoResponse create(ProcessoRequest request) {

    Processo processo = ProcessoMapper.toEntity(request);

    processoRepository.save(processo);

    return ProcessoMapper.toResponse(processo);
  }

  @Transactional
  public ProcessoResponse update(Long id, ProcessoRequest request) {

    Processo processo = processoHelper.returnValidProcessoById(id);

    ProcessoMapper.updateEntity(processo, request);

    processoRepository.save(processo);

    return ProcessoMapper.toResponse(processo);
  }

  @Transactional
  public ProcessoResponse delete(Long id) {

    Processo processo = processoHelper.returnValidProcessoById(id);

    processoRepository.deleteById(id);

    return ProcessoMapper.toResponse(processo);
  }
}
