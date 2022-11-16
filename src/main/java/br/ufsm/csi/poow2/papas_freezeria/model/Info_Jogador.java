package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_infoJogador", sequenceName = "seq_infoJogador", allocationSize = 1)
public class Info_Jogador implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_infoJogador")
    private int id_info_jogador;
    @Column
    private int rank;
    @Column
    private int total_pontos;
    @ManyToOne
    @JoinColumn(name = "jogador_id_jogador")
    private Jogador jogador;
    @ManyToOne
    @JoinColumn(name = "nivel_id_nivel")
    private Nivel nivel;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotalPontos() {
        return total_pontos;
    }

    public void setTotalPontos(int totalPontos) {
        this.total_pontos = totalPontos;
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
