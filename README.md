# Spring Security API

Projeto de estudo utilizando **Spring Boot** e **Spring Security** para implementar autenticação e proteção de endpoints em uma API REST.

A aplicação demonstra conceitos básicos de segurança em APIs, como controle de acesso, autenticação e proteção de rotas.

---

# Sumário

- Pré-requisitos  
- Instalação das dependências  
- Estrutura do Projeto  
- Executando o Projeto  
- Testando os Endpoints  

---

# Pré-requisitos

Para executar o projeto é necessário ter instalado na sua máquina:

- Git  
- Java 17 ou Superior
- Maven  
- Uma IDE Java (IntelliJ, Eclipse ou VS Code)

---

# Instalação das dependências

Primeiro clone o repositório:

```
git clone https://github.com/HenriqueSales2/spring-security-api.git
```

Depois entre na pasta do projeto:

```
cd spring-security-api
```

Como o projeto utiliza Maven, basta instalar as dependências com:

```
mvn clean install
```

---

# Estrutura do Projeto

A estrutura principal do projeto segue o padrão de aplicações Spring Boot:

```
spring-security-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...               # Controllers, Services e configurações de segurança
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
│   └── test/                     # Testes da aplicação
│
├── pom.xml                       # Dependências do projeto
├── mvnw                          # Maven Wrapper
├── mvnw.cmd
└── README.md
```

---

# Executando o Projeto

Para iniciar a aplicação utilize o comando:

```
mvn spring-boot:run
```

Ou execute a classe principal da aplicação diretamente pela sua IDE.

Após iniciar, a API estará disponível por padrão na URL:

```
http://localhost:8080
```

# Testando os Endpoints

Você pode testar os endpoints utilizando ferramentas como:

- Postman
- Insomnia
- curl
- H2 Console

Dependendo da configuração de segurança, alguns endpoints podem exigir autenticação para acesso.

---

# Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Maven

--- 

# Objetivo do Projeto

- Este projeto foi desenvolvido com o objetivo de praticar:
- Configuração de segurança em APIs
- Autenticação e autorização
- Estruturação de projetos com Spring Boot
- Boas práticas no desenvolvimento de APIs REST

---  

# IMPORTANTE

 Nesse projeto foi usado o Postman para testes de Endpoints e o H2 Database para armazenar os dados em cache.
 Existem dois usuários padrões que coloquei no projeto, sendo eles o admin com permissões e acesso a ROLES de MANAGERS,
 e o outro com o nome de user com permissões e acesso a ROLE de USERS.
 Para Fazer todos os comandos é necessário no seu Postman, (ferramenta que usei) na aba Authorization
 selecionar a opção Basic Auth e enfim colocar os campos que irei fornecer abaixo.

 - **Username: admin ou user**
 - **Password: master123 ou user123**

---

# COMANDOS

- **POST(CRIAR USUÁRIO)** - para adicionar um novo usuário ao Banco de Dados em cache
```
http://localhost:8080/users/method
```
---
- **GET(LISTAR USUÁRIOS)** - para listar usamos a mesma URL, é só mudar o método de "POST" para "GET" no Postman, que é a ferramenta onde testo os Endpoints.
```
http://localhost:8080/users/method
```
---
- **PUT(ATUALIZAR USUÁRIO)** - para atualizar basta colocar o id depois da barra, mudar o método para "PUT" e na opção body mudar os dados.
```
http://localhost:8080/users/method/{id}
```
---
- **DELETE(DELETAR USUÁRIO)** - para deletar basta fazer o mesmo, porém não é para colocar nada no body, e também mudar para o método "DELETE".
```
http://localhost:8080/users/method/{id}
```
---
- **GET(LISTAR POR ID)** - também adicionei a função de retornar o usuário pelo id.
```
http://localhost:8080/users/method/{id}
```
---
- **AUTHORIZED MANAGER** - vai aparecer "Authorized manager", serve para confirmar que o acesso está funcionando, a ROLE que tem acesso a essa URL é apenas a "MANAGERS".
```
http://localhost:8080/managers
```
---
- **AUTHORIZED USER** - vai aparecer "Authorized user", serve para confirmar que o acesso está funcionando, as ROLES que tem acesso a essa URL são "USERS" e "MANAGERS".
```
http://localhost:8080/users
```
