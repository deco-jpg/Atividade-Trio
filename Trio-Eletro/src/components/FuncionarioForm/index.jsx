import { useState } from 'react'
import { toast } from 'react-toastify'
import api from '../../services/api'
import '../FuncionarioForm/style.css'

export default function CadastroFuncionarioPage() {
    const [nome, setNome] = useState('')
    const [cpf, setCpf] = useState('')
    const [email, setEmail] = useState('')
    const [telefone, setTelefone] = useState('')
    const [setor, setSetor] = useState('')
    const [salario, setSalario] = useState('')
    const [estaEnviando, setEstaEnviando] = useState(false)

    function limparCamposDoFormulario() {
        setNome('')
        setCpf('')
        setEmail('')
        setTelefone('')
        setSetor('')
        setSalario('')
    }

    async function enviarFormulario(event) {
        event.preventDefault()
        setEstaEnviando(true)

        const dadosFormulario = { nome, cpf, email, telefone, setor, salario }

        try {
            const resposta = await api.post('/funcionarios', dadosFormulario)
            toast.success(resposta.data.mensagem)
            limparCamposDoFormulario()
        } catch (error) {
            const mensagemDoServidor = error.response?.data?.mensagem
            toast.error(mensagemDoServidor || 'Erro ao cadastrar funcionário.')
        } finally {
            setEstaEnviando(false)
        }
    }

    return (
        <div className="cadastro-page">
            <h1>Cadastro de Funcionário</h1>
            <form onSubmit={enviarFormulario} className="cadastro-form">
                <div className="grupo-form">
                    <label htmlFor="campo-nome">Nome:</label>
                    <input
                        type="text"
                        id="campo-nome"
                        value={nome}
                        onChange={(e) => setNome(e.target.value)}
                        placeholder="Ex: João Santos"
                    />
                </div>
                <div className="grupo-form">
                    <label htmlFor="campo-cpf">CPF:</label>
                    <input
                        type="text"
                        id="campo-cpf"
                        value={cpf}
                        onChange={(e) => setCpf(e.target.value)}
                        placeholder="Ex: 123.456.789-00"
                    />
                </div>
                <div className="grupo-form">
                    <label htmlFor="campo-email">E-mail:</label>
                    <input
                        type="email"
                        id="campo-email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Ex: joao@empresa.com"
                    />
                </div>
                <div className="grupo-form">
                    <label htmlFor="campo-cargo">Telefone</label>
                    <input
                        type="text"
                        id="campo-telefone"
                        value={telefone}
                        onChange={(e) => setTelefone(e.target.value)}
                        placeholder="Ex: (11) 98888-7777"
                    />
                </div>
                <div className="grupo-form">
                    <label htmlFor="campo-setor">Setor:</label>
                    <input
                        type="text"
                        id="campo-setor"
                        value={setor}
                        onChange={(e) => setSetor(e.target.value)}
                        placeholder="Ex: Tecnologia da Informação"
                    />
                </div>
                <div className="grupo-form">
                    <label htmlFor="campo-salario">Salário:</label>
                    <input
                        type="text"
                        id="campo-salario"
                        value={salario}
                        onChange={(e) => setSalario(e.target.value)}
                        placeholder="Ex: 5000.00"
                    />
                </div>

                <button type="submit" disabled={estaEnviando}>
                    {estaEnviando ? 'Cadastrando...' : 'Cadastrar'}
                </button>
            </form>
        </div>
    )
}