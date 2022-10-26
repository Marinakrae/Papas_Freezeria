package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jogador_Repository extends JpaRepository<Jogador, Integer>, Jogador_Repository_Custom {

}


