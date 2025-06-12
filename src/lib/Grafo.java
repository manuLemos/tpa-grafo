package lib;

import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice<T>> vertices;

    public Vertice<T> adicionarVertice(T valor){
        Vertice<T> novo = new Vertice<T>(valor);
        this.vertices.add(novo);
        return novo;
    }

}
