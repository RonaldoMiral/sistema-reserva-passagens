package sistemareservapassagens;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import sistemareservapassagens.datastore.Reservas;
import sistemareservapassagens.datastore.Routas;

public class SistemaReservaPassagens {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //Routas routas = new Routas("Cabo Delgado", 1300, "Primeira Classe");
        //routas.novaRouta();
        //routas.routasDisponiveis(routas.listaDeRoutas(), dataDePartida());

        //Bilhete bilhete = new Bilhete("SlayKing", 847417472, data());
        //bilhete.gerarBilhete(routas.listaDeRoutas().get(0));
        
        //Reservas reservas = new Reservas();
        //reservas.fazerReserva();
        //reservas.reservasDisponiveis(reservas.listaDeReservas());
        //reservas.cancelarReserva("id12345");
        //reservas.atualizarReserva("44543", reservas);
    }
    
    public static HashMap data() {
        HashMap<String, String> data = new HashMap<>();
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formataDataAtual = new SimpleDateFormat("EEE MMM dd HH:mm zzz yyyy");
        data.put("dataAtual", formataDataAtual.format(calendar.getTime()));
        
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 8, 0);
        calendar.add((GregorianCalendar.DAY_OF_MONTH), 1);
        SimpleDateFormat formataDataDePartida = new SimpleDateFormat("EEE MMM dd HH:mm zzz yyyy");
        data.put("dataDePartida", formataDataDePartida.format(calendar.getTime()));
        
        return data;
    }

    // Método/função limpa o console
    public final static void limparConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(60);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            System.out.println(ex);
        }
    }

}
