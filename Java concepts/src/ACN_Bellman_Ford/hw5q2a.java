package ACN_Bellman_Ford;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw5q2a {
    LinkedList<String> verticesList;
    LinkedList<ACN_Bellman_Ford.Edge> edgeList;

    Map<String, Integer> DistancefromVertex;
    Map<String, String> SourceVertex;

    hw5q2a() {
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
        SourceVertex= new HashMap<>();


        for (String vertex : verticesList) {// Setting the initial distance of each and every vertex to be infinity
            DistancefromVertex.put(vertex, Integer.MAX_VALUE);
            SourceVertex.put(vertex, null);
        }

        DistancefromVertex.put(sourceVertex, 0);

        int V = verticesList.size();

        for (int i = 0; i < V - 1; i++) {
            for (ACN_Bellman_Ford.Edge edge : edgeList) {
                String u = edge.startVertex;
                String v = edge.endVertex;


                if (DistancefromVertex.get(u) + edge.value < DistancefromVertex.get(v)) {
                    DistancefromVertex.put(v, DistancefromVertex.get(u) + edge.value);
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

            System.out.println("Shortest Path  From Source Node 'S' to "  +"\t" + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        ACN_Bellman_Ford.hw5q2a Add = new ACN_Bellman_Ford.hw5q2a();


        Add.adding_Vertex("S");
        Add.adding_Vertex("A");
        Add.adding_Vertex("B");
        Add.adding_Vertex("C");
        Add.adding_Vertex("D");
        Add.adding_Vertex("t");



        Add.adding_Edge("S", "A", 4);
        Add.adding_Edge("S", "B", 6);

        Add.adding_Edge("A", "C", 2);
        Add.adding_Edge("A", "D", 1);

        Add.adding_Edge("B", "A", 2);
        Add.adding_Edge("B", "D", 2);

        Add.adding_Edge("C", "D", 1);
        Add.adding_Edge("C", "t", 3);

        Add.adding_Edge("D", "t", 7);

        Add.ShortestPath("S");

        Add.Shortestpathfollowed();
    }
}