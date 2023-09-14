package com.funcionarios.MissaoCertificacaoTeam4.dto.request;

//import com.funcionarios.MissaoCertificacaoTeam4.entity.enums.Cargo;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;


import java.math.BigDecimal;

@Getter
public class IncluirNotificacaoRequest {
    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome_completo;

    @NotBlank(message = "O campo nome não pode estar vazio.")
    @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF ou CNPJ inválido.")
    private String documento;

    private String email;

    private String nome_rua;

    private String numero_rua;

    private String cep;

    private String cidade;

    private String estado;

    @NotBlank(message = "O campo nome não pode estar vazio.")
    @Pattern(regexp = "\\d{20}", message = "Processo inválido.")
    private String processo;

//    //A ideia aqui seria validar o campo para vir OU CEP ou RUA ou EMAIL no mínimo!
//    @AssertTrue(message = "Pelo menos um dos campos EMAIL, RUA ou CPF deve estar preenchido")
//    private boolean isAtLeastOneFieldFilled() {
//        return (email != null || nome_rua != null || cep != null);
//    }

}
