package AVL;

class AVLTree {
    No root;

    int altura(No N)
    {
        if (N == null)
            return 0;

        return N.altura;
    }

    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    No direitoRotate(No y)
    {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    No esquerdoRotate(No x)
    {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    int recuperarBalanceamento(No no)
    {
        if (no == null)
            return 0;

        return altura(no.esquerdo) - altura(no.direito);
    }

    No insert(No no, String nome, Registro registro)
    {
        int balance;

        if (no == null)
            return (new No(nome, registro));

        if (nome.compareTo(no.nome) < 0)
        {
            no.esquerdo = insert(no.esquerdo, nome, registro);
        }
        else if (nome.compareTo(no.nome) > 0)
        {
            no.direito = insert(no.direito, nome, registro);
        }
        else
        {
            return no;
        }

        no.altura = 1 + max(altura(no.esquerdo), altura(no.direito));

        balance = recuperarBalanceamento(no);

        if (balance > 1 && nome.compareTo(no.esquerdo.nome) < 0)
            return direitoRotate(no);

        if (balance < -1 && nome.compareTo(no.direito.nome) > 0)
            return esquerdoRotate(no);

        if (balance > 1 && nome.compareTo(no.esquerdo.nome) > 0)
        {
            no.esquerdo = esquerdoRotate(no.esquerdo);
            return direitoRotate(no);
        }

        if (balance < -1 && nome.compareTo(no.direito.nome) < 0)
        {
            no.direito = direitoRotate(no.direito);
            return esquerdoRotate(no);
        }

        return no;
    }

    void imprimir(No no, String nome)
    {
        if (no != null)
        {
            imprimir(no.esquerdo, nome);

            if (no.nome.equalsIgnoreCase(nome))
                no.registro.imprimir();

            System.out.println(no.nome + " ");
            imprimir(no.direito, nome);
        }
    }
}