package java_algorithms_homework7;

public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('K');
        graph.addVertex('L');
        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(2, 3); //CD
        graph.addEdge(3, 8); //DK
        graph.addEdge(0, 4); //AE
        graph.addEdge(0, 6); //AG
        graph.addEdge(3, 4); //DE
        graph.addEdge(4, 5); //EF
        graph.addEdge(5, 6); //FG
        graph.addEdge(6, 7); //GH
        graph.addEdge(7, 8); //HK
        graph.addEdge(5, 9); //FL
        graph.addEdge(8, 9); //LK

        graph.minDistance('A', 'K');
    }
}
