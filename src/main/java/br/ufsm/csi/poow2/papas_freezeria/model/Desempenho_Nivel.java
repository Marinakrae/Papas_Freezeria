package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_desempenho", sequenceName = "seq_desempenho", allocationSize = 1, initialValue = 1)
public class Desempenho_Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desempenho")
    private int idDesempenhoNivel;
    private int qtdPontosObtidos;
    private float totalGorjetas;
    private int notaTotal;
    @ManyToOne
    @JoinColumn(name = "execucaco_pedido_id_execucao")
    private Execucaco_Pedido execucaco_pedido; //tem que poder receber várias

    public Desempenho_Nivel(int qtdPontosObtidos, float totalGorjetas, int notaTotal, Execucaco_Pedido execucaco_pedido) {
        this.qtdPontosObtidos = qtdPontosObtidos;
        this.totalGorjetas = totalGorjetas;
        this.notaTotal = notaTotal;
        this.execucaco_pedido = execucaco_pedido;
    }

    public Desempenho_Nivel() {
    }

    public int getIdDesempenhoNivel() {
        return idDesempenhoNivel;
    }

    public void setIdDesempenhoNivel(int idDesempenhoNivel) {
        this.idDesempenhoNivel = idDesempenhoNivel;
    }

    public int getQtdPontosObtidos() {
        return qtdPontosObtidos;
    }

    public void setQtdPontosObtidos(int qtdPontosObtidos) {
        this.qtdPontosObtidos = qtdPontosObtidos;
    }

    public float getTotalGorjetas() {
        return totalGorjetas;
    }

    public void setTotalGorjetas(float totalGorjetas) {
        this.totalGorjetas = totalGorjetas;
    }

    public int getNotaTotal() {
        return notaTotal;
    }

    public void setNotaTotal(int notaTotal) {
        this.notaTotal = notaTotal;
    }

    public Execucaco_Pedido getExecucaco_pedido() {
        return execucaco_pedido;
    }

    public void setExecucaco_pedido(Execucaco_Pedido execucaco_pedido) {
        this.execucaco_pedido = execucaco_pedido;
    }
}
