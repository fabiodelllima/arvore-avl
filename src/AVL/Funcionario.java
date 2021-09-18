package AVL;

public class Funcionario extends Registro {
    protected String cargo;

    public Funcionario(Registro registro, String cargo)
    {
        super(
                registro.registroDoNome,
                registro.registroDoNascimento,
                registro.registroDoEmail,
                registro.registroDoTelefone);
        this.cargo = cargo;
    }

    @Override
    public void imprimir()
    {
        super.imprimir();
        System.out.println("CARGO: "  + cargo + "\n");
    }
}