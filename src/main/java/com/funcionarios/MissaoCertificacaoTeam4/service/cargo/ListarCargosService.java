package com.funcionarios.MissaoCertificacaoTeam4.service.cargo;

import com.funcionarios.MissaoCertificacaoTeam4.dto.response.CargoResponse;
import com.funcionarios.MissaoCertificacaoTeam4.entity.enums.Cargo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCargosService {

    public List<CargoResponse> listar() {
        return Arrays.stream(Cargo.values())
                .map(cargo -> new CargoResponse(cargo.name(), cargo.getValue()))
                .collect(Collectors.toList());
    }
}
