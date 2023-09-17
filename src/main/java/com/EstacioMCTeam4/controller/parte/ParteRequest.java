package com.EstacioMCTeam4.controller.parte;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
public class ParteRequest {

  @NotBlank(message = "O campo NOME não pode estar vazio.")
  private String nomeCompleto;

  @Pattern(regexp = "\\d{11}|\\d{14}", message = "O campo documento deve conter 11 dígitos (CPF) ou 14 dígitos (CNPJ).")
  private String documento;

  @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Campo não corresponde ao formato de e-mail.")
  private String email;

  @Pattern(regexp = "\\d{8}", message = "O campo CEP deve conter 8 dígitos.")
  private String cep;

  @NotBlank(message = "O campo NUMERO DO ENDEREÇO não pode estar vazio.")
  private String numeroEndereco;

  @NotBlank(message = "O campo COMPLEMENTO DO ENDEREÇO não pode estar vazio.")
  private String complementoEndereco;
}
