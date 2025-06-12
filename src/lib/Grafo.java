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

    public void adicionarAresta(T origem, T destino, float peso){
        Vertice<T> verticeOrigem, verticeDestino;
        Aresta<T> novaAresta;
        //Busca o vertice com o valor de origem
        verticeOrigem = obterVertice(origem);
        //Se ainda nao existe vertice com o valor da origem, vou criar o vertice
        if(verticeOrigem==null)
            verticeOrigem = adicionarVertice(origem);
        //Busca o vertice com o valor do destino
        verticeDestino = obterVertice(destino);
        //Se ainda nao existe vertice com o valor destino, vou criar o vertice
        if(verticeDestino==null)
            verticeDestino = adicionarVertice(destino);
        //Agora crio a aresta que vai da origem ao destino
        novaAresta = new Aresta<T>(verticeOrigem, verticeDestino, peso);
        //Adicionei a aresta a lista do Grafo
        this.arestas.add(novaAresta);

    }

}
