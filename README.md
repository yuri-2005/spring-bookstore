# 📚 Projeto: Cadastro de Livros

Este é um projeto de estudo feito com **Spring Boot 3**, **JPA/Hibernate** e banco de dados **H2 em memória**.

O sistema permite realizar operações CRUD (Create, Read, Update, Delete) sobre um cadastro de livros.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (banco em memória)
- Maven

---

## ✅ Funcionalidades

- **GET /livros** → Retorna todos os livros cadastrados  
- **GET /livros/{id}** → Retorna um livro por ID  
- **POST /livros** → Cadastra um novo livro  
- **PUT /livros/{id}** → Atualiza os dados de um livro  
- **DELETE /livros/{id}** → Deleta um livro  
- **GET /livros/searchByTitulo?titulo=** → Busca livros pelo título  
- **GET /livros/searchByAutor?autor=** → Busca livros pelo autor  

---

## 💾 Configuração do Banco H2

- **Console Web do H2:**  
Acesse em:  
http://localhost:8080/h2-console

- **Configuração para o login:**

| Campo | Valor |
| ---- | ---- |
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(em branco)* |

---

## 📂 Estrutura principal do projeto

- `/entities` → Entidade Livro  
- `/repositories` → Interface Repository usando Spring Data JPA  
- `/services` → Lógica de negócio  
- `/controllers` → Endpoints REST  

---

## 🎯 Objetivo

Projeto feito com fins de aprendizado para praticar conceitos básicos de:

- Spring Boot
- JPA/Hibernate
- API REST
- Padrão Camadas (Controller, Service, Repository)
- Configuração de banco H2

---

