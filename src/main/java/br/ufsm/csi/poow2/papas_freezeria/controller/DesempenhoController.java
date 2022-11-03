package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Desempenho_Nivel;
import br.ufsm.csi.poow2.papas_freezeria.repository.Desempenho_Repository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class DesempenhoController {

    private static Desempenho_Repository desempenho_repository;

    public DesempenhoController(Desempenho_Repository desempenho_repository) {
        this.desempenho_repository = desempenho_repository;
    }

    public static List<Desempenho_Nivel> getInfoJogadores() {
        List<Desempenho_Nivel> Desempenho_Nivel = desempenho_repository.findAll();
        return Desempenho_Nivel;
    }

    public Desempenho_Nivel getInfoJogador(int id) {
        Desempenho_Nivel Desempenho_Nivel = desempenho_repository.getReferenceById(id);
        return Desempenho_Nivel;
    }

    public static void salvar(Desempenho_Nivel Desempenho_Nivel) {
        desempenho_repository.save(Desempenho_Nivel);
    }

    public void apagar(Desempenho_Nivel desempenhoNivel) {
        desempenho_repository.delete(desempenhoNivel);
    }


    public static void editar( int id, Desempenho_Nivel desempenhoNivel) {
        Desempenho_Nivel desempenhoNivelEditado = new Desempenho_Nivel();
        desempenhoNivelEditado = desempenho_repository.getReferenceById(id);
        desempenhoNivelEditado.setExecucaco_pedido(desempenhoNivel.getExecucaco_pedido());
        desempenhoNivelEditado.setNotaTotal(desempenhoNivel.getNotaTotal());
        desempenhoNivelEditado.setQtdPontosObtidos(desempenhoNivel.getQtdPontosObtidos());

        desempenho_repository.save(desempenhoNivelEditado);
    }
}
