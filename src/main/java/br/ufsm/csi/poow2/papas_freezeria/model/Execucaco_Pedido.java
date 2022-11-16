package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_execucao", sequenceName = "seq_execucao", allocationSize = 1)
public class Execucaco_Pedido implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_execucao")
    private int id_execucao;
    @Column
    private int num_acertos;
    @Column
    private int nota;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "pedido_id_pedido")
    private Pedido pedido;

    public int getNumAcertos() {
        return num_acertos;
    }

    public void setNumAcertos(int numAcertos) {
        this.num_acertos = numAcertos;
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
