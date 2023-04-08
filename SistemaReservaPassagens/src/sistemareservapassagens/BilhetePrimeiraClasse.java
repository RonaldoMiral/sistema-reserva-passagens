package sistemareservapassagens;

import java.util.ArrayList;
import sistemareservapassagens.datastore.Destino;

public class BilhetePrimeiraClasse extends BilheteGeral {
        public void mostrarDetalhesPrimeiraClasse(ArrayList<Destino> listaDeDestinosEconomicos) {
        System.out.printf("%-24s          %-8s          %-16s          %-30s\n",
                "Destino", "preço", "Classe", "Data de Partida");
        System.out.println("--------------------------------------------------------------"
                + "-------------------------------------------------");
        for (Destino destino : listaDeDestinosEconomicos) {
            if (destino.getClasse().equals("Primeira Classe")) {
                System.out.printf("%-24s          %-8.2f          %-16s          %-30s\n",
                        destino.getDestino(), destino.getPreco(), destino.getClasse(), this.getDataDePartida());
                System.out.println("--------------------------------------------------------"
                        + "-------------------------------------------------------");
            }
        }
    }
}
