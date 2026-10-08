import { useEffect, useState } from 'react';
import {
  buscarProdutos,
  cadastrarProduto,
  atualizarProduto,
  excluirProduto
} from '../services/api';

function GerenciarProdutos() {
  const [produtos, setProdutos] = useState([]);

  const [nome, setNome] = useState('');
  const [descricao, setDescricao] = useState('');
  const [preco, setPreco] = useState('');
  const [estoque, setEstoque] = useState('');

  const [produtoEditando, setProdutoEditando] =
    useState(null);

  const [mensagem, setMensagem] = useState('');

  async function carregarProdutos() {
    try {
      const dados = await buscarProdutos();
      setProdutos(dados);
    } catch {
      setMensagem('Erro ao carregar produtos.');
    }
  }

  useEffect(() => {
    carregarProdutos();
  }, []);

  function limparFormulario() {
    setNome('');
    setDescricao('');
    setPreco('');
    setEstoque('');
    setProdutoEditando(null);
  }

  async function salvarProduto(event) {
    event.preventDefault();

    const produto = {
      nome,
      descricao,
      preco: Number(preco),
      estoque: Number(estoque)
    };

    try {
      if (produtoEditando) {
        await atualizarProduto(
          produtoEditando.id,
          produto
        );

        setMensagem('Produto atualizado com sucesso!');
      } else {
        await cadastrarProduto(produto);

        setMensagem('Produto cadastrado com sucesso!');
      }

      limparFormulario();
      carregarProdutos();
    } catch {
      setMensagem('Erro ao salvar produto.');
    }
  }

  function editarProduto(produto) {
    setProdutoEditando(produto);

    setNome(produto.nome);
    setDescricao(produto.descricao);
    setPreco(produto.preco);
    setEstoque(produto.estoque);

    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  }

  async function removerProduto(id) {
    const confirmar = window.confirm(
      'Deseja realmente excluir este produto?'
    );

    if (!confirmar) {
      return;
    }

    try {
      await excluirProduto(id);

      setMensagem('Produto excluído com sucesso!');

      carregarProdutos();
    } catch {
      setMensagem('Erro ao excluir produto.');
    }
  }

  return (
    <div className="container mt-4">
      <h1>Gerenciar Produtos</h1>

      {mensagem && (
        <div className="alert alert-info">
          {mensagem}
        </div>
      )}

      <form
        onSubmit={salvarProduto}
        className="mb-5"
      >
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
            Descrição
          </label>

          <input
            type="text"
            className="form-control"
            value={descricao}
            onChange={(e) =>
              setDescricao(e.target.value)
            }
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            Preço
          </label>

          <input
            type="number"
            step="0.01"
            min="0"
            className="form-control"
            value={preco}
            onChange={(e) =>
              setPreco(e.target.value)
            }
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">
            Estoque
          </label>

          <input
            type="number"
            min="0"
            className="form-control"
            value={estoque}
            onChange={(e) =>
              setEstoque(e.target.value)
            }
            required
          />
        </div>

        <button className="btn btn-primary me-2">
          {produtoEditando
            ? 'Salvar alterações'
            : 'Cadastrar produto'}
        </button>

        {produtoEditando && (
          <button
            type="button"
            className="btn btn-secondary"
            onClick={limparFormulario}
          >
            Cancelar
          </button>
        )}
      </form>

      <h2>Produtos cadastrados</h2>

      {produtos.map((produto) => (
        <div
          className="card mb-3"
          key={produto.id}
        >
          <div className="card-body">
            <h5>{produto.nome}</h5>

            <p>{produto.descricao}</p>

            <p>
              Preço: R$ {produto.preco.toFixed(2)}
            </p>

            <p>
              Estoque: {produto.estoque}
            </p>

            <button
              className="btn btn-warning me-2"
              onClick={() =>
                editarProduto(produto)
              }
            >
              Editar
            </button>

            <button
              className="btn btn-danger"
              onClick={() =>
                removerProduto(produto.id)
              }
            >
              Excluir
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default GerenciarProdutos;