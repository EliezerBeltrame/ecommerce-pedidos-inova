import { useEffect, useState } from 'react';

function Clientes() {
  const [clientes, setClientes] = useState([]);

  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');

  const [mensagem, setMensagem] = useState('');

  async function carregarClientes() {
    const resposta = await fetch(
      'http://localhost:3000/clientes'
    );

    const dados = await resposta.json();

    setClientes(dados);
  }

  useEffect(() => {
    carregarClientes();
  }, []);

  async function cadastrarCliente(event) {
    event.preventDefault();

    if (!nome || !email) {
      setMensagem(
        'Preencha todos os campos.'
      );
      return;
    }

    const resposta = await fetch(
      'http://localhost:3000/clientes',
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          nome,
          email
        })
      }
    );

    if (resposta.ok) {
      const novoCliente =
        await resposta.json();

      setClientes([
        ...clientes,
        novoCliente
      ]);

      setNome('');
      setEmail('');

      setMensagem(
        'Cliente cadastrado com sucesso!'
      );
    }
  }

  return (
    <div className="container mt-4">
      <h1>Clientes</h1>

      {mensagem && (
        <div className="alert alert-info">
          {mensagem}
        </div>
      )}

      <form
        onSubmit={cadastrarCliente}
        className="mb-4"
      >
        <div className="mb-3">
          <label className="form-label">
            Nome
          </label>

          <input
            type="text"
            className="form-control"
            value={nome}
            onChange={(event) =>
              setNome(event.target.value)
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
            onChange={(event) =>
              setEmail(event.target.value)
            }
            required
          />
        </div>

        <button className="btn btn-primary">
          Cadastrar cliente
        </button>
      </form>

      <h2>Clientes cadastrados</h2>

      {clientes.length === 0 ? (
        <p>Nenhum cliente cadastrado.</p>
      ) : (
        clientes.map((cliente) => (
          <div
            className="card mb-2"
            key={cliente.id}
          >
            <div className="card-body">
              <strong>
                {cliente.nome}
              </strong>

              <p className="mb-0">
                {cliente.email}
              </p>
            </div>
          </div>
        ))
      )}
    </div>
  );
}

export default Clientes;