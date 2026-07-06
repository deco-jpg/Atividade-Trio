import { useState } from 'react'
import { Routes, Route } from 'react-router-dom'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import CadastroClientePage from './pages/CadastroClientePage'
import CadastroFuncionarioPage from './pages/CadastroFuncionarioPage'
import ListaClientesPage from './pages/ListaClientesPage'
import ListaFuncionariosPage from './pages/ListaFuncionariosPage'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <>
        <Header />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/cadastro-cliente" element={<CadastroClientePage />} />
          <Route path="/cadastro-funcionario" element={<CadastroFuncionarioPage />} />
          <Route path="/clientes" element={<ListaClientesPage />} />
          <Route path="/funcionarios" element={<ListaFuncionariosPage />} />
        </Routes>
        <Footer />
       
      </>
      
    </>
  )
}

export default App
