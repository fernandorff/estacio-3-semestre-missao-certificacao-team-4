package com.EstacioMCTeam4.service.notificacao;

import com.EstacioMCTeam4.controller.notificacao.NotificacaoRequest;
import com.EstacioMCTeam4.controller.notificacao.NotificacaoResponse;
import com.EstacioMCTeam4.controller.parte.ParteRequest;
import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import com.EstacioMCTeam4.entity.Notificacao;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.mapper.ParteMapper;
import com.EstacioMCTeam4.repository.NotificacaoRepository;
import com.EstacioMCTeam4.repository.ParteRepository;
import com.EstacioMCTeam4.service.enderecoBaseCep.EnderecoBaseCepService;
import com.EstacioMCTeam4.service.parte.ParteCrudService;
import com.EstacioMCTeam4.service.parte.ParteHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacaoCrudServiceImpl implements NotificacaoCrudService {

  private final NotificacaoRepository notificacaoRepository;

  private final NotificacaoHelper notificacaoHelper;

  private final EnderecoBaseCepService enderecoBaseCepService;

  @Transactional
  public Set<NotificacaoResponse> list() {

    return notificacaoRepository.findAll().stream()
        .map((Notificacao notificacao) -> ParteMapper.toResponse(parte, true))
        .collect(Collectors.toSet());
  }

  @Transactional
  public NotificacaoResponse getById(Long id) {

    Notificacao notificao = parteHelper.returnValidParteById(id);

    return ParteMapper.toResponse(parte, true);
  }

  @Transactional
  public NotificacaoResponse create(@Valid NotificacaoRequest request) {

    Notificacao notificacao = ParteMapper.toEntity(request);

    EnderecoBaseCep enderecoBaseCep =
        enderecoBaseCepService.findOrCreateEnderecoBaseCepByCep(request.getCep());

    parte.setEnderecoBaseCep(enderecoBaseCep);

    notificacaoRepository.save(parte);

    return ParteMapper.toResponse(parte, true);
  }

  @Transactional
  public NotificacaoResponse update(Long id, ParteRequest request) {

    Notificacao notificacao = parteHelper.returnValidParteById(id);

    ParteMapper.updateEntity(parte, request);

    notificacaoRepository.save(parte);

    return ParteMapper.toResponse(parte, true);
  }

  @Transactional
  public NotificacaoResponse delete(Long id) {

    Notificacao notificacao = parteHelper.returnValidParteById(id);

    notificacaoRepository.deleteById(id);

    return ParteMapper.toResponse(parte, true);
  }
}
