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

    public Vertice<T> obterVertice(T valor){
        Vertice<T> v;
        for(int i=0;i<this.vertices.size();i++){
            v=this.vertices.get(i);
            if(v.getValor().equals(valor))
                return v;
        }
        //Se chegou até aqui é poruqe não existe um vertice com esse valor
        return null;
    }

}
