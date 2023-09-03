package com.funcionarios.MissaoCertificacaoTeam4.controller;

import com.funcionarios.MissaoCertificacaoTeam4.dto.response.CargoResponse;
import com.funcionarios.MissaoCertificacaoTeam4.service.cargo.ListarCargosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
@Tag(name = "Cargo", description = "API para visualização de cargos (enum)")
@CrossOrigin(origins = "*")
public class CargoController {

    private final ListarCargosService listarCargosService;

    public CargoController(ListarCargosService listarCargosService) {
        this.listarCargosService = listarCargosService;
    }

    @GetMapping
    @Operation(summary = "Listar cargos (enum)", method = "GET")
    @ResponseStatus(HttpStatus.OK)
    public List<CargoResponse> listar() {
        return listarCargosService.listar();
    }
}
