package ACN_Bellman_Ford;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw5q2c {
    LinkedList<String> verticesList;
    LinkedList<ACN_Bellman_Ford.Edge> edgeList;

    Map<String, Integer> DistancefromVertex;
    Map<String, String> SourceVertex;

    hw5q2c() {
        verticesList = new LinkedList<>();
        edgeList = new LinkedList<>();
    }

    void adding_Vertex(String vertex) {
        verticesList.add(vertex);
    }

    void adding_Edge(String vertex1, String vertex2, int edgeVal) {
        ACN_Bellman_Ford.Edge edge = new ACN_Bellman_Ford.Edge();
        edge.startVertex = vertex1;
        edge.endVertex = vertex2;
        edge.value = edgeVal;
        edgeList.add(edge);
    }

    public void ShortestPath(String sourceVertex) {

        DistancefromVertex = new HashMap<>();
        SourceVertex = new HashMap<>();


        for (String vertex : verticesList) {
            DistancefromVertex.put(vertex, 10);
            SourceVertex.put(vertex, null);
        }


        DistancefromVertex.put(sourceVertex, 0);

        int V = verticesList.size();

        for (int i = 0; i < V - 1; i++) {
            for (ACN_Bellman_Ford.Edge edge : edgeList) {
                String u = edge.startVertex;
                String v = edge.endVertex;


                if (DistancefromVertex.get(u) + edge.value < DistancefromVertex.get(v)) {
                    DistancefromVertex.put(v,DistancefromVertex.get(u) + edge.value);
                    SourceVertex.put(v, u);
                }
            }
        }


        for (Edge edge : edgeList) {
            String u = edge.startVertex;
            String v = edge.endVertex;
            if (DistancefromVertex.get(u) + edge.value < DistancefromVertex.get(v)) {
                System.out.println("Negative-weighted edges");
                return;
            }
        }
    }

    public void Shortestpathfollowed() {

        for (Map.Entry<String, Integer> entry : DistancefromVertex.entrySet()) {

            System.out.println("The shortest path between 'A' to " +"\t" +entry.getKey() + " is " + entry.getValue());
        }
    }
    public static void main(String[] args) {

        ACN_Bellman_Ford.hw5q2c Add = new ACN_Bellman_Ford.hw5q2c();


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
        Add.adding_Edge("G", "H", 1);
        Add.adding_Edge("G", "C", 1);

        Add.adding_Edge("H", "G", 1);
        Add.adding_Edge("H", "D", 1);

        Add.adding_Edge("J", "C", 4);
        Add.adding_Edge("J", "D", 2);

        Add.adding_Edge("K", "D", 1);
        Add.adding_Edge("K", "F", 1);

        Add.ShortestPath("A");

        Add.Shortestpathfollowed();
    }
}
