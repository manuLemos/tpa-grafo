package lib;

import java.util.ArrayList;
import java.util.HashSet;

public class VerificadorDeCiclo<T> {
    private Grafo<T> grafo;

    public VerificadorDeCiclo(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public boolean possuiCiclo() {
        HashSet<Vertice<T>> visitados = new HashSet<>();
        HashSet<Vertice<T>> emRecursao = new HashSet<>();

        for (Vertice<T> v : grafo.getVertices()) {
            if (!visitados.contains(v)) {
                if (dfs(v, visitados, emRecursao)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(Vertice<T> atual, HashSet<Vertice<T>> visitados, HashSet<Vertice<T>> emRecursao) {
        visitados.add(atual);
        emRecursao.add(atual);

        for (Aresta<T> aresta : grafo.getArestas()) {
            if (aresta.getOrigem().equals(atual)) {
                Vertice<T> vizinho = aresta.getDestino();

                if (!visitados.contains(vizinho)) {
                    if (dfs(vizinho, visitados, emRecursao)) {
                        return true;
                    }
                } else if (emRecursao.contains(vizinho)) {
                    return true; // ciclo detectado
                }
            }
        }

        emRecursao.remove(atual);
        return false;
    }
}
