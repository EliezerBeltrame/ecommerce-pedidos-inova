# Sistema de Gestão de Pedidos — E-commerce

> Projeto integrador da Unidade Curricular **Desenvolvimento Back-end**
> Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601

## Equipe / Squad

Squad: **Inova**

| Nome | Papel na Aula 01 |
|---|---|
| Eliezer Beltrame | Responsável do dia |
| Gabriel Lima | Integrante |

## Descrição do desafio

O desafio é desenvolver um sistema para gerenciar um e-commerce, permitindo o cadastro de produtos e clientes, a realização de pedidos e o processamento dos pagamentos.

## Funcionalidades previstas

- [x] Cadastro e gerenciamento de produtos (modelo de domínio)
- [x] Cadastro e gerenciamento de clientes (modelo de domínio)
- [x] Criação e gerenciamento de pedidos (modelo de domínio)
- [x] Processamento de pagamentos (cartão, boleto, Pix e dinheiro)
- [x] Testes automatizados unitários
- [ ] Testes automatizados de integração
- [ ] Persistência em banco de dados
- [ ] Pipeline de CI/CD
- [ ] API REST para consumo por um front-end
- [ ] Front-end em React (pasta `front/`)

## Divisão do trabalho

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
- JUnit 5 e JaCoCo (testes e cobertura)
- Git / GitHub
- _(a adicionar ao longo do semestre: Spring Boot, banco de dados, GitHub Actions, React no front-end)_

## Estrutura de pastas

```
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
├── docs/
├── README.md
└── .gitignore
```

## Como rodar o projeto

### Back-end

Pré-requisitos: Java e Maven instalados.

```
cd back
mvn test
```

Os testes unitários rodam com JUnit 5. O relatório de cobertura (JaCoCo) é gerado em `back/target/site/jacoco/index.html`.

## Roadmap do projeto (por aula)

| Aula | Entrega | Situação |
|---|---|---|
| 01 | Repositório criado, estruturado, com README e commit inicial | Concluída |
| 02 | Fluxo de branches e primeiro Pull Request revisado | Concluída |
| 03 | Classe utilitária (Utils) do domínio | Concluída |
| 04 | Classes de domínio inicial (Produto, Cliente, Pedido, ItemPedido) | Concluída |
| 05 | Encapsulamento e abstração aplicados | Concluída |
| 06 | Hierarquia de formas de pagamento (herança) | Concluída |
| 07 | Relacionamentos entre classes do domínio | Concluída |
| 08 | Módulo de pagamento polimórfico | Concluída |
| 09 | Tratamento de exceções | Concluída |
| 10 | Suíte de testes unitários | Concluída |
| 11 | Suíte de testes de integração + relatório de cobertura | Pendente |
| 12 | Persistência: conexão, Create e Read | Pendente |
| 13 | Persistência: Update, Delete e padrão DAO/Repository | Pendente |
| 14 | Migração para Spring Boot | Pendente |
| 15 | API REST + pipeline CI/CD | Pendente |
| 16 | Entrega final, documentação e apresentação | Pendente |

## Fluxo de trabalho

- Ninguém envia commit direto para a `main`: todo trabalho entra por Pull Request com 1 aprovação.
- Nome de branch: `feature/nome-curto`, `docs/nome-curto` ou `fix/nome-curto`.
- Mensagem de commit: `tipo: descrição no imperativo` (feat, fix, refactor, test, docs, chore).
- Depois do merge, a branch é apagada.

## Regras de negócio (constantes)

Definidas na classe `PedidoUtils`:

| Constante | Valor |
|---|---|
| Valor por quilo de frete | R$ 7,50 |
| Frete mínimo | R$ 15,00 |
| Taxa de desconto | 10% |
| Desconto máximo | R$ 50,00 |
| Frete grátis acima de | R$ 300,00 |

## Decisões de modelagem

- O `ItemPedido` guarda o preço do produto no momento da compra, porque o preço do catálogo pode mudar e o pedido antigo não pode mudar junto.
- O `Pedido` é dono dos seus itens (composição): ele cria os itens e protege a lista com `unmodifiableList`.
- Valores monetários do domínio usam `BigDecimal`.
- O pagamento é polimórfico: o `Pedido` conhece apenas a interface `ProcessadorPagamento`, e não as formas concretas.



## Dívida técnica

- A classe `PedidoUtils` usa `double` para valores monetários (como pede o roteiro da Aula 03), enquanto o domínio usa `BigDecimal`. Migrar para `BigDecimal` é uma melhoria futura.

## Combinado da equipe (ética e convivência)

1. Respeitar um ao outro
2. Dividir as tarefas de forma justa
3. Manter uma boa comunicação

## Licença

Projeto acadêmico — Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe".