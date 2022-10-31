package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Execucaco_Pedido;
import br.ufsm.csi.poow2.papas_freezeria.repository.Execucao_Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ExecucaoController {

    private static Execucao_Repository execucao_repository;

    public static List<Execucaco_Pedido> getExecucaoPedidos() {
        List<Execucaco_Pedido> Execucaco_Pedido = execucao_repository.findAll();
        return Execucaco_Pedido;
    }

    public Execucaco_Pedido getExecucaoPedido(@PathVariable("id") int id) {
        Execucaco_Pedido Execucaco_Pedido = execucao_repository.getReferenceById(id);
        return Execucaco_Pedido;
    }

    public static void salvar(@RequestBody Execucaco_Pedido Execucaco_Pedido) {
        execucao_repository.save(Execucaco_Pedido);
    }

    @PostMapping("/apagar/{id}")
    public void apagar(@PathVariable("id") int id) {
        Execucaco_Pedido Execucaco_Pedido = execucao_repository.getReferenceById(id);
        execucao_repository.delete(Execucaco_Pedido);
    }

    public static void editar(@PathVariable("id") int id, @RequestBody Execucaco_Pedido execucaoPedido) {
        Execucaco_Pedido execucaoPedidoEditado = new Execucaco_Pedido();
        execucaoPedidoEditado = execucao_repository.getReferenceById(id);
        execucaoPedidoEditado.setPedido(execucaoPedido.getPedido());
        execucaoPedidoEditado.setNota(execucaoPedido.getNota());
        execucaoPedidoEditado.setNumAcertos(execucaoPedido.getNumAcertos());

        execucao_repository.save(execucaoPedidoEditado);
    }
}
