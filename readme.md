# Projeto de Gerenciamento de Tarefas

Este é um projeto de API REST para gerenciamento de tarefas, desenvolvido com Spring Boot.

## Funcionalidades

- Criar uma nova tarefa
- Atualizar uma tarefa existente
- Listar todas as tarefas
- Obter uma tarefa específica por ID
- Deletar uma tarefa

## Tecnologias Utilizadas

- Java 8
- Spring Boot 2.7.18
- Maven

## Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```

2. Entre no diretório do projeto:
   ```
   cd nome-do-repositorio
   ```

3. Execute o projeto com Maven:
   ```
   mvn spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8080`

## Endpoints

- POST /tarefas - Criar uma nova tarefa
- PUT /tarefas/{id} - Atualizar uma tarefa existente
- GET /tarefas - Listar todas as tarefas
- GET /tarefas/{id} - Obter uma tarefa específica
- DELETE /tarefas/{id} - Deletar uma tarefa

## Contribuindo

Contribuições são bem-vindas! Por favor, sinta-se à vontade para submeter um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).