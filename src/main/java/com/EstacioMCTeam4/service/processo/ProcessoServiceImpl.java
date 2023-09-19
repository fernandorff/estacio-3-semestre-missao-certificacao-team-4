package com.EstacioMCTeam4.service.processo;

import com.EstacioMCTeam4.controller.processo.ProcessoRequest;
import com.EstacioMCTeam4.controller.processo.ProcessoResponse;
import com.EstacioMCTeam4.entity.Notificacao;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.entity.Processo;
import com.EstacioMCTeam4.entity.enums.TipoNotificacao;
import com.EstacioMCTeam4.mapper.ProcessoMapper;
import com.EstacioMCTeam4.repository.NotificacaoRepository;
import com.EstacioMCTeam4.repository.ProcessoRepository;
import com.EstacioMCTeam4.service.parte.ParteHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcessoServiceImpl implements ProcessoService {

    private final ProcessoRepository processoRepository;

    private final NotificacaoRepository notificacaoRepository;

    private final ProcessoHelper processoHelper;

    private final ParteHelper parteHelper;

    private final JavaMailSender javaMailSender;

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

    public ProcessoResponse notificarPartes(Long id) {
        Processo processo = processoHelper.returnValidProcessoById(id);

        for (Parte parte : processo.getPartes()) {
            if (parte.getNumeroEndereco() != null && parte.getEnderecoBaseCep().getCep() != null) {
                Notificacao notificacaoCorreios = new Notificacao();

                notificacaoCorreios.setParte(parte);
                notificacaoCorreios.setNotificado(true);
                notificacaoCorreios.setTipoNotificacao(TipoNotificacao.CORREIOS);

                parte.getNotificacoes().add(notificacaoCorreios);

                notificacaoRepository.save(notificacaoCorreios);
            }

            if (parte.getEmail() != null) {
                Notificacao notificacaoEmail = new Notificacao();

                notificacaoEmail.setParte(parte);
                notificacaoEmail.setNotificado(true);
                notificacaoEmail.setTipoNotificacao(TipoNotificacao.EMAIL);

                parte.getNotificacoes().add(notificacaoEmail);

                notificacaoRepository.save(notificacaoEmail);
            }

            Notificacao notificacaoDje = new Notificacao();

            notificacaoDje.setParte(parte);
            notificacaoDje.setNotificado(true);
            notificacaoDje.setTipoNotificacao(TipoNotificacao.DJE);

            parte.getNotificacoes().add(notificacaoDje);

            notificacaoRepository.save(notificacaoDje);
        }

        return ProcessoMapper.toResponse(processo, true);
    }
}
