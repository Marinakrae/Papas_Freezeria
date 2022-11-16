package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_desempenho", sequenceName = "seq_desempenho", allocationSize = 1)
public class Desempenho_Nivel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desempenho")
    private int id_desempenho_nivel;
    @Column
    private int qtd_pontos_obtidos;
    @Column
    private int nota_total;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "execucaco_pedido_id_execucao")
    private Execucaco_Pedido execucaco_pedido; //tem que poder receber várias

    public int getIdDesempenhoNivel() {
        return id_desempenho_nivel;
    }

    public void setIdDesempenhoNivel(int idDesempenhoNivel) {
        this.id_desempenho_nivel = idDesempenhoNivel;
    }

    public int getQtdPontosObtidos() {
        return qtd_pontos_obtidos;
    }

    public void setQtdPontosObtidos(int qtdPontosObtidos) {
        this.qtd_pontos_obtidos = qtdPontosObtidos;
    }

    public int getNotaTotal() {
        return nota_total;
    }

    public void setNotaTotal(int notaTotal) {
        this.nota_total = notaTotal;
    }

    public Execucaco_Pedido getExecucaco_pedido() {
        return execucaco_pedido;
    }

    public void setExecucaco_pedido(Execucaco_Pedido execucaco_pedido) {
        this.execucaco_pedido = execucaco_pedido;
    }
}
