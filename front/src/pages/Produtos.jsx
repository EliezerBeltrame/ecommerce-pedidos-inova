import { useEffect, useState } from 'react';
import { buscarProdutos } from '../services/api';
import { useCarrinho } from '../context/CarrinhoContext';

function Produtos() {
  const [produtos, setProdutos] = useState([]);
  const [carregando, setCarregando] = useState(true);
  const [erro, setErro] = useState('');

  const { adicionarAoCarrinho } = useCarrinho();

  useEffect(() => {
    buscarProdutos()
      .then((dados) => {
        setProdutos(dados);
      })
      .catch(() => {
        setErro(
          'Não foi possível carregar os produtos.'
        );
      })
      .finally(() => {
        setCarregando(false);
      });
  }, []);

  if (carregando) {
    return (
      <div className="container mt-5">
        <p>Carregando produtos...</p>
      </div>
    );
  }

  if (erro) {
    return (
      <div className="container mt-5">
        <div className="alert alert-danger">
          {erro}
        </div>
      </div>
    );
  }

  return (
    <div className="container mt-5">

      <div className="mb-4">
        <small className="titulo-destaque">
          DESTAQUES
        </small>

        <h1 className="titulo-produtos">
          Produtos em{' '}
          <span>destaque</span>
        </h1>

        <p className="texto-produtos">
          Confira alguns dos nossos produtos.
        </p>
      </div>

      <div className="row">

        {produtos.map((produto) => (
          <div
            className="col-md-4 mb-4"
            key={produto.id}
          >
            <div className="produto-card">

              <h5>
                {produto.nome}
              </h5>

              <p className="produto-descricao">
                {produto.descricao}
              </p>

              <p className="produto-preco">
                R$ {produto.preco.toFixed(2)}
              </p>

              <p className="produto-estoque">
                ● Estoque: {produto.estoque}
              </p>

              <button
                type="button"
                className="btn-inova"
                onClick={() =>
                  adicionarAoCarrinho(produto)
                }
                disabled={produto.estoque <= 0}
              >
                {produto.estoque > 0
                  ? 'Adicionar ao carrinho'
                  : 'Sem estoque'}
              </button>

            </div>
          </div>
        ))}

      </div>
    </div>
  );
}

export default Produtos;