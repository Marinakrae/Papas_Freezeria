package br.ufsm.csi.poow2.papas_freezeria.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "seq_complementos", sequenceName = "seq_complementos", allocationSize = 1)
public class Complementos implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_complementos")
    private int id_complementos;
    @Column
    private String complemento1;
    @Column
    private String complemento2;
    @Column
    private String complemento3;

    public int getIdComplementos() {
        return id_complementos;
    }

    public void setIdComplementos(int idComplementos) {
        this.id_complementos = idComplementos;
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
