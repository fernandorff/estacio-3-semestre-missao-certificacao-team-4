package com.EstacioMCTeam4.service.parte;

import com.EstacioMCTeam4.controller.parte.ParteRequest;
import com.EstacioMCTeam4.controller.parte.ParteResponse;
import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import com.EstacioMCTeam4.entity.Parte;
import com.EstacioMCTeam4.mapper.ParteMapper;
import com.EstacioMCTeam4.repository.ParteRepository;
import com.EstacioMCTeam4.service.enderecoBaseCep.EnderecoBaseCepService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParteServiceImpl implements ParteService {

    private final ParteRepository parteRepository;

    private final ParteHelper parteHelper;

    private final EnderecoBaseCepService enderecoBaseCepService;

    @Transactional
    public Set<ParteResponse> list() {

        return parteRepository.findAll().stream()
                .map((Parte parte) -> ParteMapper.toResponse(parte, true))
                .collect(Collectors.toSet());
    }

    @Transactional
    public ParteResponse getById(Long id) {

        Parte parte = parteHelper.returnValidParteById(id);

        return ParteMapper.toResponse(parte, true);
    }

    @Transactional
    public ParteResponse create(ParteRequest request) {

        Parte parte = ParteMapper.toEntity(request);

        String email = request.getEmail();

        if (!StringUtils.isBlank(email) && !isValidEmail(email)) {
            throw new IllegalArgumentException("Formato de e-mail invalido");
        }

        String cep = request.getCep();

        EnderecoBaseCep enderecoBaseCep = new EnderecoBaseCep();

        if (cep.matches("\\d{8}")) {
            enderecoBaseCep = enderecoBaseCepService.findOrCreateEnderecoBaseCepByCep(cep);
            parte.setEnderecoBaseCep(enderecoBaseCep);
        }

        parteRepository.save(parte);

        return ParteMapper.toResponse(parte, true);
    }

    @Transactional
    public ParteResponse update(Long id, ParteRequest request) {

        Parte parte = parteHelper.returnValidParteById(id);

        String email = request.getEmail();

        if (!StringUtils.isBlank(email) && !isValidEmail(email)) {
            throw new IllegalArgumentException("Formato de e-mail invalido");
        }

        String cep = request.getCep();

        EnderecoBaseCep enderecoBaseCep = new EnderecoBaseCep();

        if (cep.matches("\\d{8}")) {
            enderecoBaseCep = enderecoBaseCepService.findOrCreateEnderecoBaseCepByCep(cep);
            parte.setEnderecoBaseCep(enderecoBaseCep);
        }


        ParteMapper.updateEntity(parte, request);

        parteRepository.save(parte);

        return ParteMapper.toResponse(parte, true);
    }

    @Transactional
    public ParteResponse delete(Long id) {

        Parte parte = parteHelper.returnValidParteById(id);

        parteRepository.deleteById(id);

        return ParteMapper.toResponse(parte, true);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }
}
