import { Link } from 'react-router-dom';
import { useCarrinho } from '../context/CarrinhoContext';

function Carrinho() {
  const {
    carrinho,
    removerDoCarrinho,
    alterarQuantidade,
    calcularTotal
  } = useCarrinho();

  if (carrinho.length === 0) {
    return (
      <div className="container mt-4">
        <h1>Carrinho</h1>

        <p>
          Seu carrinho está vazio.
        </p>

        <Link
          to="/"
          className="btn btn-primary"
        >
          Ver produtos
        </Link>
      </div>
    );
  }

  return (
    <div className="container mt-4">
      <h1>Carrinho</h1>

      {carrinho.map((item) => (
        <div
          className="card mb-3"
          key={item.id}
        >
          <div className="card-body">
            <h5>{item.nome}</h5>

            <p>
              {item.descricao}
            </p>

            <p>
              Preço: R$ {item.preco.toFixed(2)}
            </p>

            <div className="d-flex align-items-center gap-2">
              <button
                className="btn btn-secondary"
                onClick={() =>
                  alterarQuantidade(
                    item.id,
                    item.quantidade - 1
                  )
                }
              >
                -
              </button>

              <span>
                {item.quantidade}
              </span>

              <button
                className="btn btn-secondary"
                onClick={() =>
                  alterarQuantidade(
                    item.id,
                    item.quantidade + 1
                  )
                }
              >
                +
              </button>

              <button
                className="btn btn-danger ms-3"
                onClick={() =>
                  removerDoCarrinho(item.id)
                }
              >
                Remover
              </button>
            </div>

            <p className="mt-3 fw-bold">
              Subtotal: R${' '}
              {(
                item.preco *
                item.quantidade
              ).toFixed(2)}
            </p>
          </div>
        </div>
      ))}

      <h3>
        Total: R$ {calcularTotal().toFixed(2)}
      </h3>

      <Link
        to="/checkout"
        className="btn btn-success mt-3"
      >
        Finalizar compra
      </Link>
    </div>
  );
}

export default Carrinho;