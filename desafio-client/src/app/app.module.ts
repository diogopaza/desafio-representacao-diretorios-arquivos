import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TreeTableModule } from 'primeng/treetable';
import { ButtonModule } from 'primeng/button';
import { CommonModule } from '@angular/common';
import {DiretorioService} from "./service/diretorio.service";
import {TreeNodeService} from "./service/tree-node.service";
import {ArquivoService} from "./service/arquivo.service";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TreeTableModule,
    ButtonModule,
    CommonModule

  ],
  providers: [
              DiretorioService,
              ArquivoService,
              TreeNodeService,
              provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
