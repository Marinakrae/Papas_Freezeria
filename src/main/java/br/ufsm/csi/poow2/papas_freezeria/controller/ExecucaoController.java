package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Execucaco_Pedido;
import br.ufsm.csi.poow2.papas_freezeria.repository.Execucao_Repository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class ExecucaoController {

    private final Execucao_Repository execucao_repository;

    public ExecucaoController(Execucao_Repository execucao_repository) {
        this.execucao_repository = execucao_repository;
    }

    public List<Execucaco_Pedido> getExecucaoPedidos() {
        return execucao_repository.findAll();
    }

    public Execucaco_Pedido getExecucaoPedido(int id) {
        return execucao_repository.getReferenceById(id);
    }

    public void salvar(Execucaco_Pedido Execucaco_Pedido) {
        execucao_repository.save(Execucaco_Pedido);
    }

    //substituir pela inativação
    public void apagar(Execucaco_Pedido Execucaco_Pedido) {
        execucao_repository.delete(Execucaco_Pedido);
    }

    public void editar(int id, Execucaco_Pedido execucaoPedido) {
        new Execucaco_Pedido();
        Execucaco_Pedido execucaoPedidoEditado;
        execucaoPedidoEditado = execucao_repository.getReferenceById(id);
        execucaoPedidoEditado.setPedido(execucaoPedido.getPedido());
        execucaoPedidoEditado.setNota(execucaoPedido.getNota());
        execucaoPedidoEditado.setNumAcertos(execucaoPedido.getNumAcertos());

        execucao_repository.save(execucaoPedidoEditado);
    }
}
