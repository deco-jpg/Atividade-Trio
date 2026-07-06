import { Routes, Route } from "react-router-dom";
import "./App.css";

// Importação de Componentes
import Header from "./components/Header"; // Ajustado para importar de Header e não Footer duplicado
import Footer from "./components/Footer";

// Importação das Páginas (Nomes corrigidos de acordo com a sua pasta 'pages')
import HomePage from "./pages/HomePage";
import ClientePage from "./pages/ClientePage";
import FuncionarioPage from "./pages/FuncionarioPage";
import ContatoPage from "./pages/ContatoPage";
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