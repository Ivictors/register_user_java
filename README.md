# CRUD de Usuários - Java Puro + JDBC

Sistema de gerenciamento de usuários focado em fundamentos de Java, utilizando o padrão DAO (Data Access Object) e persistência direta via JDBC.

## 🏛️ Estrutura do Projeto
* **Model:** Classe `User` (POJO) com encapsulamento manual.
* **DAO:** Interface que define as operações permitidas.
* **Repository:** Implementação JDBC com SQL nativo.
* **Service:** Regras de negócio e intermediação.
* **Factory:** Gerenciamento manual de conexões MySQL.

## 🛠️ Requisitos
* **Java JDK 21**
* **MySQL Server**
* **Driver JDBC do MySQL** (Adicionado ao classpath/pom.xml)

## 🗄️ SQL do Banco de Dados
```sql
CREATE DATABASE IF NOT EXISTS user_management;
USE user_management;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    registration_date DATE NOT NULL
);