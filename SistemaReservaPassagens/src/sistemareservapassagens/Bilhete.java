package sistemareservapassagens;

import java.io.IOException;
import java.util.HashMap;
import sistemareservapassagens.datastore.Reservas;
import sistemareservapassagens.datastore.Routas;

public class Bilhete {

    private String nome;
    private int telefone;
    HashMap<String, String> data;

    public Bilhete(String nome, int telefone, HashMap<String, String> data) {
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void gerarBilhete(Routas routa) throws IOException {
        // Gerando id da reserva
        String id = "";
        for (int i = 0; i < 5; i++) {
            id += String.valueOf(Math.round(Math.random() * 9));
        }
        
        new Reservas(id, this.nome, this.telefone, routa, this.data).fazerReserva();

        System.out.println("Sobre o viajante".toUpperCase());
        System.out.println("Nome do viajante: " + this.nome);
        System.out.println("Telefone: " + this.telefone);
        
        System.out.println("\nSobre a viajem".toUpperCase());
        System.out.println("ID do bilhete: " + id);
        System.out.println("Percurso da viagem: " + routa.getDestino());
        System.out.println("Classe: " + routa.getClasse());
        System.out.println("Preço: " + routa.getPreco() + "MZN");

        System.out.println("\nData de Emissão: " + this.data.get("dataAtual"));
        System.out.println("Data de partida: " + this.data.get("dataDePartida"));
    }
    
    
}
