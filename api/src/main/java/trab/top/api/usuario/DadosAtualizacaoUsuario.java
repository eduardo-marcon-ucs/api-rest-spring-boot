package trab.top.api.usuario;

import jakarta.validation.constraints.NotNull;
import trab.top.api.endereco.DadosEndereco;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
