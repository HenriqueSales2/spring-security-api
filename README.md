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
- Java 17 ou superior  
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

Testando os Endpoints

Você pode testar os endpoints utilizando ferramentas como:

- Postman
- Insomnia
- curl

Dependendo da configuração de segurança, alguns endpoints podem exigir autenticação para acesso.

# Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Maven

# Objetivo do Projeto

- Este projeto foi desenvolvido com o objetivo de praticar:
- Configuração de segurança em APIs
- Autenticação e autorização
- Estruturação de projetos com Spring Boot
- Boas práticas no desenvolvimento de APIs REST
