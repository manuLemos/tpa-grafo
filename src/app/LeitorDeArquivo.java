package app;

import lib.Grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeArquivo {
    public static Grafo<String> carregarGrafoDeArquivo(String caminho) {
        Grafo<String> grafo = new Grafo<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty() || linha.startsWith("#")) continue;

                String[] partes = linha.split("\\s+");
                if (partes.length != 3) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                String origem = partes[0];
                String destino = partes[1];
                float peso;

                try {
                    peso = Float.parseFloat(partes[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Peso inválido na linha: " + linha);
                    continue;
                }

                grafo.adicionarAresta(origem, destino, peso);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }

        return grafo;
    }
}
