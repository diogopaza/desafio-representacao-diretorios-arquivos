# desafio-representacao-diretorios-arquivos

<h3>Tecnologias/Ferramentas utilizadas:</h3>
<ul>
  <li>Java (versao 21)- Spring: backend</li>
  <li>MySql: banco de dados</li>
  <li>Angular (versão 15): frontend</li>
  <li>Docker: conteinerização da aplicação</li>
  <li>Docker Compose: múltiplos containers</li>
  <li>Postman: requisições HTTP</li>
</ul>

<h3>Organização do projeto:</h3>
    <ul>
        <li>Frontend é o projeto desafio-client</li>
        <li>Backend é o projeto desafio-server</li>
    </ul>
<h3>
    Instruções básicas:    
</h3>
<h6>Executar o projeto:</h6>
<p><strong>docker-compose up --build<strong></p>
<p>O arquivo docker-compose disponível na raíz do projeto do github define toda estrutura do projeto. Baixa a imagem docker do projeto backend e frontend e também roda um container mysql.</p>
<p>Por ser um projeto de teste as variáveis de senha já estão setadas no <emph>docker-compose.yml</emph>, mas o ideal seria que fossem setadas no build ou em um arquivo separado.</p>

<ul>
    <li>Java: 8080 porta local e 8080 no container</li>
    <li>Angular: 4200 porta local e 4200 no container</li>
    <li>Mysql: 3306 no container não expõe no localhost</li>
</ul>
<p>Importante essas portas estarem disponíveis na máquina em que o projeto irá ser executado.</p>

<h3>Postman</h3>
<a href='https://drive.google.com/file/d/1D-FDyJoQS-3bLEItnhJd9gJOs3ooxYVM/view?usp=sharing'>link para baixar a colletion do Postman.</a>

<h3>Testes</h3>
<p>Foram criados unitários básicos para o DiretorioModel e ArquivoModel, estando nas classes DiretorioModelTest e ArquivoModelTest.</p>

<h3>Endpoints para chamadas da API</h3>
<h3>Criar um diretório - metódo POST</h3>    
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

<h3>Criar um subdiretório - metódo POST</h3> 
    <p>Importante destacar que um subdiretório é um diretório que referencia a um diretório pai, ou seja está dentro da lista de subdiretórios de um diretório. Processos como editar ou excluir um subdiretório são os mesmos de um diretório. É obrigatório enviar o id do diretório pai.</p>   
    <p>http://localhost:8080/diretorios/subdiretorios</p>  
    <p>Abaixo corpo da requisição:</p> 
    
```json
{
    "nomeDiretorio": "888555",
    "paiDiretorio":  102
}
```
<p>Abaixo exemplo de resposta da API:</p> 

```json
{    
    {
    "id": 252,
    "nomeDiretorio": "888555",
    "dataCriacaoDiretorio": "29/09/2024 11:48",
    "paiDiretorio": {
        "id": 102,
        "nomeDiretorio": "Diretorio 8",
        "dataCriacaoDiretorio": "28/09/2024 17:10",
        "arquivos": [],
        "subDiretorios": [
            252
        ]
    }
}
}
```

<h3>Criar um arquivo - metódo POST</h3>   
    <p>Se não for enviado o atributo <strong>diretorio (número id de um diretório (ou subdiretório))</strong>o arquivo não tem uma relação com um diretório (ou subdiretório), ficando listado na raíz do frontend.</p> 
    <p>http://localhost:8080/arquivos</p>  
    <p>Abaixo corpo da requisição:</p> 
    
```json
{
    "nomeArquivo": "arquivo.txt",
    "diretorio": 252
    
}
```
<p>Abaixo exemplo de resposta da API:</p> 

```json
{
    "id": 152,
    "nomeArquivo": "arquivo.txt",
    "dataCriacaoArquivo": "29/09/2024 09:17",
    "diretorio": {
        "id": 57,
        "nomeDiretorio": "Diretorio 7",
        "dataCriacaoDiretorio": "28/09/2024 09:03",
        "arquivos": [
            152
        ],
        "subDiretorios": []
    }
}
```

<h3>Listar todos diretórios - metódo GET</h3>
    <p>http://localhost:8080/diretorios</p>  
    
<p>Abaixo exemplo de resposta da API, listando todos os diretórios (também retorna arquivos e subdiretórios):</p> 

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

<h3>Listar todos os arquivos - metódo GET</h3>    
    <p>http://localhost:8080/arquivos</p>  
    <p>Abaixo corpo da requisição:</p>     

<p>Abaixo exemplo de resposta da API:</p> 

