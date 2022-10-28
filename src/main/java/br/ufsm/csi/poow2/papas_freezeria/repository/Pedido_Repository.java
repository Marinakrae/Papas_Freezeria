package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Pedido_Repository extends JpaRepository<Pedido, Integer> {

}



