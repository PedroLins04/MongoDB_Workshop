# 🍃 MongoDB Workshop

Projeto de workshop que implementa um sistema de **rede social** com usuários, posts e comentários, desenvolvido com **Spring Boot** e **MongoDB**. O objetivo é explorar a integração entre uma API REST em Java e um banco de dados NoSQL orientado a documentos, utilizando queries personalizadas e os padrões nativos do Spring com MongoDB.

---

## Tecnologias

- **Java 25**
- **Spring Boot 4**
- **Spring Data MongoDB**
- **Spring Web MVC**
- **Maven**

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [JDK 25+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.9+](https://maven.apache.org/download.cgi) *(ou use o wrapper `./mvnw` incluso no projeto)*
- [MongoDB](https://www.mongodb.com/try/download/community) em execução local na porta padrão `27017`

---

## Configuração

No arquivo `src/main/resources/application.properties`, configure a conexão com o MongoDB:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=workshopMongo
```

---

## Como executar

Clone o repositório:

```bash
git clone https://github.com/PedroLins04/MongoDB_Workshop.git
cd MongoDB_Workshop
```

Execute com o Maven Wrapper:

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

---

## Estrutura do projeto

```
MongoDB_Workshop/
├── src/
│   ├── main/
│   │   ├── java/com/PedroLins/WorkshopMongo/
│   │   │   ├── config/         # Configurações e seed de dados
│   │   │   ├── domain/         # Entidades / documentos MongoDB
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── repository/     # Interfaces de acesso ao banco
│   │   │   ├── resources/      # Controllers REST
│   │   │   └── services/       # Regras de negócio
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── mvnw / mvnw.cmd
```

---

## Dependências principais

| Dependência | Finalidade |
|---|---|
| `spring-boot-starter-data-mongodb` | Integração com MongoDB via Spring Data |
| `spring-boot-starter-webmvc` | Criação de endpoints REST |

---

## Ferramentas de apoio

### MongoDB Compass

O [MongoDB Compass](https://www.mongodb.com/try/download/compass) é a interface gráfica oficial do MongoDB. Use-o para visualizar as coleções, documentos e índices criados pela aplicação em tempo real.

1. Instale o MongoDB Compass
2. Conecte usando a URI padrão:
   ```
   mongodb://localhost:27017
   ```
3. Acesse o banco `workshopMongo` e explore as coleções `users` e `posts`

---

### Postman

O [Postman](https://www.postman.com/downloads/) permite testar os endpoints da API de forma visual e organizada.

**Sugestão de configuração:**

- Crie uma **Collection** chamada `MongoDB Workshop`
- Defina uma variável de ambiente:
  ```
  base_url = http://localhost:8080
  ```

**Endpoints — Usuários (`/users`)**

| Método | Endpoint | Descrição | Status de retorno |
|---|---|---|---|
| `GET` | `{{base_url}}/users` | Lista todos os usuários | `200 OK` |
| `GET` | `{{base_url}}/users/{id}` | Busca usuário por ID | `200 OK` |
| `POST` | `{{base_url}}/users` | Cria novo usuário | `201 Created` |
| `PUT` | `{{base_url}}/users/{id}` | Atualiza usuário | `204 No Content` |
| `DELETE` | `{{base_url}}/users/{id}` | Remove usuário | `204 No Content` |
| `GET` | `{{base_url}}/users/{id}/posts` | Lista posts de um usuário | `200 OK` |

**Endpoints — Posts (`/posts`)**

| Método | Endpoint | Descrição | Status de retorno |
|---|---|---|---|
| `GET` | `{{base_url}}/posts/{id}` | Busca post por ID | `200 OK` |
| `GET` | `{{base_url}}/posts/titlesearch?text={texto}` | Busca posts pelo título (URL encoded) | `200 OK` |
| `GET` | `{{base_url}}/posts/fullsearch?text={texto}&minDate={yyyy-MM-dd}&maxDate={yyyy-MM-dd}` | Busca posts por texto e intervalo de datas | `200 OK` |

**Exemplo de body para `POST /users` e `PUT /users/{id}`:**

```json
{
  "name": "Maria Brown",
  "email": "maria@gmail.com"
}
```

**Exemplo de `fullsearch`:**
```
GET {{base_url}}/posts/fullsearch?text=viagem&minDate=2024-01-01&maxDate=2024-12-31
```

> **Dicas:**
> - Nas requisições `POST` e `PUT`, selecione `Body` → `raw` → `JSON` no Postman.
> - O parâmetro `text` é decodificado automaticamente via `URLDecoder` — espaços podem ser enviados como `%20` ou `+`.
> - `minDate` e `maxDate` são opcionais; se omitidos, o intervalo vai de `01/01/1970` até a data atual.

---

## 👤 Autor

**Pedro Lins**  
[github.com/PedroLins04](https://github.com/PedroLins04)
