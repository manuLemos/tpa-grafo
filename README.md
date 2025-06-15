# Projeto de Grafos em Java

Este projeto implementa uma biblioteca para manipulação de grafos genéricos, com suporte a vértices, arestas com pesos, e algoritmos clássicos como Caminho Mínimo (Dijkstra) e Verificação de Ciclos. Além disso, há um aplicativo interativo que permite ao usuário criar grafos a partir de arquivos e aplicar os algoritmos.

## 📁 Estrutura do Projeto
```bash
/src
    /app
        Main.java # Interface principal do aplicativo
        LeitorDeArquivo.java # Utilitário para ler grafos de arquivos .txt
    /lib
        Grafo.java # Classe principal do grafo (lista de arestas)
        Aresta.java # Classe que representa uma aresta
        Vertice.java # Classe que representa um vértice
        Dijkstra.java # Algoritmo de caminho mínimo
        VerificadorDeCiclo.java # Algoritmo para detectar ciclos
```

## 🔧 Funcionalidades

- Adição de vértices e arestas com pesos
- Caminhamento em largura (BFS)
- Algoritmo de Dijkstra para caminhos mínimos
- Verificação de ciclos em grafos direcionados
- Leitura de grafos via arquivo `.txt`
- Interface interativa via terminal

## 🧠 Algoritmos Implementados

- **Dijkstra** (caminho mínimo) — O((V + E) log V)
- **Verificação de Ciclos** — O(V + E)
- **Busca em Largura** — O(V + E)

## 🗂️ Formato do Arquivo de Entrada
```text
#Formato: origem destino peso
A B 4
A C 2
C B 1
B D 5
C D 8
```
## ▶️ Como Executar

### Requisitos
- Java 8 ou superior
- Terminal ou IDE (IntelliJ, VSCode, Eclipse...)

### Compilação e Execução via terminal

```bash
javac -d bin src/lib/*.java src/app/*.java
java -cp bin app.Main
```