```json
{
    [
    {
        "id": 2,
        "nomeArquivo": "diogo.txt",
        "dataCriacaoArquivo": "26/09/2024 20:30"
    },
    {
        "id": 54,
        "nomeArquivo": "arquivo 5",
        "dataCriacaoArquivo": "28/09/2024 08:57",
        "diretorio": {
            "id": 56,
            "nomeDiretorio": "dentro do 5",
            "dataCriacaoDiretorio": "28/09/2024 08:57",
            "arquivos": [
                54,
                {
                    "id": 55,
                    "nomeArquivo": "arquivo 55",
                    "dataCriacaoArquivo": "28/09/2024 09:03",
                    "diretorio": 56
                }
            ],
            "subDiretorios": [],
            "paiDiretorio": {
                "id": 55,
                "nomeDiretorio": "Diretorio 5",
                "dataCriacaoDiretorio": "28/09/2024 08:56",
                "arquivos": [],
                "subDiretorios": [
                    56
                ]
            }
        }
    }
    ]
}
```

<h3>Listar todos os arquivos que estão na raíz (ou seja não estão vínculados a nenhuma pasta)- metódo GET</h3>    
    <p>http://localhost:8080/arquivos/todosarquivosnaraiz</p>  
    <p>Abaixo corpo da requisição:</p>     

<p>Abaixo exemplo de resposta da API:</p> 

```json
[
    {
        "id": 2,
        "nomeArquivo": "diogo.txt",
        "dataCriacaoArquivo": "26/09/2024 20:30"
    },
    {
        "id": 203,
        "nomeArquivo": "arquivo2.txt",
        "dataCriacaoArquivo": "29/09/2024 10:30"
    },
    {
        "id": 204,
        "nomeArquivo": "arquivo2.txt",
        "dataCriacaoArquivo": "29/09/2024 10:32"
    },
    {
        "id": 205,
        "nomeArquivo": "arquivo2.txt",
        "dataCriacaoArquivo": "29/09/2024 10:33"
    },
    {
        "id": 252,
        "nomeArquivo": "arquivo2.txt",
        "dataCriacaoArquivo": "29/09/2024 10:38"
    },
    {
        "id": 304,
        "nomeArquivo": "arquivo2.doc",
        "dataCriacaoArquivo": "29/09/2024 10:53"
    }
]
```

<h3>Excluir um diretório - metódo DELETE - necessário passar o id do diretório</h3>    
    <p>http://localhost:8080/diretorios/{id}</p>  
    <p>Abaixo corpo da requisição:</p>     

<p>Abaixo exemplo de resposta da API:</p> 

```
Diretório excluído com sucesso!
``` 

<h3>Excluir um arquivo - metódo DELETE - necessário passar o id do arquivo</h3>    
    <p>http://localhost:8080/arquivos/{id}</p>  
    <p>Abaixo corpo da requisição:</p>     

<p>Abaixo exemplo de resposta da API:</p> 

```
Arquivo excluído com sucesso!
``` 

<h3>Atualizar um diretório - metódo PATCH - necessário passar o id do diretório</h3>    
<p>Caso seja um subdiretório é possível alterar o diretório pai, passando no corpo da requisição o atributo <strong>paiDiretorio</strong> com o id do diretório pai.</p>
    <p>http://localhost:8080/diretorios/{id}</p>  
    <p>Abaixo corpo da requisição:</p> 
    
```json
{   
    "nomeDiretorio": "Diretorio 5000"   
}
```
<p>Abaixo exemplo de resposta da API:</p> 

```json
{
    "id": 55,
    "nomeDiretorio": "Diretorio 5000",
    "dataCriacaoDiretorio": "28/09/2024 08:56",
    "arquivos": [],
    "subDiretorios": [
        {
            "id": 56,
            "nomeDiretorio": "dentro do 5",
            "dataCriacaoDiretorio": "28/09/2024 08:57",
            "arquivos": [
                {
                    "id": 54,
                    "nomeArquivo": "arquivo 5",
                    "dataCriacaoArquivo": "28/09/2024 08:57",
                    "diretorio": 56
                },
                {
                    "id": 55,
                    "nomeArquivo": "arquivo 55",
                    "dataCriacaoArquivo": "28/09/2024 09:03",
                    "diretorio": 56
                }
            ],
            "subDiretorios": [],
            "paiDiretorio": 55
        }
    ]
}
```

<h3>Atualizar um arquivo - metódo PATCH - necessário passar o id do arquivo</h3>
    <p>É possível alterar o nome do arquivo e o diretório onde o arquivo está localizado. Pode-se enviar os dois atributos ou somente um dos campos.</p>    
    <p>http://localhost:8080/arquivos/{id}</p>  
    <p>Abaixo corpo da requisição:</p> 
    
```json
 {        
        "nomeArquivo": "atualizado2",
        "diretorio": 252   
        
}
```
<p>Abaixo exemplo de resposta da API:</p> 

```json
{
    "id": 55,
    "nomeArquivo": "atualizado2",
    "dataCriacaoArquivo": "28/09/2024 09:03"
}
```




