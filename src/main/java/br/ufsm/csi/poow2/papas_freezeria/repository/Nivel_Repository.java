package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nivel_Repository extends JpaRepository<Nivel, Integer> {

}


