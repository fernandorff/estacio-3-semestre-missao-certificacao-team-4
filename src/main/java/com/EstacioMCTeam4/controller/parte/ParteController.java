package com.EstacioMCTeam4.controller.parte;

import java.util.Set;

public interface ParteController {

  ParteResponse create(ParteRequest request);

  Set<ParteResponse> list();

  ParteResponse getById(Long id);

  ParteResponse update(Long id, ParteRequest request);

  ParteResponse delete(Long id);
}
