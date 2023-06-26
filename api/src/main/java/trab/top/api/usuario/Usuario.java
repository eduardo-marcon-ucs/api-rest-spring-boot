package trab.top.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trab.top.api.endereco.Endereco;

@Table(name = "usuarios") // anotações JPA
@Entity(name = "Usuario") // anotações JPA
@Getter // anotações Lombok
@NoArgsConstructor // anotações Lombok
@AllArgsConstructor // anotações Lombok
@EqualsAndHashCode(of = "id") // anotações Lombok
public class Usuario {

     @Id // anotações JPA
     @GeneratedValue(strategy = GenerationType.IDENTITY) // anotações JPA
     private Long id;
     private String nome;
     private String email;
     private String telefone;
     private String cpf;
     private String profissao;
     @Embedded // anotações JPA, Embedded, para não ter que criar uma tabela Endereço
     private Endereco endereco;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.profissao = dados.profissao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
            this.endereco.atualizaInformacoes(dados.endereco());
        }
    }
}
