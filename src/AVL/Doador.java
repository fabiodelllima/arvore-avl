package AVL;

public class Doador extends Registro {
    protected String bemDoado;

    public Doador(Registro registro, String bemDoado)
    {
        super(
                registro.registroDoNome,
                registro.registroDoNascimento,
                registro.registroDoEmail,
                registro.registroDoTelefone);
        this.bemDoado = bemDoado;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.println("BEM DOADO: " + bemDoado + "\n");
    }
}
