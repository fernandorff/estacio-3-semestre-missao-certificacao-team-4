package com.EstacioMCTeam4.service.parte;

import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.repository.ParteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ParteHelper {

    private final ParteRepository processoRepository;

    public Parte returnValidParteById(Long id) {

        return processoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parte não encontrada"));
    }

    public Parte returnValidParteSemProcessoById(Long id) {

        Parte parte =
                processoRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parte não encontrada"));

        if (parte.getProcesso() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parte já está em um processo");
        } else {
            return parte;
        }
    }
}
