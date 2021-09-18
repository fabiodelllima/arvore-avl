package AVL;

public class Visitante extends Registro {
    protected String dataDaVisita;

    public Visitante(Registro registro, String dataDaVisita) {
        super(
                registro.registroDoNome,
                registro.registroDoNascimento,
                registro.registroDoEmail,
                registro.registroDoTelefone);
        this.dataDaVisita = dataDaVisita;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("DATA DE VISITA: " + dataDaVisita + "\n");
    }
}
