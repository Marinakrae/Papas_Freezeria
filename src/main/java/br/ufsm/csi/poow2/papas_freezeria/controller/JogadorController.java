package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import br.ufsm.csi.poow2.papas_freezeria.repository.Jogador_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("freezeria/jogador")
public class JogadorController {

    @Autowired
    private Jogador_Repository jogador_repository;

    public JogadorController(Jogador_Repository jogador_repository) {
        this.jogador_repository = jogador_repository;
    }

    @GetMapping("/listar")
    public List<Jogador> getJogador() {
        List<Jogador> Jogador = jogador_repository.findAll();
        for (br.ufsm.csi.poow2.papas_freezeria.model.Jogador jogador : Jogador) {
            jogador.setSenha("******");
        }

        return Jogador;
    }

    @GetMapping("/{id}")
    public Jogador getJogador(@PathVariable("id") int id) {
        Jogador Jogador = jogador_repository.getReferenceById(id);
        Jogador.setSenha("******");
        return Jogador;
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Jogador Jogador) {
        new Jogador();
        Jogador jogadorCriptografado;
        jogadorCriptografado = Jogador;
        jogadorCriptografado.setSenha(new BCryptPasswordEncoder().encode(Jogador.getSenha()));
        jogador_repository.save(Jogador);
    }


    //substituir pela inativação
    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Jogador jogador) {
        jogador_repository.delete(jogador);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable("id") int id, @RequestBody Jogador jogador) {
        Jogador jogadorEditado;
        jogadorEditado = jogador_repository.getReferenceById(id);
        jogadorEditado.setEmail(jogador.getEmail());
        jogadorEditado.setNome(jogador.getNome());
        jogadorEditado.setPermissao(jogador.getPermissao());
        jogadorEditado.setSenha(new BCryptPasswordEncoder().encode(jogador.getSenha()));

        jogador_repository.save(jogadorEditado);
    }



}
