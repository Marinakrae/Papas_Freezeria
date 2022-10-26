package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import org.springframework.stereotype.Repository;

@Repository
public interface Jogador_Repository_Custom {
    Jogador getUsuario(String username);
}
