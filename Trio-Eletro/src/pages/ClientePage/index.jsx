import "./style.css";
import ClienteForm from "../../components/ClienteForm";
import ClienteList from "../../components/ClienteList";

export default function ClientePage() {
  return (
    <> {/* Mudado de <main> para Fragment para não duplicar com o App.jsx */}
      <h1>Clientes</h1>
      
      <ClienteForm />
      
      <ClienteList />
    </>
  );
}