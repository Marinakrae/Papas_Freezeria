package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_execucao", sequenceName = "seq_execucao", allocationSize = 1, initialValue = 1)
public class Execucaco_Pedido implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_execucao")
    private int idExecucao;
    private int numAcertos;
    private int nota;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedido;

    public Execucaco_Pedido( int numAcertos, int nota, Pedido pedido) {
        this.numAcertos = numAcertos;
        this.nota = nota;
        this.pedido = pedido;
    }

    public Execucaco_Pedido() {
    }

    public int getNumAcertos() {
        return numAcertos;
    }

    public void setNumAcertos(int numAcertos) {
        this.numAcertos = numAcertos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
