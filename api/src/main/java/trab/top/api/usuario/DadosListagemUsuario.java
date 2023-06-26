package trab.top.api.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String cpf, String profissao) {

    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(),  usuario.getCpf(), usuario.getProfissao());
    }

}
