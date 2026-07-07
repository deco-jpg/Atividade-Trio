import { Route, Routes } from "react-router-dom";
import "./App.css";

// Importação de Componentes
import Footer from "./components/Footer";
import Header from "./components/Header";

// Importação das Páginas
import ClientePage from "./pages/ClientePage";
import ContatoPage from "./pages/ContatoPage";
import FuncionarioPage from "./pages/FuncionarioPage";
import HomePage from "./pages/HomePage";
import ProdutoPage from "./pages/ProdutoPage";
import SobreNos from "./pages/SobreNos";

function App() {

  return (
    <>
      <Header />
      
      <main>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/cadastro-cliente" element={<ClientePage />} />
          <Route path="/cadastro-funcionario" element={<FuncionarioPage />} />
          <Route path="/contato" element={<ContatoPage />} />
          <Route path="/produtos" element={<ProdutoPage />} />
          <Route path="/sobre-nos" element={<SobreNos />} />
        </Routes>
      </main>

      <Footer />
    </>
  );
}

export default App;