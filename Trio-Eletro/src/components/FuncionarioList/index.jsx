import './style.css'
import { use } from 'react'
import './style.css'

export default function FuncionarioList() {
    const [funcionarios, setFuncionarios] = useState([])

    useEffect(() => {
        async function buscarFuncionarios() {
            try {
                const reposta = await api.get('/funcionarios')
                setFuncionarios(reposta.data)
            } catch (error) {
                toast.error('Erro ao buscar funcionários')
            }
        }
        buscarFuncionarios()



    }, [])

    return (
        <div className='lista-page'>
            <h1>Listar Funcionários</h1>
            {funcionarios.length === 0 ? (
                <p className='lista-vazia'>Não há funcionários cadastrados.</p>
            ) : (
                <table className='lista-tabela'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>Telefone</th>
                            <th>Setor</th>
                        </tr>
                    </thead>
                    <tbody>
                        {funcionarios.map(funcionario => (
                            <tr key={funcionario.id}>
                                <td>{funcionario.id}</td>
                                <td>{funcionario.nome}</td>
                                <td>{funcionario.email}</td>
                                <td>{funcionario.telefone}</td>
                                <td>{funcionario.setor}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>


    )

}



