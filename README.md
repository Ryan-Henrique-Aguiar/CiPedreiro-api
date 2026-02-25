# 🧱 CiPedreiro API

API REST desenvolvida com **Spring Boot** para gerenciamento de serviços de construção civil, auxiliando no controle financeiro, organização de serviços e geração de relatórios fiscais.

---

## 📌 Sobre o Projeto

A **CiPedreiro API** foi criada para auxiliar na gestão dos serviços de um pedreiro autônomo, permitindo:

- Cadastro de clientes  
- Cadastro de serviços prestados  
- Controle de valores e pagamentos  
- Gestão de ajudantes  
- Cálculo automático de custos  
- Base para geração futura de nota fiscal  
- Preparação de relatórios para declaração de imposto de renda  

Projeto desenvolvido como aplicação real para uso familiar e evolução profissional.

---

## 🚀 Tecnologias Utilizadas

- ☕ Java 21  
- 🌱 Spring Boot  
- 🔐 Spring Security  
- 🔑 JWT (JSON Web Token)  
- 🗄 Spring Data JPA  
- 🐘 PostgreSQL  
- 📦 Maven  
- 🧪 Testes de API via Insomnia  

---

## 🔐 Autenticação

A API utiliza autenticação baseada em **JWT (JSON Web Token)**.

### Fluxo de autenticação:

1. Usuário realiza login  
2. Recebe um token JWT  
3. Envia o token no header das requisições protegidas:

```http
Authorization: Bearer seu_token_aqui
```

---

## 📂 Estrutura do Projeto

```plaintext
src/main/java/com/cipedreiros/api
│
├── controller
│   └── Responsável pelos endpoints REST e entrada das requisições HTTP
│
├── application
│   └── Camada de regras de negócio (Services e orquestração)
│
├── domain
│   └── Entidades e modelos de domínio do sistema
│
├── repository
│   └── Interfaces de acesso ao banco de dados (Spring Data JPA)
│
├── exception
│   ├── Exceptions customizadas
│   └── GlobalExceptionHandler para tratamento global de erros
│
├── config.security
│   └── Configurações do Spring Security, filtros JWT e autenticação
│
└── infra
    └── Camada destinada a integrações externas (implementações futuras)
