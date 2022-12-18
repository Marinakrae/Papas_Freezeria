import {Component, OnInit} from '@angular/core';
import {Cliente} from "./cliente";
import {ClienteService} from "./cliente.service";

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit{

  cliente: Cliente = new Cliente('200', 'Marina', 'Rua xyxyx', false);

  clientes: Cliente[] = [];


  // cliente = {
  //   id: 200,
  //   nome: 'Paola',
  //   endereco: 'Rua x',
  //   ativo: false
  // }

  // clientes = [
  //   {
  //     id: 200,
  //     nome: 'Paola',
  //     endereco: 'Rua x',
  //     ativo: false
  //   },
  //   {
  //     id: 100,
  //     nome: 'Claudia',
  //     endereco: 'Rua das claudias',
  //     ativo: false
  //   },
  //   {
  //     id: 300,
  //     nome: 'Nicoli',
  //     endereco: 'Rua a ',
  //     ativo: true
  //   }
  // ]

  constructor(private service: ClienteService) {
  }

  ngOnInit(): void {
    this.buscarClientes();
  }

  buscarClientes(){
    this.service.listar().subscribe( (dados)=>{
      this.clientes = dados;
    })
  }

  cadastrado = false;

  cadastrar(): void{
    //alert('Cliente cadastrado'+this.cliente.nome+' '+this.cliente.endereco)

    this.service.criar(this.cliente).subscribe(()=>{
      this.cadastrado = true;
      this.buscarClientes();
    });
  }
}
