package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_infoJogador", sequenceName = "seq_infoJogador", allocationSize = 1)
public class Info_Jogador implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_infoJogador")
    private int idInfoJogador;
    private int rank;
    private int totalPontos;
    @ManyToOne
    @JoinColumn(name = "jogador_id_jogador")
    private Jogador jogador;
    @ManyToOne
    @JoinColumn(name = "nivel_id_nivel")
    private Nivel nivel;

    public Info_Jogador(int rank, int totalPontos, Jogador jogador, Nivel nivel) {
        this.rank = rank;
        this.totalPontos = totalPontos;
        this.jogador = jogador;
        this.nivel = nivel;
    }

    public Info_Jogador() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(int totalPontos) {
        this.totalPontos = totalPontos;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
