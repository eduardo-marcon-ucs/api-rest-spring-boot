package trab.top.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import trab.top.api.endereco.Endereco;
import trab.top.api.usuario.*;

import java.util.List;

@RestController
@RequestMapping("usuarios") // requisição "/usuario", vai chegar nesse controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping // requisição do tipo POST
    @Transactional // transação
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
    }

    @GetMapping // requisição do tipo GET
    public Page<DadosListagemUsuario> listar(
            @PageableDefault(size = 10,
                             sort = {"nome"})
                             Pageable paginacao){
                            // Pageable, interface do spring para paginação
        // convertendo uma lista de usuarios para uma lista de dados listagem usuario
        return repository.findAll(paginacao).map(DadosListagemUsuario::new);
    }

    @PutMapping // requisição do tipo PUT
    @Transactional // transação
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        // pegando o registro apartir do id que foi passado na requisição
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}") // requisição do tipo DELETE
    @Transactional // transação
    public void excluir(@PathVariable Long id){ // @PathVariable paramêtro dinâmico
        repository.deleteById(id); // exclusão física
    }

}
