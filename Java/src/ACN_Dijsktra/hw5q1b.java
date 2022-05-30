package ACN_Dijsktra;

public class hw5q1b {

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeE.addDestination(nodeB, 3);
        nodeE.addDestination(nodeC, 9);
        nodeE.addDestination(nodeD, 2);

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeE, 5);

        nodeC.addDestination(nodeD, 4);


        nodeB.addDestination(nodeC, 1);
        nodeB.addDestination(nodeE, 2);

        nodeD.addDestination(nodeA, 7);
        nodeD.addDestination(nodeC, 6);

        Graph graph = new Graph();


        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph = Code.calculateShortestPathFromSource(graph, nodeA);

        for (Node a : graph.getNodes()) {
            System.out.println("Node\t distancefromSourcenode'A' ");
            System.out.println(a.getName() + "\t\t\t\t" + a.getDistance());

        }

    }

}
