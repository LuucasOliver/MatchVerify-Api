# API de Gerenciamento de Encomendas

Esta é uma API REST desenvolvida com Spring Boot e Java 21 para gerenciar encomendas, suas entradas e saídas.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL (Supabase)
- Maven

## Configuração

A API está configurada para se conectar ao banco de dados PostgreSQL no Supabase. As configurações de conexão estão no arquivo `application.properties`.

## Endpoints

### Encomendas

- **GET /api/encomendas**: Retorna todas as encomendas
- **GET /api/encomendas/{id}**: Retorna uma encomenda específica pelo ID
- **POST /api/encomendas**: Cria uma nova encomenda
- **PUT /api/encomendas/{id}**: Atualiza uma encomenda existente
- **DELETE /api/encomendas/{id}**: Remove uma encomenda

### Entradas de Encomendas

- **GET /api/entradas**: Retorna todas as entradas de encomendas
- **GET /api/entradas/{id}**: Retorna uma entrada específica pelo ID
- **POST /api/entradas**: Registra uma nova entrada de encomenda
- **PUT /api/entradas/{id}**: Atualiza uma entrada existente
- **DELETE /api/entradas/{id}**: Remove uma entrada

### Saídas de Encomendas

- **GET /api/saidas**: Retorna todas as saídas de encomendas
- **GET /api/saidas/{id}**: Retorna uma saída específica pelo ID
- **POST /api/saidas**: Registra uma nova saída de encomenda
- **PUT /api/saidas/{id}**: Atualiza uma saída existente
- **DELETE /api/saidas/{id}**: Remove uma saída

## Estrutura do Projeto

- `model`: Contém as entidades do banco de dados
- `repository`: Contém os repositórios para acesso ao banco de dados
- `service`: Contém a lógica de negócio
- `controller`: Contém os controladores REST

## Como Executar

Para executar a aplicação, utilize um dos comandos abaixo:

```bash
mvn spring-boot:run
```

ou

```bash
java -jar target/encomendas-api-0.0.1-SNAPSHOT.jar
```

A API estará disponível na porta 8080. 