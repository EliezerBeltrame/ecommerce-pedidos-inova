import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  useLocation
} from 'react-router-dom';

import Produtos from './pages/Produtos';
import Clientes from './pages/Clientes';
import Carrinho from './pages/Carrinho';
import Checkout from './pages/Checkout';
import Pedidos from './pages/Pedidos';
import GerenciarProdutos from './pages/GerenciarProdutos';

function Menu() {
  const location = useLocation();

  return (
    <nav className="navbar navbar-expand-lg header-inova">
      <div className="container">

        <Link
          className="navbar-brand nome-inova"
          to="/"
        >
          INOV<span>A</span>
        </Link>

        <div className="menu-inova">

          <Link
            className={`link-menu ${
              location.pathname === '/' ? 'ativo' : ''
            }`}
            to="/"
          >
            Produtos
          </Link>

          <Link
            className={`link-menu ${
              location.pathname === '/clientes'
                ? 'ativo'
                : ''
            }`}
            to="/clientes"
          >
            Clientes
          </Link>

          <Link
            className={`link-menu ${
              location.pathname === '/carrinho'
                ? 'ativo'
                : ''
            }`}
            to="/carrinho"
          >
            Carrinho
          </Link>

          <Link
            className={`link-menu ${
              location.pathname === '/checkout'
                ? 'ativo'
                : ''
            }`}
            to="/checkout"
          >
            Checkout
          </Link>

          <Link
            className={`link-menu ${
              location.pathname === '/pedidos'
                ? 'ativo'
                : ''
            }`}
            to="/pedidos"
          >
            Pedidos
          </Link>

          <Link
            className={`link-menu ${
              location.pathname ===
              '/gerenciar-produtos'
                ? 'ativo'
                : ''
            }`}
            to="/gerenciar-produtos"
          >
            Gerenciar Produtos
          </Link>

        </div>
      </div>
    </nav>
  );
}

function App() {
  return (
    <BrowserRouter>

      <Menu />

      <Routes>

        <Route
          path="/"
          element={<Produtos />}
        />

        <Route
          path="/clientes"
          element={<Clientes />}
        />

        <Route
          path="/carrinho"
          element={<Carrinho />}
        />

        <Route
          path="/checkout"
          element={<Checkout />}
        />

        <Route
          path="/pedidos"
          element={<Pedidos />}
        />

        <Route
          path="/gerenciar-produtos"
          element={<GerenciarProdutos />}
        />

      </Routes>

    </BrowserRouter>
  );
}

export default App;