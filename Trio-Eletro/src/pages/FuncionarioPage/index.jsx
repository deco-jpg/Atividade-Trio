import './style.css'
import FuncionarioForm from "../../components/FuncionarioForm";
import FuncionarioList from "../../components/FuncionarioList";

export default function FuncionarioPage() {
  return (
    <main>
      <h1>Funcionários</h1>

      <FuncionarioForm />

      <FuncionarioList />
    </main>
  );
}