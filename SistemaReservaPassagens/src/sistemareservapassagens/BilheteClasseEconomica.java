package sistemareservapassagens;

import java.util.ArrayList;
import sistemareservapassagens.datastore.Destino;

public class BilheteClasseEconomica extends BilheteGeral {

    public void mostrarDetalhesClasseEconomica(ArrayList<Destino> listaDeDestinosEconomicos) {
        System.out.printf("%-24s          %-8s          %-16s          %-30s\n",
                "Destino", "preço", "Classe", "Data de Partida");
        System.out.println("--------------------------------------------------------------"
                + "-------------------------------------------------");
        for (Destino destino : listaDeDestinosEconomicos) {
            if (destino.getClasse().equals("Classe Económica")) {
                System.out.printf("%-24s          %-8.2f          %-16s          %-30s\n",
                        destino.getDestino(), destino.getPreco(), destino.getClasse(), this.getDataDePartida());
                System.out.println("--------------------------------------------------------"
                        + "-------------------------------------------------------");
            }
        }
    }
}

/* Vai limpar o conteúdo de um arquivo txt
import java.io.*;

public class ClearFileExample {
    public static void main(String[] args) {
        File file = new File("exemplo.txt");
        try {
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.write("");
            pw.flush();
            pw.close();
            fw.close();
            System.out.println("Conteúdo do arquivo apagado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/