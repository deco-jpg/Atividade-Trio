import "./style.css";
import ClienteForm from "../../components/ClienteForm";
import ClienteList from "../../components/ClienteList";

export default function ClientePage() {
  return (
    <main>
      <h1>Clientes</h1>

      <ClienteForm />

      <ClienteList />
    </main>
  );
}