package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido", allocationSize = 1)
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido")
    private int id_Pedido;
    @Column
    private String tam_copo;
    @Column
    private String sabor;
    @Column
    private String calda;
    private String sabor_chantilly;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "complementos_id_complementos")
    private Complementos complementos;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "nivel_id_nivel")
    private Nivel nivel;

    //private boolean ativo;

    public String getTam_copo() {
        return tam_copo;
    }

    public void setTam_copo(String tam_copo) {
        this.tam_copo = tam_copo;
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
        return sabor_chantilly;
    }

    public void setSaborChantilly(String saborChantilly) {
        this.sabor_chantilly = saborChantilly;
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

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public String getSabor_chantilly() {
        return sabor_chantilly;
    }

    public void setSabor_chantilly(String sabor_chantilly) {
        this.sabor_chantilly = sabor_chantilly;
    }
}
