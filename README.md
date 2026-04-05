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

Todos os Endpoints exigem autenticação para acesso.

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

# Configuração e Acesso à API

Os testes dos endpoints foram realizados utilizando o Postman, com persistência de dados em MySQL.

A aplicação conta com dois perfis de usuário pré-configurados para fins de autenticação e autorização:

admin → acesso com permissões de gerenciamento (ROLE_MANAGER)
user → acesso padrão (ROLE_USER)

Para consumir os endpoints, utilize autenticação Basic Auth no Postman com as seguintes credenciais:

Username: admin | user
Password: master123 | user123

---

# COMANDOS

- **AVISO** - todos os métodos que eu estarei utilizando precisam estar com essa opção ativada (Basic Auth), se não vai dar "Não autorizada"
---

- **ERRADO ❌**

<img width="764" height="549" alt="image" src="https://github.com/user-attachments/assets/41ce2382-5c92-4f24-ab5e-7047b1235d26" />

---

- **CERTO ✅**

<img width="776" height="953" alt="image" src="https://github.com/user-attachments/assets/c8dd2d7e-77cc-421d-978f-186f8b9ac967" />

---

- **POST(CRIAR USUÁRIO)** - para adicionar um novo usuário ao Banco de Dados
```
http://localhost:8080/users/method
```

<img width="773" height="671" alt="image" src="https://github.com/user-attachments/assets/a31bc347-7340-4090-a145-cdac9aeea575" />

---
- **GET(LISTAR USUÁRIOS)** - para listar usamos a mesma URL, é só mudar o método de "POST" para "GET" no Postman, que é a ferramenta onde testo os Endpoints.
```
http://localhost:8080/users/method
```

<img width="776" height="953" alt="image" src="https://github.com/user-attachments/assets/576a81c8-65fc-487e-8eaf-3648b132b948" />

---
- **PUT(ATUALIZAR USUÁRIO)** - para atualizar basta colocar o id depois da barra, mudar o método para "PUT" e na opção body mudar os dados.
```
http://localhost:8080/users/method/{id}
```

<img width="773" height="680" alt="image" src="https://github.com/user-attachments/assets/f8d53937-96d9-4a32-a32e-3be77e7bfb24" />


---
- **DELETE(DELETAR USUÁRIO)** - para deletar basta fazer o mesmo, porém não é para colocar nada no body (não retorna nada), e também mudar para o método "DELETE".
```
http://localhost:8080/users/method/{id}
```

<img width="774" height="641" alt="image" src="https://github.com/user-attachments/assets/c15a4fdb-26aa-4314-8ae3-f98fc8b4d8f4" />


---
- **GET(LISTAR POR ID)** - também adicionei a função de retornar o usuário pelo id.
```
http://localhost:8080/users/method/{id}
```

<img width="771" height="688" alt="image" src="https://github.com/user-attachments/assets/77cdea9f-1bce-4d7b-b0ba-7f52094cf85b" />

---

- **AUTHORIZED USER** - vai aparecer "Authorized user", serve para confirmar que o acesso está funcionando, as ROLES que tem acesso a essa URL são "USERS" e "MANAGERS".
```
http://localhost:8080/welcome
```

<img width="774" height="690" alt="image" src="https://github.com/user-attachments/assets/77c6931e-e019-4002-963f-d548597fab8c" />


---
- **AUTHORIZED MANAGER** - vai aparecer "Authorized manager", serve para confirmar que o acesso está funcionando, a ROLE que tem acesso a essa URL é apenas a "MANAGERS".
---
- **OBSERVAÇÃO** - precisa ter acesso a ROLE "Managers", caso contrário vai resultar em um erro
```
http://localhost:8080/welcome/managers
```
---
- **ERRO ❌** 
<img width="776" height="709" alt="image" src="https://github.com/user-attachments/assets/da5f3201-d7a6-4833-9195-fd553a33d5ca" />

---

- **SUCESSO ✅**
<img width="769" height="674" alt="image" src="https://github.com/user-attachments/assets/c33fbe08-561e-4ed4-a131-433cc49ccee1" />







