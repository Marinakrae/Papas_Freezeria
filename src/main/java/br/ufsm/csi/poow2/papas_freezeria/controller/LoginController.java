package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import br.ufsm.csi.poow2.papas_freezeria.repository.Jogador_Repository;
import br.ufsm.csi.poow2.papas_freezeria.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private Jogador_Repository jogador_repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/freezeria/login")
    public ResponseEntity<Object> autenticacao(@RequestBody Jogador usuario){
        System.out.println("User: "+usuario.getEmail());
        System.out.println("Senha: "+usuario.getSenha());

        try {
            final Authentication autenticado = this.authenticationManager.authenticate
                                        (new UsernamePasswordAuthenticationToken(usuario.getEmail(),usuario.getSenha()));
            if(autenticado.isAuthenticated()){
                //colocamos nossa instancia de autenticado no contexto do spring security
                SecurityContextHolder.getContext().setAuthentication(autenticado);

                System.out.println("Gerando token de autorizacao ****");
                String token = new JWTUtil().geraToken(usuario);
                usuario.setToken(token);

                usuario.setSenha("******");
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
    }

}
