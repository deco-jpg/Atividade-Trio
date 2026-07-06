import './style.css'
import { useState } from 'react';
import { toast } from 'react-toastify';
import api from '../../services/api';

export default function ClienteForm() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [telefone, setTelefone] = useState('');
    const [cpf, setCpf] = useState('');
    const [estaEnviando, setEstaEnviando] = useState(false);    

    function limparCampos() {
        setNome('');
        setEmail('');
        setTelefone('');
        setCpf('');
    }
    
    function EnviarFormulario(event) {
        event.preventDefault();
        setEstaEnviando(true);
        const dadosFormulario = {
            nome: nome,
            email: email,
            telefone: telefone,
            cpf: cpf
        };

        try {   
            const response = await api.post('/clientes', dadosFormulario)
            toast.success(response.data.mensagem);
            limparCampos();
        } catch (error) {
            const mensagemDoServidor = error.response?.data?.mensagem;
            toast.error(mensagemDoServidor || 'Ocorreu um erro ao enviar o formulário. Por favor, tente novamente.');
        } finally {
            setEstaEnviando(false);
    }

    }
    return (
        <div className='cadastro-page'>
            <h1> Cadastro do cliente</h1>
            <form onSubmit={EnviarFormulario}>
                <div className='form-group'>
                    <label htmlFor='nome'>Nome:</label>
                    <input
                        type='text'
                        id='nome'
                        value={nome}
                        onChange={(e) => setNome(e.target.value)}
                        required
                    />
                </div>
                <div className='form-group'>
                    <label htmlFor='email'>Email:</label>
                    <input
                        type='email'
                        id='email'
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div className='form-group'>
                    <label htmlFor='telefone'>Telefone:</label>
                    <input
                        type='text'
                        id='telefone'
                        value={telefone}
                        onChange={(e) => setTelefone(e.target.value)}
                        required
                    />
                </div>
                <div className='form-group'>
                    <label htmlFor='cpf'>CPF:</label>
                    <input
                        type='text'
                        id='cpf'
                        value={cpf}
                        onChange={(e) => setCpf(e.target.value)}
                        required
                    />
                </div>
                <button type='submit' disabled={estaEnviando}>
                    {estaEnviando ? 'Enviando...' : 'Enviar'}
                </button>
            </form>




        </div>
    )
}      