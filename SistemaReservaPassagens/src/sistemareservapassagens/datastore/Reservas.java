package sistemareservapassagens.datastore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Reservas {

    private String id;
    private String nome;
    private int telefone;
    private String destino;
    private double preco;
    private String classe;
    private Routas routa;
    HashMap<String, String> data;
    private static final String arquivoDeReservas = "Reservas.txt";

    public Reservas(String id, String nome, int telefone, Routas routa, HashMap<String, String> data) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.routa = routa;
        this.destino = routa.getDestino();
        this.preco = routa.getPreco();
        this.classe = routa.getClasse();
        this.data = data;
    }
    
    public Reservas(){};

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Routas getRouta() {
        return routa;
    }

    public void setRouta(Routas routa) {
        this.routa = routa;
    }

    public void fazerReserva() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Reservas.arquivoDeReservas, true));
        writer.write(id + "," + nome + "," + telefone + "," + this.destino + "," + this.preco
                + "," + this.classe + "," + data.get("dataAtual") + "," + data.get("dataDePartida")
        );
        writer.newLine();
        writer.close();
    }

    public ArrayList<Reservas> listaDeReservas() throws FileNotFoundException, IOException {
        ArrayList<Reservas> listaDeReservas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(Reservas.arquivoDeReservas));

        String routaInfo;
        HashMap<String, String> data = new HashMap<>();
        while ((routaInfo = reader.readLine()) != null) {
            String[] detalhesDaReserva = routaInfo.split(",");
            data.put("dataAtual", detalhesDaReserva[6]);
            data.put("dataDePartida", detalhesDaReserva[7]);

            Reservas reserva = new Reservas(detalhesDaReserva[0], detalhesDaReserva[1], Integer.parseInt(detalhesDaReserva[2]),
                    new Routas(detalhesDaReserva[3], Double.parseDouble(detalhesDaReserva[4]), detalhesDaReserva[5]), data
            );
            listaDeReservas.add(reserva);
        }

        reader.close();
        return listaDeReservas;
    }

    public void reservasDisponiveis(ArrayList<Reservas> reservas) {
        System.out.printf("%-5s     %-24s          %-8s          %-16s           %-30s          %-30s\n", "Opção", "Destino", "preço", "Classe", "Data De Emissão", "Data de Partida");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < reservas.size(); i++) {
            System.out.printf("%-5d     %-24s          %-8.2f          %-16s           %-30s          %-30s\n",
                    i + 1, reservas.get(i).getDestino(), reservas.get(i).getPreco(), reservas.get(i).getClasse(), reservas.get(i).data.get("dataAtual"), reservas.get(i).data.get("dataDePartida"));
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void atualizarReserva(String idCode, Reservas reservaAtualizada) throws FileNotFoundException, IOException {
        ArrayList<Reservas> reservas = this.listaDeReservas();
        Reservas reservaAlvo = null;

        for (Reservas encontrarAlvo : reservas) {
            if (encontrarAlvo.id.equals(idCode)) {
                reservaAlvo = encontrarAlvo;
            }
        }

        if (reservaAlvo == null) {
            System.out.println("Não há nenhume reserva nesse nome");
            return;
        }

        int index = reservas.indexOf(reservaAlvo);
        reservas.set(index, reservaAtualizada);
        //reservas.remove(reservaAlvo);

        File arquivoReservas = new File(Reservas.arquivoDeReservas);
        arquivoReservas.delete();

        for (Reservas listaAtualizada : reservas) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Reservas.arquivoDeReservas, true));
            writer.write(listaAtualizada.id + "," + listaAtualizada.nome + "," + listaAtualizada.telefone + "," + listaAtualizada.destino + "," + listaAtualizada.preco + "," + listaAtualizada.classe);
            writer.newLine();
            writer.close();
        }
    }

    public void cancelarReserva(String idCode) throws FileNotFoundException, IOException {
        ArrayList<Reservas> reservas = this.listaDeReservas();
        Reservas reservaAlvo = null;

        for (Reservas encontrarAlvo : reservas) {
            if (encontrarAlvo.id.equals(idCode)) {
                reservaAlvo = encontrarAlvo;
            }
        }

        if (reservaAlvo == null) {
            System.out.println("Não há nenhume reserva nesse nome");
            return;
        }

        reservas.remove(reservaAlvo);
        File arquivoReservas = new File(Reservas.arquivoDeReservas);
        arquivoReservas.delete();

        for (Reservas listaAtualizada : reservas) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Reservas.arquivoDeReservas, true));
            writer.write(listaAtualizada.id + "," + listaAtualizada.nome + "," + listaAtualizada.telefone + "," + listaAtualizada.destino + "," + listaAtualizada.preco + "," + listaAtualizada.classe);
            writer.newLine();
            writer.close();
        }
    }
}
