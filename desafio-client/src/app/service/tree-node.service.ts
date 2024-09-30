import { Injectable } from '@angular/core';
import {Diretorio} from "../models/diretorio";
import {TreeNode} from "primeng/api";
import {Arquivo} from "../models/arquivo";

@Injectable({
  providedIn: 'root'
})
export class TreeNodeService {
  constructor() { }

  public diretoriosToTreeNode(diretorios: Diretorio[]): TreeNode[] {
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
                dataCriacaoDiretorio: arquivo.dataCriacaoArquivo
              }
            })
          });
        }
        if(diretorio.subDiretorios) {
          node.children = node.children!.concat(this.diretoriosToTreeNode(diretorio.subDiretorios));
        }

        treeNode.push(node);
      }
    });
    return treeNode;
  }

  public arquivosToTreeNode(arquivos: Arquivo[]): TreeNode[] {
    let treeNode: TreeNode[] = [];
    arquivos.map(arquivo => {
      let node: TreeNode =
        {
          data: {
            nome: arquivo.nomeArquivo,
            dataCriacaoDiretorio: arquivo.dataCriacaoArquivo
          },
          children: []
        };
      treeNode.push(node);
    });
    return  treeNode;
  }



  }
