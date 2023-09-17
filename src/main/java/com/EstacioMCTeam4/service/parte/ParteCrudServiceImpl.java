package com.EstacioMCTeam4.service.parte;

import com.EstacioMCTeam4.controller.parte.ParteRequest;
import com.EstacioMCTeam4.controller.parte.ParteResponse;
import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.mapper.ParteMapper;
import com.EstacioMCTeam4.repository.ParteRepository;
import java.util.List;
import java.util.stream.Collectors;

import com.EstacioMCTeam4.service.enderecoBaseCep.EnderecoBaseCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParteCrudServiceImpl implements ParteCrudService {

  private final ParteRepository parteRepository;

  private final ParteHelper parteHelper;

  private final EnderecoBaseCepService enderecoBaseCepService;

  @Transactional
  public List<ParteResponse> list() {

    return parteRepository.findAll().stream()
        .map(ParteMapper::toResponse)
        .collect(Collectors.toList());
  }

  @Transactional
  public ParteResponse getById(Long id) {

    Parte parte = parteHelper.returnValidParteById(id);

    return ParteMapper.toResponse(parte);
  }

  @Transactional
  public ParteResponse create(ParteRequest request) {

    Parte parte = ParteMapper.toEntity(request);

    EnderecoBaseCep enderecoBaseCep = enderecoBaseCepService.findOrCreateEnderecoBaseCepByCep(request.getCep());

    parte.setEnderecoBaseCep(enderecoBaseCep);

    parteRepository.save(parte);

    return ParteMapper.toResponse(parte);
  }

  @Transactional
  public ParteResponse update(Long id, ParteRequest request) {

    Parte parte = parteHelper.returnValidParteById(id);

    ParteMapper.updateEntity(parte, request);

    parteRepository.save(parte);

    return ParteMapper.toResponse(parte);
  }

  @Transactional
  public ParteResponse delete(Long id) {

    Parte parte = parteHelper.returnValidParteById(id);

    parteRepository.deleteById(id);

    return ParteMapper.toResponse(parte);
  }
}
