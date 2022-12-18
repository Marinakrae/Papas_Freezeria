import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ClienteModule} from "./cliente/cliente.module";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ClienteModule,
        NgbModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
