import { Component } from '@angular/core';
import { TreeNode } from 'primeng/api';
import {Diretorio} from "./models/diretorio";
import {DiretorioService} from "./service/diretorio.service";
import {TreeNodeService} from "./service/tree-node.service";
import {ArquivoService} from "./service/arquivo.service";

interface Column {
  field: string;
  header: string;
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private diretorioService: DiretorioService,
              private arquivoService: ArquivoService,
              private treeNodeService: TreeNodeService) {}
  files: TreeNode[] = [];
  cols!: Column[];
  title = 'desafio-client';

  ngOnInit() {
    this.cols = [
      { field: 'nome', header: 'Diretorio'},
      { field: 'dataCriacaoDiretorio', header: 'Data criação' }
    ];
    this.getAllDiretoriosAndArquivos();
  }

  getAllDiretoriosAndArquivos() {
    this.diretorioService.getDiretorios().subscribe(diretorios => {
      this.files = this.treeNodeService.diretoriosToTreeNode(diretorios);
      this.arquivoService.getArquivosNaRaiz().subscribe(arquivos => {
        this.files = this.files.concat(this.treeNodeService.arquivosToTreeNode(arquivos));
        console.log(this.files);
      });
    });
  }
}
