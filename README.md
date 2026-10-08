# Sistema de Gestão de Pedidos — E-commerce

> Projeto integrador da Unidade Curricular **Desenvolvimento Back-end** Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601

## Equipe / Squad

Squad: **Inova**

| **Nome**         | **Papel na Aula 01** |
| ---------------- | -------------------- |
| Eliezer Beltrame | Responsável do dia   |
| Gabriel Lima     | Integrante           |

## Descrição do desafio

O desafio é desenvolver um sistema para gerenciar um e-commerce, permitindo o cadastro de produtos e clientes, a realização de pedidos e o processamento dos pagamentos.

## Funcionalidades previstas

- Cadastro e gerenciamento de produtos (modelo de domínio)
- Cadastro e gerenciamento de clientes (modelo de domínio)
- Criação e gerenciamento de pedidos (modelo de domínio)
- Processamento de pagamentos (cartão, boleto, Pix e dinheiro)
- Testes automatizados unitários
- Testes automatizados de integração
- Persistência em banco de dados
- Pipeline de CI/CD
- API REST para consumo por um front-end
- Front-end em React (pasta `front/`)

## Divisão do trabalho

- Cadastro e gerenciamento de produtos [Gabriel]
- Cadastro e gerenciamento de clientes [Eliezer]
- Criação e gerenciamento de pedidos [Eliezer]
- Processamento de pagamentos (cartão, boleto, Pix) [Gabriel]
- Testes automatizados (unitários e de integração) [Gabriel]
- Pipeline de CI/CD [Gabriel]
- API REST para consumo por um front-end [Eliezer]

## Tecnologias

### Back-end

- Java
- Maven
- JUnit 5
- JaCoCo
- Git / GitHub

### Front-end

- React
- JavaScript
- Vite
- Bootstrap
- React Router
- JSON Server

## Estrutura de pastas

```text
ecommerce-pedidos-inova/
├── back/
│   ├── src/
│   │   ├── main/java/com/inova/ecommerce/
│   │   │   ├── excecao/
│   │   │   ├── modelo/
│   │   │   │   └── pagamento/
│   │   │   └── util/
│   │   └── test/java/com/inova/ecommerce/
│   └── pom.xml
├── front/
│   ├── src/
│   │   ├── context/
│   │   ├── pages/
│   │   └── services/
│   ├── db.json
│   └── package.json
├── docs/
├── README.md
└── .gitignore