
## Dimensa - Avaliação para Desenvolvedores
Este teste é destinado a todos os níveis de carreira, portanto, não esperamos que todos consigam entregar a solução completa.

### Instruções

- **Objetivo:** Criar uma API RESTful capaz de gerenciar contatos e hospeda-la em nuvem.
- **Tecnologia:** Java
- **Entregáveis:** link do repositório e o link da api rodando num servidor da nuvem

- **Importante:**
  Você deve utilizar qualquer serviço **gratuito** para hospedar a aplicação, base de dados e seu codigo.
  (AWS, Azure..) (github, bitbucket...)

### Desafio

- A sua API é um **CRUD**, portanto, deve ter os endpoint:
    - Listar todos os contatos
    - Cadastrar um novo contato
    - Alterar os dados de um contato
    - Excluir um contato

- Utilizar os métodos GET, POST, PUT, PATCH e um DELETE

- O contato precisa ter os seguintes campos:
    - Nome
    - E-mail
    - Telefone
    - Data de Nascimento
    - Lista de Endereços (cada endereço tem uma rua, número e cep)

- **Dicas**:
    - Documente seu projeto em arquivos markdown (README.md) com as instruções necessárias para que qualquer pessoa consiga rodar sua aplicação.
    - Use boas práticas de programação.
    - Documentação Swagger é um diferencial


### Instruções

- Baixe o instalador Mysql Installer MSI (https://dev.mysql.com/downloads/installer/), escolha as opçoes Server e Workbench.
- Ao instalar o Mysql, rodar os dumps que se encontram na pasta db deste projeto.
- **Instruções de DUMP e Download Banco:** https://www.alura.com.br/artigos/restaurar-backup-banco-de-dados-mysql
- Baixe o JDK 8, o projeto é configurado na versão Java 1.8 (https://www.oracle.com/java/technologies/downloads/#java8).
- Faça o download do Maven (https://maven.apache.org/download.cgi).
- **Observação:** O Java e o Maven devem estar configurados nas variaveis de ambiente. Ex:(https://olamundo-java.blogspot.com/2019/10/configurando-o-maven-no-windows.html).
  -Download da IDE(Recomendação): https://www.jetbrains.com/idea/.
- Neste projeto se encontram dois arquivos application.properties, uma referente ao perfil local e outro com perfil dev
  - O arquivo application-local.properties esta apontando para o banco local que você ira configurar em sua maquina 
  - O arquivo application-dev.properties esta apontando para o banco MYSql AWS RDS, o banco de dados armazenado em nuvem
  - certifique-se de estar com o perfil correto na hora de subir e utilizar a aplicação

### Swagger
- Ao subir o projeto localmente, o swagger estara apontado para o endereço: http://localhost:8080/swagger-ui/index.html.

### Swagger AWS
- Para Acessar a Aplicação em Hospedagem AWS
  - http://ec2-16-170-234-149.eu-north-1.compute.amazonaws.com:8080/swagger-ui/index.html#/
