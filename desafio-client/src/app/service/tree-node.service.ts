import { Injectable } from '@angular/core';
import {Diretorio} from "../models/diretorio";
import {TreeNode} from "primeng/api";

@Injectable({
  providedIn: 'root'
})
export class TreeNodeService {
  constructor() { }

  public toTreeNode(diretorios: Diretorio[]): TreeNode[] {
    let treeNode: TreeNode[] = [];
    diretorios.map(diretorio => {
      if(diretorio.id){
        let node: TreeNode =
          {
            data: {
              nome: diretorio.nomeDiretorio,
              dataCriacaoDiretorio: diretorio.dataCriacaoDiretorio
            },
            children: []
          };
        if(diretorio.arquivos){
          diretorio.arquivos.forEach(arquivo => {
            node.children?.push({
              data: {
                nome: arquivo.nomeArquivo,
                dataCriacaoDiretorio: arquivo.dataCriacao
              }
            })
          });
        }
        if(diretorio.subDiretorios) {
          node.children = node.children!.concat(this.toTreeNode(diretorio.subDiretorios));
        }
        treeNode.push(node);
      }
    });
    return treeNode;
  }


}
