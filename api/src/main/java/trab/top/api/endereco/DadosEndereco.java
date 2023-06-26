package trab.top.api.endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // validando o cep
        String cep,
        @NotBlank
        String uf,
        String numero,
        String complemento) {

}
