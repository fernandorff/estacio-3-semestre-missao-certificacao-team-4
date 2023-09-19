package com.EstacioMCTeam4.service.enderecoBaseCep;

import com.EstacioMCTeam4.entity.EnderecoBaseCep;
import com.EstacioMCTeam4.repository.EnderecoBaseCepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class EnderecoBaseCepServiceImpl implements EnderecoBaseCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/";
    private final RestTemplate restTemplate;
    private final EnderecoBaseCepRepository enderecoBaseCepRepository;

    @Override
    public EnderecoBaseCep findOrCreateEnderecoBaseCepByCep(String cep) {

        EnderecoBaseCep enderecoBaseCep = enderecoBaseCepRepository.findByCep(cep);

        if (enderecoBaseCep == null) {
            String url = VIA_CEP_URL + cep + "/json";
            ViaCepResponse viaCepResponse = restTemplate.getForObject(url, ViaCepResponse.class);

            if (viaCepResponse != null) {
                enderecoBaseCep = new EnderecoBaseCep();
                enderecoBaseCep.setCep(cep);
                enderecoBaseCep.setNomeRua(viaCepResponse.getLogradouro());
                enderecoBaseCep.setBairro(viaCepResponse.getBairro());
                enderecoBaseCep.setCidade(viaCepResponse.getLocalidade());
                enderecoBaseCep.setEstado(viaCepResponse.getUf());

                enderecoBaseCepRepository.save(enderecoBaseCep);

            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Endereço não encontrado para o CEP: " + cep);
            }
        }

        return enderecoBaseCep;
    }
}
