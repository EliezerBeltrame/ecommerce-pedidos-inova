# Sistema de Gestão de Pedidos — E-commerce

> Projeto integrador da Unidade Curricular **Desenvolvimento Back-end** Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601

## Equipe / Squad

| Nome                 | Papel na Aula 01   |
| -------------------- | ------------------ |
| *(Eliezer Beltrame)* | Responsável do dia |
| *(Gabriel Lima)*     |                    |

## Descrição do desafio

*(O desafio é desenvolver um sistema para gerenciar um e-commerce, permitindo o cadastro de produtos e clientes, a realização de pedidos e o processamento dos pagamentos.)*

## Funcionalidades previstas

- ☑ Cadastro e gerenciamento de produtos
- ☑ Cadastro e gerenciamento de clientes
- ☑ Criação e gerenciamento de pedidos
- ☑ Processamento de pagamentos (cartão, boleto, Pix)
- ☑ Testes automatizados (unitários e de integração)
- ☐ Pipeline de CI/CD
- ☐ API REST para consumo por um front-end

### Funcionalidades do Front-end já desenvolvidas

- ☑ Catálogo de produtos
- ☑ Cadastro de produtos
- ☑ Edição de produtos
- ☑ Exclusão de produtos
- ☑ Cadastro de clientes
- ☑ Carrinho de compras
- ☑ Alteração da quantidade dos produtos
- ☑ Cálculo de subtotal e total
- ☑ Checkout
- ☑ Criação de pedidos
- ☑ Consulta de pedidos
- ☑ Navegação entre páginas com React Router
- ☑ Integração com JSON Server
- ☑ Layout responsivo com Bootstrap e CSS

## Divisão De Tarefas

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
- Vite
- JavaScript
- Bootstrap
- React Router
- JSON Server

## Estrutura de pastas

```text
ecommerce-pedidos-inova/
├── back/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/inova/ecommerce/
│   │   │           ├── excecao/
│   │   │           ├── modelo/
│   │   │           │   └── pagamento/
│   │   │           └── util/
│   │   └── test/
│   │       └── java/
│   │           └── com/inova/ecommerce/
│   └── pom.xml
├── front/
│   ├── src/
│   │   ├── components/
│   │   ├── context/
│   │   ├── pages/
│   │   └── services/
│   ├── db.json
│   └── package.json
├── docs/
├── README.md
└── .gitignore
```

## Como rodar o projeto

### Back-end

Pré-requisitos: Java e Maven instalados.

```bash
cd back
mvn test
```

O projeto possui uma suíte de testes automatizados para as classes do domínio.

### Front-end

Entre na pasta do front-end:

```bash
cd front
```

Instale as dependências:

```bash
npm install
```

Execute o projeto:

```bash
npm run dev
```

O front-end será executado pelo Vite.

## Decisões de modelagem

Durante o desenvolvimento foram aplicadas algumas decisões de modelagem:

- `Produto` possui informações de nome, descrição, preço e estoque.
- `Cliente` representa os dados do comprador.
- `Pedido` possui cliente e lista de itens.
- `ItemPedido` representa um produto dentro do pedido.
- As formas de pagamento utilizam herança e polimorfismo.
- Os valores monetários do domínio utilizam `BigDecimal`.
- O front-end utiliza um contexto para controlar o carrinho de compras.
- O acesso aos produtos foi separado em uma camada de serviços.
- O JSON Server é utilizado para simular o back-end do front-end durante o desenvolvimento.

## Combinado da equipe (ética e convivência)

- (Respeitar um ao outro)
- (Dividir as tarefas de forma justa)
- (Manter uma boa comunicação)

## Licença

Projeto acadêmico — Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe".