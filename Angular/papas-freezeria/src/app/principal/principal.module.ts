import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrincipalComponent } from './principal.component';
import {RouterModule, RouterOutlet} from "@angular/router";
import {ClienteModule} from "./cliente/cliente.module";
import {ComplementosModule} from "./complementos/complementos.module";
import {JogadorModule} from "./jogador/jogador.module";
import {NivelModule} from "./nivel/nivel.module";
import {HomeComponent} from "../home/home.component";



@NgModule({
  declarations: [
    PrincipalComponent
  ],
    imports: [
        CommonModule,
        RouterOutlet,
        RouterModule,
        ClienteModule,
        ComplementosModule,
        JogadorModule,
        NivelModule,
        HomeComponent
    ]
})
export class PrincipalModule { }
