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
    private static Pedido_Repository pedido_repository;

    public PedidoController(Pedido_Repository pedido_repository) {
        this.pedido_repository = pedido_repository;
    }

    @GetMapping("/listar")
    public static List<Pedido> getPedido() {
        List<Pedido> pedidos = pedido_repository.findAll();
        return pedidos;
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id") int id) {
        Pedido pedido = pedido_repository.getReferenceById(id);
        return pedido;
    }

    @PostMapping("/salvar")
    public static void salvar(@RequestBody Pedido pedido) {
        pedido_repository.save(pedido);
        //chamar a url com objeto preenchido
    }

    //delete mapping?
    @DeleteMapping("/apagar/{id}")
    public void apagar(@PathVariable("id") int id) {
        Pedido pedido = pedido_repository.getReferenceById(id);
        pedido_repository.delete(pedido);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Pedido pedido) {
        Pedido pedidoEditado = new Pedido();
        pedidoEditado = pedido_repository.getReferenceById(id);
        pedidoEditado.setCalda(pedido.getCalda());
        pedidoEditado.setComplementos(pedido.getComplementos());
        pedidoEditado.setNivel(pedido.getNivel());
        pedidoEditado.setSabor(pedido.getSabor());
        pedidoEditado.setSaborChantilly(pedido.getSaborChantilly());
        pedidoEditado.setTamCopo(pedido.getTamCopo());

        pedido_repository.save(pedidoEditado);
    }
}
