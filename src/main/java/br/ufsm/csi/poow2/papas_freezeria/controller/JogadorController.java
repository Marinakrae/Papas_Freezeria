package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import br.ufsm.csi.poow2.papas_freezeria.repository.Jogador_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("freezeria/jogador")
public class JogadorController {

    @Autowired
    private static Jogador_Repository jogador_repository;

    @GetMapping("/listar")
    public static List<Jogador> getJogador() {
        List<Jogador> Jogador = jogador_repository.findAll();
        return Jogador;
    }

    @GetMapping("/{id}")
    public Jogador getJogador(@PathVariable("id") int id) {
        Jogador Jogador = jogador_repository.getReferenceById(id);
        return Jogador;
    }

    @PostMapping("/salvar")
    public static void salvar(@RequestBody Jogador Jogador) {
        jogador_repository.save(Jogador);
    }

    //delete mapping?
    @PostMapping("/apagar")
    public static void apagar(@RequestBody Jogador Jogador) {
        jogador_repository.delete(Jogador);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Jogador jogador) {
        Jogador jogadorEditado = new Jogador();
        jogadorEditado = jogador_repository.getReferenceById(id);
        jogadorEditado.setEmail(jogador.getEmail());
        jogadorEditado.setNome(jogador.getNome());
        jogadorEditado.setPermissao(jogador.getPermissao());

        jogador_repository.save(jogadorEditado);
    }



}
