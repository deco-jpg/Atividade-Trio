import { Routes, Route } from "react-router-dom";
import { useState } from "react";
import "./App.css";

// Importação de Componentes
import Header from "./components/Header"; 
import Footer from "./components/Footer";

// Importação das Páginas
import HomePage from "./pages/HomePage";
import ClientePage from "./pages/ClientePage";
import FuncionarioPage from "./pages/FuncionarioPage";
import ContatoPage from "./pages/ContatoPage";
import ProdutoPage from "./pages/ProdutoPage";
import SobreNos from "./pages/SobreNos";

function App() {
  const [count, setCount] = useState(0);

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