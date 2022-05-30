package AcnBellman;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw5q2b {
    LinkedList<String> verticesList;
    LinkedList<Edge> edgeList;

    Map<String, Integer> vertexDistance;
    Map<String, String> vertexParent;

    hw5q2b() {
        verticesList = new LinkedList<>();
        edgeList = new LinkedList<>();
    }

    void adding_Vertex(String vertex) {
        verticesList.add(vertex);
    }

    void adding_Edge(String vertex1, String vertex2, int edgeVal) {
        Edge edge = new Edge();
        edge.startVertex = vertex1;
        edge.endVertex = vertex2;
        edge.value = edgeVal;
        edgeList.add(edge);
    }

    public void ShortestPath(String sourceVertex) {

        vertexDistance = new HashMap<>();
        vertexParent = new HashMap<>();


        for (String vertex : verticesList) { // Setting the initial distance of each and every vertex to be infinity
            vertexDistance.put(vertex, Integer.MAX_VALUE);
            vertexParent.put(vertex, null);
        }


        vertexDistance.put(sourceVertex, 0);// Initialising  the distance of source vertex to be 0

        int V = verticesList.size();

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeList) {
                String u = edge.startVertex;
                String v = edge.endVertex;
                if (vertexDistance.get(u) + edge.value < vertexDistance.get(v)) {
                    vertexDistance.put(v, vertexDistance.get(u) + edge.value);
                    vertexParent.put(v, u);
                }
            }
        }
        for (Edge edge : edgeList) {
            String u = edge.startVertex;
            String v = edge.endVertex;
            if (vertexDistance.get(u) + edge.value < vertexDistance.get(v)) {
                System.out.println("Negative-Weighted edges");
                return;
            }
        }
    }

    public void ShortestPathfollowed() {

        for (Map.Entry<String, Integer> entry : vertexDistance.entrySet()) {

            System.out.println("Shortest Path from Source Node 'A' to  "  +"\t" + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        hw5q2b Add = new hw5q2b();


        Add.adding_Vertex("A");
        Add.adding_Vertex("B");
        Add.adding_Vertex("C");
        Add.adding_Vertex("D");
        Add.adding_Vertex("E");




        // Adding edges with values.

       Add.adding_Edge("A", "B", 10);
        Add.adding_Edge("A", "E", 5);

        Add.adding_Edge("B", "C", 1);
        Add.adding_Edge("B", "E", 2);

        Add.adding_Edge("C", "D", 4);

        Add.adding_Edge("D", "C", 6);
        Add.adding_Edge("D", "A", 7);

        Add.adding_Edge("E", "B", 3);
        Add.adding_Edge("E", "C", 9);
        Add.adding_Edge("E", "D", 2);

            Add.ShortestPath("A");

             Add.ShortestPathfollowed();

    }
}
