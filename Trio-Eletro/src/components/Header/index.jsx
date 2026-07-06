import { Link } from "react-router-dom";
import "./style.css";

function Header() {
  return (
    <header>
      <h1>Sistema de Clientes</h1>

      <nav>
        <Link to="/">Home</Link>

        <Link to="/cadastro">
          Cadastrar
        </Link>

        <Link to="/clientes">
          Listar Clientes
        </Link>
      </nav>
    </header>
  );
}

export default Header;