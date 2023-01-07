import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ClienteModule} from "./principal/cliente/cliente.module";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {LoginModule} from "./login/login.module";
import {PrincipalModule} from "./principal/principal.module";

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ClienteModule,
        NgbModule,
        LoginModule,
        PrincipalModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
