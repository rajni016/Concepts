package AcnBellman;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw5q2c {
    LinkedList<String> verticesList;
    LinkedList<AcnBellman.Edge> edgeList;

    Map<String, Integer> vertexDistance;
    Map<String, String> vertexParent;

    hw5q2c() {
        verticesList = new LinkedList<>();
        edgeList = new LinkedList<>();
    }

    void adding_Vertex(String vertex) {
        verticesList.add(vertex);
    }

    void adding_Edge(String vertex1, String vertex2, int edgeVal) {
        AcnBellman.Edge edge = new AcnBellman.Edge();
        edge.startVertex = vertex1;
        edge.endVertex = vertex2;
        edge.value = edgeVal;
        edgeList.add(edge);
    }

    public void ShortestPath(String sourceVertex) {

        vertexDistance = new HashMap<>();
        vertexParent = new HashMap<>();

        // Set the initial distance of every vertex to infinity
        for (String vertex : verticesList) {
            vertexDistance.put(vertex, 10);
            vertexParent.put(vertex, null);
        }

        // Initialise the distance of source vertex to be 0
        vertexDistance.put(sourceVertex, 0);

        int V = verticesList.size();

        for (int i = 0; i < V - 1; i++) {
            for (AcnBellman.Edge edge : edgeList) {
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
                System.out.println("Negative-weighted edges");
                return;
            }
        }
    }

    public void Shortestpathfollowed() {

        for (Map.Entry<String, Integer> entry : vertexDistance.entrySet()) {

            System.out.println("The shortest path between 'A' to " +"\t" +entry.getKey() + " is " + entry.getValue());
        }
    }
    public static void main(String[] args) {

        AcnBellman.hw5q2c Add = new AcnBellman.hw5q2c();// Compiler IDE: Eclipse STS, with Compiler JDK8 and Windows10 64-bit OS.

        // Adding vertices one by one
        Add.adding_Vertex("A");
        Add.adding_Vertex("B");
        Add.adding_Vertex("C");
        Add.adding_Vertex("D");
        Add.adding_Vertex("E");
        Add.adding_Vertex("F");
        Add.adding_Vertex("G");
        Add.adding_Vertex("H");
        Add.adding_Vertex("J");
        Add.adding_Vertex("K");

        // Adding edges with values.

        Add.adding_Edge("A", "E", 1);
        Add.adding_Edge("A", "B", 1);

        Add.adding_Edge("B", "A", 1);
        Add.adding_Edge("B", "C", 1);

        Add.adding_Edge("C", "B", 1);
        Add.adding_Edge("C", "G", 1);
        Add.adding_Edge("C", "F", 3);
        Add.adding_Edge("C", "J", 4);

        Add.adding_Edge("D", "E", 5);
        Add.adding_Edge("D", "H", 1);
        Add.adding_Edge("D", "K", 1);
        Add.adding_Edge("D", "J", 2);

        Add.adding_Edge("E", "A", 1);
        Add.adding_Edge("E", "G", 1);
        Add.adding_Edge("E", "D", 5);

        Add.adding_Edge("F", "K", 1);
        Add.adding_Edge("F", "C", 3);

        Add.adding_Edge("G", "E", 1);
        Add.adding_Edge("G", "C", 1);

        Add.adding_Edge("H", "G", 1);
        Add.adding_Edge("H", "D", 1);

        Add.adding_Edge("J", "C", 4);
        Add.adding_Edge("J", "D", 2);

        Add.adding_Edge("K", "D", 1);
        Add.adding_Edge("K", "F", 1);

        Add.ShortestPath("A");// computing the shortest path using bellman

        Add.Shortestpathfollowed();
    }
}


