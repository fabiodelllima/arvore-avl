package AVL;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean iniciarSistema;
    private static int numeroDeRegistros = 0;
    private static final int CADASTRO = 1;
    private static final int BUSCA = 2;
    private static final int ATENDIMENTO = 3;
    private static final int SAIR = 4;
    private static final ArrayList<Registro> registros = new ArrayList<Registro>();
    private static final AVLTree arvoreAVL = new AVLTree();

    public static void setIniciarSistema(boolean iniciarSistema) { Main.iniciarSistema = iniciarSistema; }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        setIniciarSistema(true);
        while (iniciarSistema)
        {
            iniciarMenu(teclado);
        }
        teclado.close();
    }

    //

    protected static void iniciarMenu(Scanner teclado)
    {
        int opcaoDoMenuSelecionada;

        System.out.println("\n===================\n" + " ESCOLHA UMA OPÇÃO\n");
        System.out.println("1) Cadastro");
        System.out.println("2) Busca");
        System.out.println("3) Atendimento");
        System.out.println("4) Sair");
        System.out.print("\nInforme sua opção: ");
        opcaoDoMenuSelecionada = Integer.parseInt(teclado.nextLine());

        switch (opcaoDoMenuSelecionada)
        {
            case CADASTRO:
                Data.informarData(teclado);
                Registro registro = adicionarAoRegistro(teclado);
                categorizarRegistro(teclado, registro.registroDoNome, registro);
                break;
            case BUSCA:
                buscarInformacoesSobreRegistro(teclado);
                break;
            case ATENDIMENTO:
                imprimirListaDeAtendimento();
                break;
            case SAIR:
                System.out.println("\n=> DESLIGANDO SISTEMA");
                setIniciarSistema(false);
                teclado.close();
                break;
            default:
                System.out.println("=> OPÇÃO INVÁLIDA");
                break;
        }
    }

    protected static Registro adicionarAoRegistro(Scanner teclado)
    {
        System.out.println("\n===================\n" + " CADASTRO DE DADOS\n");
        System.out.print("Nome completo: ");
        String registroDoNome = (teclado.nextLine());
        System.out.print("Data de nascimento: ");
        String registroDoNascimento = (teclado.nextLine());
        System.out.print("E-mail: ");
        String registroDoEmail = (teclado.nextLine());
        System.out.print("Telefone: ");
        String registroDoTelefone = (teclado.nextLine());

        Registro registro = new Registro(
                registroDoNome, registroDoNascimento,
                registroDoEmail, registroDoTelefone
        );

        return registro;
    }

    private static void categorizarRegistro(Scanner teclado, String registroDoNome, Registro registro)
    {
        int categoria;

        System.out.println("\n========================\n ESCOLHA UMA CATEGORIA\n");
        System.out.println("1) Funcionário");
        System.out.println("2) Voluntário");
        System.out.println("3) Doador");
        System.out.println("4) Visitante\n");
        System.out.print("Informe a categoria: ");
        categoria = Integer.parseInt(teclado.nextLine());

        switch (categoria)
        {
            case 1:
                if (verificarSeORegistroFoiFeito(registroDoNome, Funcionario.class) == false) {
                    registro = registrarFuncionario(registro, teclado);
                }
                break;
            case 2:
                if (verificarSeORegistroFoiFeito(registroDoNome, Voluntario.class) == false) {
                    registro = registrarVoluntario(registro, teclado);
                }
                break;
            case 3:
                if (verificarSeORegistroFoiFeito(registroDoNome, Doador.class) == false) {
                    registro = registrarDoador(registro, teclado);
                }
                break;
            case 4:
                if (verificarSeORegistroFoiFeito(registroDoNome, Visitante.class) == false) {
                    registro = registrarVisitante(registro, teclado);
                }
                break;
            default:
                System.out.println("=> OPÇÃO INVÁLIDA");
                break;
        }

        registros.add(numeroDeRegistros, registro);
        numeroDeRegistros++;
        ordenar(registros);

        arvoreAVL.root = arvoreAVL.insert(arvoreAVL.root, registro.registroDoNome, registro);
    }

    //

    private static Registro registrarFuncionario(Registro registro, Scanner teclado)
    {
        String cargo;

        System.out.println("\nInforme o cargo: ");
        cargo = teclado.nextLine();

        return new Funcionario(registro, cargo);
    }
    private static Registro registrarVoluntario(Registro registro, Scanner teclado)
    {
        String trabalho;

        System.out.println("\nInforme o trabalho voluntário: ");
        trabalho = teclado.nextLine();

        return new Voluntario(registro, trabalho);
    }
    private static Registro registrarDoador(Registro registro, Scanner teclado)
    {
        String bemDoado;

        System.out.println("\nInforme o bem doado: ");
        bemDoado = teclado.nextLine();

        return new Doador(registro, bemDoado);
    }
    private static Registro registrarVisitante(Registro registro, Scanner telado)
    {
        String dataVisita;

        System.out.println("\nInforme a data da visita: ");
        dataVisita = telado.nextLine();

        return new Visitante(registro, dataVisita);
    }

    //

    private static void ordenar(ArrayList<Registro> registros)
    {
        int i, j, n;

        // BUBBLE SORT
        n = numeroDeRegistros;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (registros.get(j).registroDoNome.compareToIgnoreCase(
                        registros.get(j + 1).registroDoNome) > 0) {
                    Registro aux = registros.get(j);
                    registros.set(j, registros.get(j + 1));
                    registros.set(j + 1, aux);
                }
            }
        }
    }

    private static <T> boolean verificarSeORegistroFoiFeito(String registroDoNome, Class<T> classe)
    {
        int i;
        String categoria;

        for (i = 0; i < numeroDeRegistros; i++) {
            if (registros.get(i).getRegistroDoNome().equalsIgnoreCase(registroDoNome) &&
                    classe.isInstance(registros.get(i)))
            {
                categoria = registros.get(i).getClass().getName();
                System.out.println("O usuário já está cadastrado como " + categoria + ".");
                return true;
            }
        }

        return false;
    }

    private static void buscarInformacoesSobreRegistro(Scanner teclado)
    {
        System.out.println("\nInforme o nome: ");
        String nome = teclado.nextLine();

        arvoreAVL.imprimir(arvoreAVL.root, nome);
    }

    private static void imprimirListaDeAtendimento()
    {
        System.out.println("\n======================\n" + " ORDEM DE ATENDIMENTO\n");

        int i;
        for (i = 0; i < registros.size(); i++) {
            System.out.println("No." + (i + 1) + " para ser atendido: " + registros.get(i).registroDoNome);
        }
    }
}