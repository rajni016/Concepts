package com.bellman;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BellmanApplication {
    LinkedList<String> vertices;
    LinkedList<Edge> edgeList;

    Map<String, Integer> vertexDistance;
    Map<String, String> vertexParent;

    BellmanApplication() {
        vertices = new LinkedList<>();
        edgeList = new LinkedList<>();
    }

    void addVertex(String vertex) {
        vertices.add(vertex);
    }

    void addEdge(String vertex1, String vertex2, int edgeVal) {
        Edge edge = new Edge();
        edge.startVertex = vertex1;
        edge.endVertex = vertex2;
        edge.value = edgeVal;
        edgeList.add(edge);
    }

    public void getShortestPath(String sourceVertex) {

        vertexDistance = new HashMap<>();
        vertexParent = new HashMap<>();

        // Set the initial distance of every vertex to infinity
        for (String vertex : vertices) {
            vertexDistance.put(vertex, 10);
            vertexParent.put(vertex, null);
        }

        // Initialise the distance of source vertex to be 0
        vertexDistance.put(sourceVertex, 0);

        int V = vertices.size();

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeList) {
                String u = edge.startVertex;
                String v = edge.endVertex;

                // relax the edge
                if (vertexDistance.get(u) + edge.value < vertexDistance.get(v)) {
                    vertexDistance.put(v, vertexDistance.get(u) + edge.value);
                    vertexParent.put(v, u);
                }
            }
        }

        // Relax all the edges again. If we are still getting a lesser distance then
        // there is negative weight cycle in the graph.
        for (Edge edge : edgeList) {
            String u = edge.startVertex;
            String v = edge.endVertex;
            if (vertexDistance.get(u) + edge.value < vertexDistance.get(v)) {
                System.out.println("The Graph contains negative weight cycle");
                return;
            }
        }
    }

    public void printShortestPath() {

        for (Map.Entry<String, Integer> entry : vertexDistance.entrySet()) {

            System.out.println("The shortest path between A and " + entry.getKey() + " is " + entry.getValue());
        }
    }
    public static void main(String[] args) {

        BellmanApplication bellmanApp = new BellmanApplication();// Compiler IDE: Eclipse STS, with Compiler JDK8 and Windows10 64-bit OS.

        // Adding vertices one by one
        bellmanApp.addVertex("A");
        bellmanApp.addVertex("B");
        bellmanApp.addVertex("C");
        bellmanApp.addVertex("D");
        bellmanApp.addVertex("E");
        bellmanApp.addVertex("F");
        bellmanApp.addVertex("G");
        bellmanApp.addVertex("H");
        bellmanApp.addVertex("J");
        bellmanApp.addVertex("K");

        // Adding edges with values.

        bellmanApp.addEdge("A", "E", 1);
        bellmanApp.addEdge("A", "B", 1);

        bellmanApp.addEdge("B", "A", 1);
        bellmanApp.addEdge("B", "C", 1);

        bellmanApp.addEdge("C", "B", 1);
        bellmanApp.addEdge("C", "G", 1);
        bellmanApp.addEdge("C", "F", 3);
        bellmanApp.addEdge("C", "J", 4);

        bellmanApp.addEdge("D", "E", 5);
        bellmanApp.addEdge("D", "H", 1);
        bellmanApp.addEdge("D", "K", 1);
        bellmanApp.addEdge("D", "J", 2);

        bellmanApp.addEdge("E", "A", 1);
        bellmanApp.addEdge("E", "G", 1);
        bellmanApp.addEdge("E", "D", 5);

        bellmanApp.addEdge("F", "K", 1);
        bellmanApp.addEdge("F", "C", 3);

        bellmanApp.addEdge("G", "E", 1);
        bellmanApp.addEdge("G", "H", 1);
        bellmanApp.addEdge("G", "C", 1);

        bellmanApp.addEdge("H", "G", 1);
        bellmanApp.addEdge("H", "D", 1);

        bellmanApp.addEdge("J", "C", 4);
        bellmanApp.addEdge("J", "D", 2);

        bellmanApp.addEdge("K", "D", 1);
        bellmanApp.addEdge("K", "F", 1);

        bellmanApp.getShortestPath("A");// computing the shortest path using bellman

        bellmanApp.printShortestPath();
    }
}
