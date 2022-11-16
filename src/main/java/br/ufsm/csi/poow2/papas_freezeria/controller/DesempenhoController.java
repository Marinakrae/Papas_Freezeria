package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Desempenho_Nivel;
import br.ufsm.csi.poow2.papas_freezeria.repository.Desempenho_Repository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class DesempenhoController {

    private final Desempenho_Repository desempenho_repository;

    public DesempenhoController(Desempenho_Repository desempenho_repository) {
        this.desempenho_repository = desempenho_repository;
    }

    public List<Desempenho_Nivel> getInfoJogadores() {
        return desempenho_repository.findAll();
    }

    public Desempenho_Nivel getInfoJogador(int id) {
        return desempenho_repository.getReferenceById(id);
    }

    public void salvar(Desempenho_Nivel Desempenho_Nivel) {
        desempenho_repository.save(Desempenho_Nivel);
    }

    //substituir pela inativação
    public void apagar(Desempenho_Nivel desempenhoNivel) {
        desempenho_repository.delete(desempenhoNivel);
    }


    public void editar( int id, Desempenho_Nivel desempenhoNivel) {
        new Desempenho_Nivel();
        Desempenho_Nivel desempenhoNivelEditado;
        desempenhoNivelEditado = desempenho_repository.getReferenceById(id);
        desempenhoNivelEditado.setExecucaco_pedido(desempenhoNivel.getExecucaco_pedido());
        desempenhoNivelEditado.setNotaTotal(desempenhoNivel.getNotaTotal());
        desempenhoNivelEditado.setQtdPontosObtidos(desempenhoNivel.getQtdPontosObtidos());

        desempenho_repository.save(desempenhoNivelEditado);
    }
}
