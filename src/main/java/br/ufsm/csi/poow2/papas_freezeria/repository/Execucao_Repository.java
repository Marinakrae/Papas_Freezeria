package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Execucaco_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Execucao_Repository extends JpaRepository<Execucaco_Pedido, Integer>{

}