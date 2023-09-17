package com.EstacioMCTeam4.controller.dto.request.notificacao;

// import com.MissaoCertificacaoTeam4.entity.enums.Cargo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class IncluirNotificacaoRequest {

  @NotBlank(message = "O campo nome não pode estar vazio.")
  private String nomeCompleto;

  @NotBlank(message = "O campo nome não pode estar vazio.")
  @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF ou CNPJ inválido.")
  private String documento;

  private String email;

  private String nomeRua;

  private String numeroRua;

  private String cep;

  private String cidade;

  private String estado;

  @NotBlank(message = "O campo nome não pode estar vazio.")
  @Pattern(regexp = "\\d{20}", message = "Processo inválido.")
  private String processo;

  //    //A ideia aqui seria validar o campo para vir OU CEP ou RUA ou EMAIL no mínimo!
  //    @AssertTrue(message = "Pelo menos um dos campos EMAIL, RUA ou CPF deve estar preenchido")
  //    private Boolean isAtLeastOneFieldFilled() {
  //        return (email != null || nome_rua != null || cep != null);
  //    }

}
