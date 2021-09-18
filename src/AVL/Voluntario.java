package AVL;

public class Voluntario extends Registro {
    protected String trabalho;

    public Voluntario(Registro registro, String trabalho)
    {
        super(
                registro.registroDoNome,
                registro.registroDoNascimento,
                registro.registroDoEmail,
                registro.registroDoTelefone);
        this.trabalho = trabalho;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.println("TRABALHO: " + trabalho + "\n");
    }
}
