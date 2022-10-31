package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Desempenho_Nivel;
import br.ufsm.csi.poow2.papas_freezeria.repository.Desempenho_Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class DesempenhoController {

    private static Desempenho_Repository desempenho_repository;

    public static List<Desempenho_Nivel> getInfoJogadores() {
        List<Desempenho_Nivel> Desempenho_Nivel = desempenho_repository.findAll();
        return Desempenho_Nivel;
    }

    public Desempenho_Nivel getInfoJogador(@PathVariable("id") int id) {
        Desempenho_Nivel Desempenho_Nivel = desempenho_repository.getReferenceById(id);
        return Desempenho_Nivel;
    }

    public static void salvar(@RequestBody Desempenho_Nivel Desempenho_Nivel) {
        desempenho_repository.save(Desempenho_Nivel);
    }

    public static void apagar(@RequestBody Desempenho_Nivel Desempenho_Nivel) {
        desempenho_repository.delete(Desempenho_Nivel);
    }

    public static void editar(@PathVariable("id") int id, @RequestBody Desempenho_Nivel desempenhoNivel) {
        Desempenho_Nivel desempenhoNivelEditado = new Desempenho_Nivel();
        desempenhoNivelEditado = desempenho_repository.getReferenceById(id);
        desempenhoNivelEditado.setExecucaco_pedido(desempenhoNivel.getExecucaco_pedido());
        desempenhoNivelEditado.setNotaTotal(desempenhoNivel.getNotaTotal());
        desempenhoNivelEditado.setQtdPontosObtidos(desempenhoNivel.getQtdPontosObtidos());

        desempenho_repository.save(desempenhoNivelEditado);
    }
}
