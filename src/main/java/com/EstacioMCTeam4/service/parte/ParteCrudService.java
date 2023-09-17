package com.EstacioMCTeam4.service.parte;

import com.EstacioMCTeam4.controller.parte.ParteRequest;
import com.EstacioMCTeam4.controller.parte.ParteResponse;
import java.util.List;

public interface ParteCrudService {

  List<ParteResponse> list();

  ParteResponse getById(Long id);

  ParteResponse create(ParteRequest request);

  ParteResponse update(Long id, ParteRequest request);

  ParteResponse delete(Long id);
}
