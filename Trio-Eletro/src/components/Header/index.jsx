import { Link } from "react-router-dom";
import "./style.css";

function Header() {
  return (
    <header>
      <h1>Sistema de Clientes</h1>

      <nav>
        {/* Link para a HomePage */}
        <Link to="/">Home</Link>

        {/* Link para a ClientePage */}
        <Link to="/cadastro-cliente">Clientes</Link>

        {/* Link para a FuncionarioPage */}
        <Link to="/cadastro-funcionario">Funcionários</Link>

        {/* Link para a ProdutoPage */}
        <Link to="/produtos">Produtos</Link>

        {/* Link para a ContatoPage */}
        <Link to="/contato">Contato</Link>

        {/* Link para a SobreNos */}
        <Link to="/sobre-nos">Sobre Nós</Link>
      </nav>
    </header>
  );
}

export default Header;