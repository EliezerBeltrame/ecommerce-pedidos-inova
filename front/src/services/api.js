const API_URL = 'http://localhost:3000';

export async function buscarProdutos() {
  const resposta = await fetch(`${API_URL}/produtos`);

  if (!resposta.ok) {
    throw new Error('Erro ao buscar produtos');
  }

  return resposta.json();
}

export async function cadastrarProduto(produto) {
  const resposta = await fetch(`${API_URL}/produtos`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(produto)
  });

  if (!resposta.ok) {
    throw new Error('Erro ao cadastrar produto');
  }

  return resposta.json();
}

export async function atualizarProduto(id, produto) {
  const resposta = await fetch(`${API_URL}/produtos/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(produto)
  });

  if (!resposta.ok) {
    throw new Error('Erro ao atualizar produto');
  }

  return resposta.json();
}

export async function excluirProduto(id) {
  const resposta = await fetch(`${API_URL}/produtos/${id}`, {
    method: 'DELETE'
  });

  if (!resposta.ok) {
    throw new Error('Erro ao excluir produto');
  }
}