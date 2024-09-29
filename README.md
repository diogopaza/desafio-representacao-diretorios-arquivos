# desafio-representacao-diretorios-arquivos

<h3>Tecnologias utilizadas:</h3>
<ul>
  <li>Java - Spring: backend</li>
  <li>MySql: banco de dados</li>
  <li>Angular: frontend</li>
  <li></li>
  <li></li>
</ul>

<h3>Organização do projeto:</h3>
    <ul>
        <li>Front end é o projeto desafio-client</li>
        <li>Back end é o projeto desafio-server</li>
    </ul>

<h3>Endpoints para chamadas da API</h3>
<h4>1- Criar um diretório - metódo POST</h4>    
    <p>http://localhost:8080/diretorios</p>  
    <p>Abaixo corpo da requisição:</p> 
    
```json
{
    "nomeDiretorio": "Diretorio 7"
}
```
<p>Abaixo exemplo de resposta da API:</p> 

```json
{    
    "id": 102,
    "nomeDiretorio": "Diretorio 8",
    "dataCriacaoDiretorio": "28/09/2024 17:10"
}
```

<h4>2- Listar todos diretórios - metódo GET</h4>
    <p>http://localhost:8080/diretorios</p>  
    
<p>Abaixo exemplo de resposta da API, listando todos os diretórios:</p> 

```json
{    
    [
    {
        "id": 1,
        "nomeDiretorio": "Diretorio 1",
        "dataCriacaoDiretorio": "26/09/2024 20:32",
        "arquivos": [
            {
                "id": 3,
                "nomeArquivo": "diogo.txt",
                "dataCriacaoArquivo": "26/09/2024 20:33",
                "diretorio": 1
            }
        ],
        "subDiretorios": [
            {
                "id": 2,
                "nomeDiretorio": "Sub diretorio 4",
                "dataCriacaoDiretorio": "26/09/2024 20:33",
                "arquivos": [],
                "subDiretorios": [
                    {
                        "id": 3,
                        "nomeDiretorio": "Sub diretorio 5",
                        "dataCriacaoDiretorio": "26/09/2024 20:34",
                        "arquivos": [],
                        "subDiretorios": [],
                        "paiDiretorio": 2
                    }
                ],
                "paiDiretorio": 1
            }
        ]
    },
    ]
}

```


 

