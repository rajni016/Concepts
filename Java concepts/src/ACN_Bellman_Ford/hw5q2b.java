package ACN_Bellman_Ford;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw5q2b {
    LinkedList<String> verticesList;
    LinkedList<ACN_Bellman_Ford.Edge> edgeList;

    Map<String, Integer>  DistancefromVertex;
    Map<String, String> SourceVertex;

    hw5q2b() {
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


        for (String vertex : verticesList) { // Setting the initial distance of each and every vertex to be infinity
            DistancefromVertex.put(vertex, Integer.MAX_VALUE);
            SourceVertex.put(vertex, null);
        }


        DistancefromVertex.put(sourceVertex, 0);// Initialising  the distance of source vertex to be 0

        int V = verticesList.size();

        for (int i = 0; i < V - 1; i++) {
            for (ACN_Bellman_Ford.Edge edge : edgeList) {
                String u = edge.startVertex;
                String v = edge.endVertex;
                if ( DistancefromVertex.get(u) + edge.value <  DistancefromVertex.get(v)) {
                    DistancefromVertex.put(v,  DistancefromVertex.get(u) + edge.value);
                    SourceVertex.put(v, u);
                }
            }
        }
        for (Edge edge : edgeList) {
            String u = edge.startVertex;
            String v = edge.endVertex;
            if ( DistancefromVertex.get(u) + edge.value <  DistancefromVertex.get(v)) {
                System.out.println("Negative-Weighted edges");
                return;
            }
        }
    }

    public void ShortestPathfollowed() {

        for (Map.Entry<String, Integer> entry :  DistancefromVertex.entrySet()) {

            System.out.println("Shortest Path from Source Node 'A' to  "  +"\t" + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        ACN_Bellman_Ford.hw5q2b Add = new ACN_Bellman_Ford.hw5q2b();


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


