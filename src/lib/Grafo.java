package lib;

import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Aresta<T>> arestas;
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

    private ArrayList<Aresta<T>> obterDestinos(Vertice<T> v){
        ArrayList<Aresta<T>> destinos = new ArrayList<Aresta<T>>();
        Aresta<T> atual;
        for (Aresta<T> aresta : this.arestas) {
            atual = aresta;
            if (atual.getOrigem().equals(v))
                destinos.add(atual);
        }
        return destinos;
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

    public void buscarEmLargura(){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();
        Vertice<T> atual=this.vertices.get(0);
        fila.add(atual);
        while(fila.size()>0){
            atual = fila.get(0);
            fila.remove(0);
            marcados.add(atual);
            System.out.println(atual.getValor());
            ArrayList<Aresta<T>> destinos = this.obterDestinos(atual);
            Vertice<T> proximo;
            for (Aresta<T> destino : destinos) {
                proximo = destino.getDestino();
                if (!marcados.contains(proximo) && !fila.contains(proximo))
                    fila.add(proximo);
            }
        }
    }

}
