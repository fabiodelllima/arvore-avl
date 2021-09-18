package AVL;

public class Registro {
    protected String registroDoNome;
    protected String registroDoNascimento;
    protected String registroDoEmail;
    protected String registroDoTelefone;

    public Registro(String registroDoNome,
                    String registroDoNascimento,
                    String registroDoEmail,
                    String registroDoTelefone)
    {
        this.registroDoNome = registroDoNome;
        this.registroDoNascimento = registroDoNascimento;
        this.registroDoEmail = registroDoEmail;
        this.registroDoTelefone = registroDoTelefone;
    }

    public void imprimir()
    {
        System.out.println("\n====================\n RESULTADO DA BUSCA\n");
        System.out.println("NOME: " + registroDoNome);
        System.out.println("NASCIMENTO: " + registroDoNascimento);
        System.out.println("E-MAIL: " + registroDoEmail);
        System.out.println("TELEFONE: " + registroDoTelefone);
    }

    public String getRegistroDoNome() { return registroDoNome; }
    public void setRegistroDoNome(String registroDoNome) { this.registroDoNome = registroDoNome; }
    public String getRegistroDoNascimento() { return registroDoNascimento; }
    public void setRegistroDoNascimento(String registroDoNascimento) { this.registroDoNascimento = registroDoNascimento; }
    public String getRegistroDoEmail() { return registroDoEmail; }
    public void setRegistroDoEmail(String registroDoEmail) { this.registroDoEmail = registroDoEmail; }
    public String getRegistroDoTelefone() { return registroDoTelefone; }
    public void setRegistroDoTelefone(String registroDoTelefone) { this.registroDoTelefone = registroDoTelefone; }
}