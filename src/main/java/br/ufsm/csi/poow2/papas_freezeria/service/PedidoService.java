//package br.ufsm.csi.poow2.papas_freezeria.service;
//
//import br.ufsm.csi.poow2.papas_freezeria.model.*;
//
//import java.util.ArrayList;
//
//public class PedidoService {
//
//    static ArrayList<Pedido> pedidos = new ArrayList<>();
//
//    public static Pedido GetClienteById (int id){
//        Pedido pedido = new Pedido();
//
//        for (int i=0; i< pedidos.size(); i++){
//            pedido = pedidos.get(i);
//            if (pedido.getIdPedido() == id){
//                break;
//            }
//        }
//        return pedido;
//    }
//
//    public static Pedido getPedido(int id){
//        int posicao = 0;
//        Pedido pedido = new Pedido();
//
//        pedido = GetClienteById(id);
//
//        //Encontrar a posição do array que possui o cliente
//        for (int i=0; i< pedidos.size(); i++){
//            posicao = pedidos.indexOf(pedido);
//        }
//        return pedidos.get(posicao);
//    }
//
//    public static ArrayList<Pedido> getPedidos(){
//        Complementos complementos = new Complementos("Amendoim", null, null);
//        Complementos complementos2 = new Complementos("Morango", "Granola", "Ovomaltine");
//        pedidos.add(new Pedido(1,"G", "Banana", "Morango", "Baunilha", complementos));
//        pedidos.add(new Pedido(2,"M", "Chocolate", "Chocolate", "Chocolate", complementos2));;
//        return pedidos;
//    }
//
//    public static void salvar(Pedido c){
//        pedidos.add(c);
//    }
//
//    public static void apagar(Pedido c){
//        Pedido pedido = new Pedido();
//
//        for (int i=0; i< pedidos.size(); i++){
//            if (pedidos.get(i).getIdPedido() == c.getIdPedido()){
//                pedido = pedidos.get(i);
//            }
//        }
//
//        pedidos.remove(pedido);
//    }
//
//    public static void editar(int id, Pedido c){
//        int posicao = 0;
//        Pedido pedido = new Pedido();
//
//        pedido = GetClienteById(id);
//
//        for (int i=0; i< pedidos.size(); i++){
//            posicao = pedidos.indexOf(pedido);
//        }
//
//        pedidos.set(posicao, c);
//
//    }
//
//}
