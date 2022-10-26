package br.ufsm.csi.poow2.papas_freezeria.repository_custom;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Jogador_Repository_Custom implements br.ufsm.csi.poow2.papas_freezeria.repository.Jogador_Repository_Custom {

    @Autowired
    @Lazy
    public Jogador getUsuario(String user) {
        if (user.equals("marina@teste")) {
            //criptografar a senha
            return new Jogador(1, "Marina", user, new BCryptPasswordEncoder().encode("123"), "ADMIN");
            //aqui seria a consulta para trazer o usuário
        } else if (user.equals("claudia@teste")) {
            return new Jogador(2, "Claudia", user, new BCryptPasswordEncoder().encode("1234"), "USER");
        } else {
            return null;
        }
    }
}

