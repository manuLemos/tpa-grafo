package lib;

import java.util.*;

public class Dijkstra<T> {
    private final Grafo<T> grafo;

    public Dijkstra(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public Map<T, Float> calcularMenoresDistancias(T origemValor) {
        Vertice<T> origem = grafo.obterVertice(origemValor);
        if (origem == null) return null;

        Map<Vertice<T>, Float> distancias = new HashMap<>();
        Map<T, Float> resultadoFinal = new HashMap<>();
        Set<Vertice<T>> visitados = new HashSet<>();
        PriorityQueue<Vertice<T>> fila = new PriorityQueue<>(Comparator.comparing(distancias::get));

        for (Vertice<T> v : grafo.getVertices()) {
            distancias.put(v, Float.POSITIVE_INFINITY);
        }
        distancias.put(origem, 0f);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice<T> atual = fila.poll();
            if (!visitados.add(atual)) continue;

            for (Aresta<T> aresta : grafo.getArestas()) {
                if (aresta.getOrigem().equals(atual)) {
                    Vertice<T> vizinho = aresta.getDestino();
                    float novaDist = distancias.get(atual) + aresta.getPeso();

                    if (novaDist < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDist);
                        fila.add(vizinho);
                    }
                }
            }
        }

        for (Vertice<T> v : grafo.getVertices()) {
            resultadoFinal.put(v.getValor(), distancias.get(v));
        }
        return resultadoFinal;
    }
}
