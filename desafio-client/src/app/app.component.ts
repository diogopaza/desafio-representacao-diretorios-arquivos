import { Component } from '@angular/core';
import { TreeNode } from 'primeng/api';
import {NodeService} from "./service/nodeservice";
import {Diretorio} from "./models/diretorio";
import {DiretorioService} from "./service/diretorio.service";
import {TreeNodeService} from "./service/tree-node.service";

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

  constructor(private nodeService: NodeService,
              private diretorioService: DiretorioService,
              private treeNodeService: TreeNodeService) {}
  files!: TreeNode[];
  cols!: Column[];
  title = 'desafio-client';

  ngOnInit() {
    this.cols = [
      { field: 'nome', header: 'Diretorio'},
      { field: 'dataCriacaoDiretorio', header: 'Data criação' },
      { field: '', header: 'Ações' },
    ];
    this.getAllDiretorios();
  }

  getAllDiretorios() {
    this.diretorioService.getDiretorios().subscribe(diretorios => {
      this.files = this.treeNodeService.toTreeNode(diretorios);
      console.log(diretorios);
    })
  }
}
