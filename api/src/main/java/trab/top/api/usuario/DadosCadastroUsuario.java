package trab.top.api.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import trab.top.api.endereco.DadosEndereco;

public record DadosCadastroUsuario(
        @NotBlank //Bean Validation, nome não pode ser nulo
        String nome,
        @NotBlank
        @Email // validação do formato do email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String profissao,
        @NotNull @Valid DadosEndereco endereco){
}
