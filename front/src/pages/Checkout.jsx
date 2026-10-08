import { useState } from 'react';
import { useCarrinho } from '../context/CarrinhoContext';
import { Link } from 'react-router-dom';

function Checkout() {
  const {
    carrinho,
    calcularTotal,
    limparCarrinho
  } = useCarrinho();

  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [endereco, setEndereco] = useState('');
  const [mensagem, setMensagem] = useState('');
  const [pedidoRealizado, setPedidoRealizado] =
    useState(false);

  async function finalizarPedido(event) {
    event.preventDefault();

    if (carrinho.length === 0) {
      setMensagem(
        'O carrinho está vazio.'
      );
      return;
    }

    const pedido = {
      cliente: {
        nome,
        email
      },
      endereco,
      itens: carrinho,
      total: calcularTotal(),
      status: 'Recebido'
    };

    try {
      const resposta = await fetch(
        'http://localhost:3000/pedidos',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(pedido)
        }
      );

      if (!resposta.ok) {
        throw new Error();
      }

      setMensagem(
        'Pedido realizado com sucesso!'
      );

      setPedidoRealizado(true);

      limparCarrinho();
    } catch {
      setMensagem(
        'Erro ao realizar pedido.'
      );
    }
  }

  if (pedidoRealizado) {
    return (
      <div className="container mt-4">
        <div className="alert alert-success">
          Pedido realizado com sucesso!
        </div>

        <Link
          to="/pedidos"
          className="btn btn-primary"
        >
          Ver meus pedidos
        </Link>
      </div>
    );
  }

  return (
    <div className="container mt-4">
      <h1>Checkout</h1>

      <form onSubmit={finalizarPedido}>
        <div className="mb-3">
          <label className="form-label">
            Nome
          </label>

          <input
            type="text"
            className="form-control"
            value={nome}
            onChange={(e) =>
              setNome(e.target.value)
            }
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            E-mail
          </label>

          <input
            type="email"
            className="form-control"
            value={email}
            onChange={(e) =>
              setEmail(e.target.value)
            }
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            Endereço
          </label>

          <input
            type="text"
            className="form-control"
            value={endereco}
            onChange={(e) =>
              setEndereco(e.target.value)
            }
            required
          />
        </div>

        <h4>
          Total: R${' '}
          {calcularTotal().toFixed(2)}
        </h4>

        <button className="btn btn-success mt-3">
          Confirmar pedido
        </button>
      </form>

      {mensagem && (
        <div className="alert alert-info mt-3">
          {mensagem}
        </div>
      )}
    </div>
  );
}

export default Checkout;