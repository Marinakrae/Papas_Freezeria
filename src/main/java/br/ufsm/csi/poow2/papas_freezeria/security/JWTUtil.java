package br.ufsm.csi.poow2.papas_freezeria.security;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static  final long TEMPO_VIDA = Duration.ofSeconds(40).toMillis();

    public String geraToken(Jogador jogador) {

        final Map<String, Object> claims = new HashMap<>();
        claims.put("sub", jogador.getEmail());
        claims.put("permissoes: ", jogador.getPermissao());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+ TEMPO_VIDA))
                .signWith(SignatureAlgorithm.HS256, "poow2") //chave de segurança para descriptografar o token
                .compact();
    }

    public String getUsernameToken(String token){
        if(token != null){
            return this.parseToken(token).getSubject();
        } else {
            return null;
        }
    }

    public boolean isTokenExpirado(String token){
        //testa se a data de expiracao é maior do que a data atual
        return this.parseToken(token).getExpiration().before(new Date());
    }

    private Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey("poow2")
                .parseClaimsJws(token.replace("Bearer", ""))
                .getBody();
    }
}
