package AVL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private static boolean validarData = false;
    private static String dataDeAgendamento = new String();
    private static Date dataDoSistema = new Date();
    private static final SimpleDateFormat formatoDaData = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat dataFormatada = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

    protected static void informarData(Scanner teclado)
    {
        System.out.println("\n================\n" + " INFORME A DATA\n");
        formatoDaData.setLenient(false);

        while (validarData == false)
        {
            System.out.println("Data de agendamento (DD/MM/AAAA): ");
            dataDeAgendamento = teclado.nextLine();
            System.out.println();

            try
            {
                dataDoSistema = formatoDaData.parse(dataDeAgendamento);
                System.out.println("=> VALORES VÁLIDOS\n");
                System.out.println("Data no sistema: " + dataDoSistema);
                validarData = true;
            }
            catch (ParseException e) {
                System.out.println("=> VALORES INVÁLIDOS\n");
            }
        }

        System.out.println("Data e horário do agendamento:\n" + dataFormatada.format(dataDoSistema));
    }
}
