package com.EstacioMCTeam4.service.notificacao;

import com.EstacioMCTeam4.entity.Notificacao;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.entity.Processo;
import com.EstacioMCTeam4.entity.enums.TipoNotificacao;
import com.EstacioMCTeam4.repository.NotificacaoRepository;
import com.EstacioMCTeam4.service.processo.ProcessoHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NotificacaoServiceImpl implements NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    private final JavaMailSender javaMailSender;

    private final ProcessoHelper processoHelper;

    private static SimpleMailMessage getSimpleMailMessage(Parte parte) {
        String to = parte.getEmail();
        String subject = "Notificação PJE - Processo de Número: " + parte.getProcesso().getNumero();
        String message = "Olá " + parte.getNomeCompleto() + ",\n\n"
                + "Esta é a mensagem da notificação.\n"
                + "Mensagem: Houve notificação sobre o processo judicial. Acesse o processo na plataforma do PJE.";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        return mailMessage;
    }

    @Override
    public Set<Notificacao> getAllNotificados() {
        return notificacaoRepository.findByNotificadoTrue();
    }

    @Override
    public Set<Notificacao> getAllNaoNotificados() {
        return notificacaoRepository.findByNotificadoFalse();
    }

    @Override
    public Set<Notificacao> getNotificacoesECarta() {
        return notificacaoRepository.findByTipoNotificacaoAndNotificadoFalse(TipoNotificacao.E_CARTA);
    }

    @Override
    public Set<Notificacao> notificarByECarta() {
        Set<Notificacao> notificacoesECarta = new HashSet<>(notificacaoRepository.findByTipoNotificacaoAndNotificadoFalse(TipoNotificacao.E_CARTA));

        if (notificacoesECarta.size() >= 10) {
            for (Notificacao notificacao : notificacoesECarta) {
                notificacao.setNotificado(true);
                notificacaoRepository.save(notificacao);
            }

            return notificacoesECarta;
        }

        throw new RuntimeException("O número mínimo de notificações para serem enviadas por essa modalidade é 10. " +
                "No momento o sistema tem apenas: " + notificacoesECarta.size());
    }

    @Override
    public Set<Notificacao> getNotificacoesDje() {
        return notificacaoRepository.findByTipoNotificacaoAndNotificadoFalse(TipoNotificacao.DJE);
    }

    @Override
    public Set<Notificacao> notificarByDje() {
        Set<Notificacao> notificacoesDje = new HashSet<>();

        for (Notificacao notificacao : notificacaoRepository.findByTipoNotificacaoAndNotificadoFalse(TipoNotificacao.DJE)) {
            notificacoesDje.add(notificacao);
            notificacao.setNotificado(true);
            notificacaoRepository.save(notificacao);
        }

        return notificacoesDje;
    }

    @Override
    public Set<Notificacao> notifyPartesByProcesso(Long processoId) {
        Processo processo = processoHelper.returnValidProcessoById(processoId);

        Set<Notificacao> notificacoes = new HashSet<>();

        for (Parte parte : processo.getPartes()) {
            boolean notificou = false;

            if (parte.getNumeroEndereco() != null
                    && !parte.getNumeroEndereco().isBlank()
                    && parte.getEnderecoBaseCep() != null) {
                Notificacao notificacaoCorreios = new Notificacao();

                notificacaoCorreios.setParte(parte);
                notificacaoCorreios.setNotificado(false);
                notificacaoCorreios.setTipoNotificacao(TipoNotificacao.E_CARTA);

                parte.getNotificacoes().add(notificacaoCorreios);

                notificacoes.add(notificacaoCorreios);

                notificacaoRepository.save(notificacaoCorreios);

                notificou = true;
            }

            if (parte.getEmail() != null
                    && !parte.getEmail().isBlank()
                    && !notificou) {
                Notificacao notificacaoEmail = new Notificacao();

                notificacaoEmail.setParte(parte);
                notificacaoEmail.setNotificado(true);
                notificacaoEmail.setTipoNotificacao(TipoNotificacao.EMAIL);

                parte.getNotificacoes().add(notificacaoEmail);

                SimpleMailMessage mailMessage = getSimpleMailMessage(parte);

                javaMailSender.send(mailMessage);

                notificacaoRepository.save(notificacaoEmail);

                notificacoes.add(notificacaoEmail);

                notificou = true;
            }

            if (!notificou) {
                Notificacao notificacaoDje = new Notificacao();

                notificacaoDje.setParte(parte);
                notificacaoDje.setNotificado(false);
                notificacaoDje.setTipoNotificacao(TipoNotificacao.DJE);

                parte.getNotificacoes().add(notificacaoDje);

                notificacaoRepository.save(notificacaoDje);

                notificacoes.add(notificacaoDje);
            }
        }

        return notificacoes;
    }
}
