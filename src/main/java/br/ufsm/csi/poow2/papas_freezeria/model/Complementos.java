package br.ufsm.csi.poow2.papas_freezeria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name = "seq_complementos", sequenceName = "seq_complementos", allocationSize = 1, initialValue = 1)
public class Complementos implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_complementos")
    private int idComplementos;
    private String complemento1;
    private String complemento2;
    private String complemento3;

    public Complementos(String complemento1, String complemento2, String complemento3) {
        this.complemento1 = complemento1;
        this.complemento2 = complemento2;
        this.complemento3 = complemento3;
    }

    public Complementos() {
    }

    public int getIdComplementos() {
        return idComplementos;
    }

    public void setIdComplementos(int idComplementos) {
        this.idComplementos = idComplementos;
    }

    public String getComplemento1() {
        return complemento1;
    }

    public void setComplemento1(String complemento1) {
        this.complemento1 = complemento1;
    }

    public String getComplemento2() {
        return complemento2;
    }

    public void setComplemento2(String complemento2) {
        this.complemento2 = complemento2;
    }

    public String getComplemento3() {
        return complemento3;
    }

    public void setComplemento3(String complemento3) {
        this.complemento3 = complemento3;
    }
}
