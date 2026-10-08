import { createContext, useContext, useState } from 'react';

const CarrinhoContext = createContext();

export function CarrinhoProvider({ children }) {
  const [carrinho, setCarrinho] = useState([]);

  function adicionarAoCarrinho(produto) {
    setCarrinho((itens) => {
      const existente = itens.find(
        (item) => item.id === produto.id
      );

      if (existente) {
        return itens.map((item) =>
          item.id === produto.id
            ? {
                ...item,
                quantidade: item.quantidade + 1
              }
            : item
        );
      }

      return [
        ...itens,
        {
          ...produto,
          quantidade: 1
        }
      ];
    });
  }

  function removerDoCarrinho(id) {
    setCarrinho((itens) =>
      itens.filter((item) => item.id !== id)
    );
  }

  function alterarQuantidade(id, quantidade) {
    if (quantidade < 1) {
      return;
    }

    setCarrinho((itens) =>
      itens.map((item) =>
        item.id === id
          ? {
              ...item,
              quantidade
            }
          : item
      )
    );
  }

  function limparCarrinho() {
    setCarrinho([]);
  }

  function calcularTotal() {
    return carrinho.reduce(
      (total, item) =>
        total + item.preco * item.quantidade,
      0
    );
  }

  return (
    <CarrinhoContext.Provider
      value={{
        carrinho,
        adicionarAoCarrinho,
        removerDoCarrinho,
        alterarQuantidade,
        limparCarrinho,
        calcularTotal
      }}
    >
      {children}
    </CarrinhoContext.Provider>
  );
}

export function useCarrinho() {
  return useContext(CarrinhoContext);
}