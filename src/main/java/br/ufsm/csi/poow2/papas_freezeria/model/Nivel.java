package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_Nivel", sequenceName = "seq_Nivel", allocationSize = 1)
public class Nivel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Nivel")
    private int id_Nivel;
    @Column
    private String dificuldade;
    @Column
    private int pontos;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "desempenho_nivel_id_desempenho_nivel")
    private Desempenho_Nivel desempenho_nivel;

    public int getIdNivel() {
        return id_Nivel;
    }

    public void setIdNivel(int idNivel) {
        this.id_Nivel = idNivel;
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
