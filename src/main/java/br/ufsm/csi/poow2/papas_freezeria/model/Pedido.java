package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1, initialValue = 1)
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private int idPedido;
    private String tamCopo;
    private String sabor;
    private String calda;
    private String saborChantilly;
    @ManyToOne
    @JoinColumn(name = "complementos_id_complementos")
    private Complementos complementos;
    @ManyToOne
    @JoinColumn(name = "nivel_id_nivel")
    private Nivel nivel;

    public Pedido(int idPedido, String tamCopo, String sabor, String calda, String saborChantilly, Complementos complementos) {
        this.idPedido = idPedido;
        this.tamCopo = tamCopo;
        this.sabor = sabor;
        this.calda = calda;
        this.saborChantilly = saborChantilly;
        this.complementos = complementos;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getTamCopo() {
        return tamCopo;
    }

    public void setTamCopo(String tamCopo) {
        this.tamCopo = tamCopo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getCalda() {
        return calda;
    }

    public void setCalda(String calda) {
        this.calda = calda;
    }

    public String getSaborChantilly() {
        return saborChantilly;
    }

    public void setSaborChantilly(String saborChantilly) {
        this.saborChantilly = saborChantilly;
    }

    public Complementos getComplementos() {
        return complementos;
    }

    public void setComplementos(Complementos complementos) {
        this.complementos = complementos;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
