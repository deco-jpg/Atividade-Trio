import { use } from 'react'
import './style.css'

export default function ClienteList() {
    const [clientes, setClientes] = useState([])

    useEffect(() => {
        async function buscarClientes() {
            try {
                const reposta = await api.get('/clientes')
                setClientes(reposta.data)
            } catch (error) {
                toast.error('Erro ao buscar clientes')
            }
        }
        buscarClientes()



    }, [])

    return (
        <div className='lista-page'>
            <h1>Listar Clientes</h1>
            {clientes.length === 0 ? (
                <p className='lista-vazia'>Não há clientes cadastrados.</p>
            ) : (
                <table className='lista-tabela'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>Telefone</th>
                        </tr>
                    </thead>
                    <tbody>
                        {clientes.map(cliente => (
                            <tr key={cliente.id}>
                                <td>{cliente.id}</td>
                                <td>{cliente.nome}</td>
                                <td>{cliente.email}</td>
                                <td>{cliente.telefone}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>


    )

}



