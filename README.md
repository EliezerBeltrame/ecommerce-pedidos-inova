# Sistema de Gestão de Pedidos — E-commerce

> Projeto integrador da Unidade Curricular **Desenvolvimento Back-end**
> Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601

## Equipe / Squad

| Nome | Papel na Aula 01 |
|---|---|
| Eliezer Beltrame | Responsável do dia |
| Gabriel Lima | |

## Descrição do desafio

O projeto consiste no desenvolvimento de um sistema de gestão de pedidos para um e-commerce.

Ao longo das aulas, o sistema está sendo desenvolvido de forma incremental, começando pela criação das classes de domínio e evoluindo para relacionamentos entre classes, herança, encapsulamento e processamento polimórfico de pagamentos.

## Funcionalidades

- [x] Cadastro e gerenciamento de produtos
- [x] Cadastro e gerenciamento de clientes
- [x] Criação e gerenciamento de pedidos
- [x] Relacionamento entre Pedido, Cliente, Produto e ItemPedido
- [x] Hierarquia de formas de pagamento
- [x] Processamento polimórfico de pagamentos
- [x] Pagamento via Pix
- [x] Pagamento via cartão de crédito
- [x] Pagamento via boleto
- [x] Pagamento em dinheiro
- [ ] Tratamento de exceções
- [ ] Testes automatizados (unitários e de integração)
- [ ] Pipeline de CI/CD
- [ ] API REST para consumo por um front-end

## Divisão de Tarefas

- Cadastro e gerenciamento de produtos [Gabriel]
- Cadastro e gerenciamento de clientes [Eliezer]
- Criação e gerenciamento de pedidos [Eliezer]
- Processamento de pagamentos (cartão, boleto, Pix) [Gabriel]
- Testes automatizados (unitários e de integração) [Gabriel]
- Pipeline de CI/CD [Gabriel]
- API REST para consumo por um front-end [Eliezer]

## Tecnologias

- Java
- Maven
- Git
- GitHub
- Programação Orientada a Objetos
- BigDecimal
- JUnit
- Spring Boot
- Banco de dados
- GitHub Actions

> Algumas tecnologias serão utilizadas nas próximas etapas do projeto.

## Estrutura de pastas

```text
ecommerce-pedidos-inova/
├── back/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── inova/
│   │   │               └── ecommerce/
│   │   │                   ├── App.java
│   │   │                   ├── AppConfig.java
│   │   │                   ├── CalcEndpoint.java
│   │   │                   └── modelo/
│   │   │                       ├── Cliente.java
│   │   │                       ├── Funcionario.java
│   │   │                       ├── ItemPedido.java
│   │   │                       ├── Pedido.java
│   │   │                       ├── Pessoa.java
│   │   │                       ├── Produto.java
│   │   │                       ├── SituacaoDoPedido.java
│   │   │                       └── pagamento/
│   │   │                           ├── Boleto.java
│   │   │                           ├── CartaoCredito.java
│   │   │                           ├── Dinheiro.java
│   │   │                           ├── FormaPagamento.java
│   │   │                           ├── Pix.java
│   │   │                           └── ProcessadorPagamento.java
│   │   └── test/
│   │       └── java/
│   ├── pom.xml
│   └── README.md
└── .gitignore
