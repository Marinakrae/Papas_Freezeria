package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Pedido;
import br.ufsm.csi.poow2.papas_freezeria.repository.Pedido_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("freezeria/pedido")
public class PedidoController {

    @Autowired
    private Pedido_Repository pedido_repository;

    public PedidoController(Pedido_Repository pedido_repository) {
        this.pedido_repository = pedido_repository;
    }

    @GetMapping("/listar")
    public List<Pedido> getPedido() {
        return pedido_repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id") int id) {
        return pedido_repository.getReferenceById(id);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Pedido pedido) {
        System.out.println(pedido.getTam_copo());
        pedido_repository.save(pedido);
    }

    //substituir pela inativação
    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Pedido pedido) {
        pedido_repository.delete(pedido);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable("id") int id, @RequestBody Pedido pedido) {
        Pedido pedidoEditado;
        pedidoEditado = pedido_repository.getReferenceById(id);
        pedidoEditado.setCalda(pedido.getCalda());
        pedidoEditado.setComplementos(pedido.getComplementos());
        pedidoEditado.setNivel(pedido.getNivel());
        pedidoEditado.setSabor(pedido.getSabor());
        pedidoEditado.setSaborChantilly(pedido.getSaborChantilly());
        pedidoEditado.setTam_copo(pedido.getTam_copo());

        pedido_repository.save(pedidoEditado);
    }
}
