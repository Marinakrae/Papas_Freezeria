package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Execucaco_Pedido;
import br.ufsm.csi.poow2.papas_freezeria.repository.Execucao_Repository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class ExecucaoController {

    private static Execucao_Repository execucao_repository;

    public ExecucaoController(Execucao_Repository execucao_repository) {
        this.execucao_repository = execucao_repository;
    }

    public static List<Execucaco_Pedido> getExecucaoPedidos() {
        List<Execucaco_Pedido> Execucaco_Pedido = execucao_repository.findAll();
        return Execucaco_Pedido;
    }

    public Execucaco_Pedido getExecucaoPedido(int id) {
        Execucaco_Pedido Execucaco_Pedido = execucao_repository.getReferenceById(id);
        return Execucaco_Pedido;
    }

    public static void salvar(Execucaco_Pedido Execucaco_Pedido) {
        execucao_repository.save(Execucaco_Pedido);
    }

    public void apagar(Execucaco_Pedido Execucaco_Pedido) {
        execucao_repository.delete(Execucaco_Pedido);
    }

    public static void editar(int id, Execucaco_Pedido execucaoPedido) {
        Execucaco_Pedido execucaoPedidoEditado = new Execucaco_Pedido();
        execucaoPedidoEditado = execucao_repository.getReferenceById(id);
        execucaoPedidoEditado.setPedido(execucaoPedido.getPedido());
        execucaoPedidoEditado.setNota(execucaoPedido.getNota());
        execucaoPedidoEditado.setNumAcertos(execucaoPedido.getNumAcertos());

        execucao_repository.save(execucaoPedidoEditado);
    }
}
