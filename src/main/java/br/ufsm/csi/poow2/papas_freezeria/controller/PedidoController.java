package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Jogador;
import br.ufsm.csi.poow2.papas_freezeria.model.Pedido;
import br.ufsm.csi.poow2.papas_freezeria.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
@RequestMapping("pedido")
public class PedidoController {

    //CRIAR UM objeto PEDIDO DAO AQUI

    //TODOS - SEM AUTENTICAÇÃO
    @GetMapping("/descricao")
    public String toString(){
        return "Controller pedido";
    }

    //USER - ADMIN
    @GetMapping("/listar")
    public static ArrayList<Pedido> getPedido() {
        return new PedidoService().getPedidos();
    }

    @GetMapping("/{id}")
    public static Pedido getPedido(@PathVariable("id") int id) {
        return new PedidoService().getPedido(id);
    }

    //ADMIN
    @PostMapping("/salvar")
    public static void salvar(@RequestBody Pedido pedido) {
        new PedidoService().salvar(pedido);
    }

    //delete mapping?
    @PostMapping("/apagar")
    public static void apagar(@RequestBody Pedido pedido) {
        new PedidoService().apagar(pedido);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Pedido pedido) {
        new PedidoService().editar(id, pedido);
    }

    @GetMapping("/usuario")
    public Jogador usuario(){
        return new Jogador( 1, "Marina", "marina@teste", "123", "ADMIN");
    }

}
