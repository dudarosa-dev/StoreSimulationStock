# 🛒 LojaSQL - Sistema de Gestão de Stock e Vendas em Java

Uma aplicação Java simples desenvolvida para demonstrar a ligação e manipulação de uma base de dados **MySQL** via **JDBC** (Java Database Connectivity). O projeto simula a gestão do inventário de uma loja, permitindo adicionar produtos, atualizar stock, registar vendas e listar artigos disponíveis.

---

## 📌 Funcionalidades

- **Conexão a MySQL:** Configuração centralizada da ligação via JDBC (`LigacaoBD`).
- **Adição de Produtos:** Inserção de novos itens (nome, preço e quantidade em stock).
- **Gestão de Stock (Reposicão):** Incremento da quantidade em stock de um determinado produto por ID.
- **Registo de Vendas:** Abate no stock existente (com validação de quantidade mínima para evitar stocks negativos).
- **Listagem de Inventário:** Consulta e exibição no consola de todos os produtos registados.

---

## Tecnologias Utilizadas

- **Linguagem:** Java (JDK 8 ou superior)
- **Base de Dados:** MySQL
- **Conectividade:** JDBC (`com.mysql.cj.jdbc.Driver`)
- **IDE Recomendada:** NetBeans / IntelliJ IDEA / Eclipse

---

## Estrutura da Base de Dados

Antes de executar a aplicação, certifica-te de ter o servidor **MySQL** a correr e cria a base de dados `loja` juntamente com a tabela `produtos`.

```sql
-- Criar a base de dados
CREATE DATABASE IF NOT EXISTS loja;
USE loja;

-- Criar a tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL,
    stock INT NOT NULL
);
```

---

## Como Configurar e Executar

### 1. Pré-requisitos
- Ter o **MySQL Server** (ex.: via XAMPP, WAMP ou instalação nativa) a correr na porta padrão `3306`.
- Ter o **MySQL Connector/J** (`mysql-connector-j-x.x.x.jar`) adicionado às dependências do projeto.

### 2. Configuração da Conexão
No ficheiro `LigacaoBD.java`, verifica/altera as tuas credenciais de acesso ao MySQL:

```java
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/loja",
    "root", // Utilizador
    ""      // Palavra-passe
);
```

### 3. Execução
Compila e executa a classe principal `LojaSQL.java`. O programa fará o seguinte fluxo de testes:
1. Adiciona 2 novos produtos (*Teclado* e *Rato*).
2. Exibe o inventário inicial.
3. Adiciona stock aos produtos (reposição).
4. Realiza uma venda do produto ID 1.
5. Exibe o estado final do stock na consola.

---

## Estrutura das Classes

| Classe | Descrição |
| :--- | :--- |
| **`LigacaoBD.java`** | Responsável por estabelecer a ligação com a base de dados MySQL. |
| **`Produtos.java`** | Classe modelo que contém as propriedades do produto e métodos CRUD / operações de stock. |
| **`LojaSQL.java`** | Classe principal com o método `main` para demonstrar o funcionamento das operações. |

---

## 📄 Licença

Este projeto serve como exemplo de demonstração académica/prática para aprendizagem de Java e MySQL.
