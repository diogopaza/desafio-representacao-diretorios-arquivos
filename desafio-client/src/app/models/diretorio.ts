import {Arquivo} from "./arquivo";
import {Injectable} from "@angular/core";

export class Diretorio {
  id!: number;
  nomeDiretorio!: string;
  dataCriacaoDiretorio!: string;
  arquivos!: Arquivo[];
  subDiretorios!: Diretorio[];
  paiDiretorio!: Diretorio;

}


