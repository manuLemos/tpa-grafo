package app;

import lib.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo<String> grafo = null;

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Carregar grafo de arquivo");
            System.out.println("2 - Verificar se o grafo possui ciclo");
            System.out.println("3 - Calcular menores distâncias (Dijkstra)");
            System.out.println("4 - Caminhamento em largura");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    //System.out.print("Digite o caminho do arquivo: ");
                    String caminho = "src/exemplos/grafo1.txt"; //scanner.nextLine();
                    grafo = LeitorDeArquivo.carregarGrafoDeArquivo(caminho);
                    if (grafo != null) {
                        System.out.println("Grafo carregado com sucesso.");
                    } else {
                        System.out.println("Erro ao carregar grafo.");
                    }
                    break;

                case "2":
                    if (grafo == null) {
                        System.out.println("Carregue um grafo primeiro.");
                        break;
                    }
                    VerificadorDeCiclo<String> verificador = new VerificadorDeCiclo<>(grafo);
                    boolean temCiclo = verificador.possuiCiclo();
                    System.out.println("O grafo " + (temCiclo ? "possui" : "não possui") + " ciclo.");
                    break;

                case "3":
                    if (grafo == null) {
                        System.out.println("Carregue um grafo primeiro.");
                        break;
                    }
                    System.out.print("Informe o vértice de origem: ");
                    String origem = scanner.nextLine();
                    Dijkstra<String> dijkstra = new Dijkstra<>(grafo);
                    Map<String, Float> distancias = dijkstra.calcularMenoresDistancias(origem);
                    if (distancias == null) {
                        System.out.println("Vértice de origem não encontrado.");
                    } else {
                        System.out.println("Menores distâncias a partir de " + origem + ":");
                        for (Map.Entry<String, Float> entry : distancias.entrySet()) {
                            float distancia = entry.getValue();
                            String valorStr = Float.isInfinite(distancia) ? "Inalcançável" : String.valueOf(distancia);
                            System.out.println("→ " + entry.getKey() + ": " + valorStr);
                        }
                    }
                    break;

                case "4":
                    if (grafo == null) {
                        System.out.println("Carregue um grafo primeiro.");
                        break;
                    }
                    System.out.println("Caminhamento em largura:");
                    grafo.buscarEmLargura();
                    break;

                case "0":
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}