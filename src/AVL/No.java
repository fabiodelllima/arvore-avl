package AVL;

public class No {
    String nome;
    int altura;
    Registro registro;
    No esquerdo, direito;
    private No root;

    No(String nome, Registro registro)
    {
        this.registro = registro;
        this.nome = nome;
        altura = 1;
    }

    /*
    public No insert(No root, String registroDoNome, Registro registro) {

        this.root = root;
        nome = registroDoNome;
        this.registro = registro;
        return root;
    } */
}
