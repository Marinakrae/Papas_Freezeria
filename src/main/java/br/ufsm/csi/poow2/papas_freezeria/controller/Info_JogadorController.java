package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Info_Jogador;
import br.ufsm.csi.poow2.papas_freezeria.repository.Info_Jogador_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller()
public class Info_JogadorController {

    private static Info_Jogador_Repository info_jogador_repository;

    public Info_JogadorController(Info_Jogador_Repository info_jogador_repository) {
        this.info_jogador_repository = info_jogador_repository;
    }

    public static List<Info_Jogador> getInfoJogadores() {
        List<Info_Jogador> Info_Jogador = info_jogador_repository.findAll();
        return Info_Jogador;
    }

    public Info_Jogador getInfoJogador(@PathVariable("id") int id) {
        Info_Jogador InfoJogador = info_jogador_repository.getReferenceById(id);
        return InfoJogador;
    }

    public static void salvar(@RequestBody Info_Jogador InfoJogador) {
        info_jogador_repository.save(InfoJogador);
    }

    public void apagar(Info_Jogador infoJogador) {
        info_jogador_repository.delete(infoJogador);
    }

    public static void editar(int id, Info_Jogador infoJogador) {
        Info_Jogador infoJogadorEditado = new Info_Jogador();
        infoJogadorEditado = info_jogador_repository.getReferenceById(id);
        infoJogadorEditado.setJogador(infoJogador.getJogador());
        infoJogadorEditado.setNivel(infoJogador.getNivel());
        infoJogadorEditado.setRank(infoJogador.getRank());
        infoJogadorEditado.setTotalPontos(infoJogador.getTotalPontos());

        info_jogador_repository.save(infoJogadorEditado);
    }

}
