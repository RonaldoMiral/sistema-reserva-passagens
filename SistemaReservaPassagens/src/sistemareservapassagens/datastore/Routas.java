package sistemareservapassagens.datastore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Routas {

    private double preco;
    private String destino;
    private String classe;
    private String arquivo;
    private static final String arquivoDeRoutas = "Routas";

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
    public static final String saida = "Nampula - ";

    public Routas(String destino, double preco, String classe) {
        this.preco = preco;
        this.destino = destino;
        this.classe = classe;
    }

    // Setter and getters
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    // Método que registra uma nova routa no arquivo de routas
    public void novaRouta() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Routas.arquivoDeRoutas + ".txt", true));
        writer.write(saida + this.destino + "," + this.preco + "," + this.classe);
        writer.newLine();
        writer.close();
    }

    // Método que busca as routas no arquivo txt
    public ArrayList<Routas> listaDeRoutas() throws FileNotFoundException, IOException {
        ArrayList<Routas> listaDeRoutas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(Routas.arquivoDeRoutas + ".txt"));

        String routaInfo;
        while ((routaInfo = reader.readLine()) != null) {
            String[] detalhesDaRouta = routaInfo.split(",");

            Routas routa = new Routas(detalhesDaRouta[0], Double.parseDouble(detalhesDaRouta[1]), detalhesDaRouta[2]);
            listaDeRoutas.add(routa);
        }

        reader.close();
        return listaDeRoutas;
    }

    // Métodos que imprime todas as routas disponiveis
    public void routasDisponiveis(ArrayList<Routas> routas, String dataDePartida) {
        System.out.printf("%-5s     %-24s          %-8s          %-16s          %-30s\n", "Opção", "Destino", "preço", "Classe", "Data de Partida");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < routas.size(); i++) {
            System.out.printf("%-5d     %-24s          %-8.2f          %-16s          %-30s\n",
                    i + 1, routas.get(i).getDestino(), routas.get(i).getPreco(), routas.get(i).getClasse(), dataDePartida);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        }
    }
}


/*
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExemploRemoverLinha {
    public static void main(String[] args) {
        File arquivoOriginal = new File("arquivo.txt");
        File arquivoTemporario = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario))) {

            List<String> linhas = new ArrayList<>();
            String linhaAtual;

            while ((linhaAtual = reader.readLine()) != null) {
                linhas.add(linhaAtual);
            }

            linhas.remove(2); // remove a terceira linha (índice 2)

            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: " + e.getMessage());
        }

        // renomeia o arquivo temporário para o original
        arquivoOriginal.delete();
        arquivoTemporario.renameTo(arquivoOriginal);
    }
}
 */
