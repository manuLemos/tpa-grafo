package lib;

public class Aresta<T> {
    private Vertice<T> origem, destino;
    private float peso;

    public Aresta(Vertice<T> origem, Vertice<T> destino, float peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice<T> getOrigem() {
        return origem;
    }
    public Vertice<T> getDestino() {
        return destino;
    }
    public float getPeso() {
        return peso;
    }
}
