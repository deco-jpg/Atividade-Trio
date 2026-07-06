import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
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
