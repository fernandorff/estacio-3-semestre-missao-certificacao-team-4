package com.EstacioMCTeam4.controller.parte;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ParteController {

  ParteResponse create(@Valid @RequestBody ParteRequest request);

  List<ParteResponse> list();

  ParteResponse getById(@PathVariable Long id);

  ParteResponse update(@PathVariable Long id, @Valid @RequestBody ParteRequest request);

  ParteResponse delete(@PathVariable Long id);
}
