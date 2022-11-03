package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_Nivel", sequenceName = "seq_Nivel", allocationSize = 1, initialValue = 1)
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Nivel")
    private int idNivel;
    private String dificuldade;
    private int pontos;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "desempenho_nivel_id_desempenho_nivel")
    private Desempenho_Nivel desempenho_nivel;

    public Nivel(int idNivel, String dificuldade, int pontos, Desempenho_Nivel desempenho_nivel) {
        this.idNivel = idNivel;
        this.dificuldade = dificuldade;
        this.pontos = pontos;
        this.desempenho_nivel = desempenho_nivel;
    }

    public Nivel() {
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Desempenho_Nivel getDesempenho_nivel() {
        return desempenho_nivel;
    }

    public void setDesempenho_nivel(Desempenho_Nivel desempenho_nivel) {
        this.desempenho_nivel = desempenho_nivel;
    }
}
