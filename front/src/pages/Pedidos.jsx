import { useEffect, useState } from 'react';

function Pedidos() {
  const [pedidos, setPedidos] = useState([]);
  const [carregando, setCarregando] =
    useState(true);

  useEffect(() => {
    fetch('http://localhost:3000/pedidos')
      .then((resposta) =>
        resposta.json()
      )
      .then((dados) => {
        setPedidos(dados);
      })
      .finally(() => {
        setCarregando(false);
      });
  }, []);

  if (carregando) {
    return (
      <div className="container mt-4">
        <p>Carregando pedidos...</p>
      </div>
    );
  }

  return (
    <div className="container mt-4">
      <h1>Pedidos</h1>

      {pedidos.length === 0 ? (
        <p>
          Nenhum pedido realizado.
        </p>
      ) : (
        pedidos.map((pedido) => (
          <div
            className="card mb-3"
            key={pedido.id}
          >
            <div className="card-body">
              <h5>
                Pedido #{pedido.id}
              </h5>

              <p>
                Cliente:{' '}
                {pedido.cliente.nome}
              </p>

              <p>
                E-mail:{' '}
                {pedido.cliente.email}
              </p>

              <p>
                Endereço:{' '}
                {pedido.endereco}
              </p>

              <p>
                Status:{' '}
                <strong>
                  {pedido.status}
                </strong>
              </p>

              <p className="fw-bold">
                Total: R${' '}
                {pedido.total.toFixed(2)}
              </p>

              <h6>Itens:</h6>

              {pedido.itens.map((item) => (
                <p
                  key={item.id}
                  className="mb-1"
                >
                  {item.nome} -{' '}
                  {item.quantidade}x
                </p>
              ))}
            </div>
          </div>
        ))
      )}
    </div>
  );
}

export default Pedidos;