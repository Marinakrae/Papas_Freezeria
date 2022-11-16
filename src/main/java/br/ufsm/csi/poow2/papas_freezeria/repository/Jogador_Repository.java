package br.ufsm.csi.poow2.papas_freezeria.repository;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public interface Jogador_Repository extends JpaRepository<Jogador, Integer>{

    static Jogador getUsuarioByUser(String user) {
        if (user.equals("marina@teste")) {
            return new Jogador(1, "Marina", user, new BCryptPasswordEncoder().encode("123"), "ADMIN");
        } else if (user.equals("claudia@teste")) {
            return new Jogador(2, "Claudia", user, new BCryptPasswordEncoder().encode("1234"), "USER");
        } else {
            return null;
        }
    }

}


