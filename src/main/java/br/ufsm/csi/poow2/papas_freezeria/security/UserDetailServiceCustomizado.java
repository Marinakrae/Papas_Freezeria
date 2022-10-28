package br.ufsm.csi.poow2.papas_freezeria.security;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import br.ufsm.csi.poow2.papas_freezeria.repository.Jogador_Repository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class UserDetailServiceCustomizado implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Jogador usuario = Jogador_Repository.getUsuarioByUser(username);

        if(usuario==null){
            throw new UsernameNotFoundException("Usuário ou senha incorretos");
        } else{
            UserDetails user = User.withUsername(usuario.getEmail())
                    .password(usuario.getSenha())
                    .authorities(usuario.getPermissao()).build();
            return user;
        }
    }
}
