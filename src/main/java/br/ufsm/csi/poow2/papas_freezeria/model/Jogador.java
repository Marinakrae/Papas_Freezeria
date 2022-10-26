package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_jogador", sequenceName = "seq_jogador", allocationSize = 1, initialValue = 1)
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jogador")
    private int idJogador;

    private String nome;
    private String email;
    private String senha;
    private String permissao;

    public Jogador(int idJogador, String nome, String email, String senha, String permissao) {
        this.idJogador = idJogador;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }

    public Jogador() {
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
