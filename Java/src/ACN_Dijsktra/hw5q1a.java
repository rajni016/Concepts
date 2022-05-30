package ACN_Dijsktra;

public class hw5q1a {

    public static void main(String[] args) {

        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodet = new Node("t");


        nodeS.addDestination(nodeA, 4);
        nodeS.addDestination(nodeB, 6);

        nodeA.addDestination(nodeC , 2);
        nodeA.addDestination(nodeD, 1);

        nodeC.addDestination(nodeD, 1);
        nodeC.addDestination(nodet, 3);

        nodeB.addDestination(nodeA, 2);
        nodeB.addDestination(nodeD, 2);

        nodeD.addDestination(nodet, 7);

        ACN_Dijsktra.Graph graph = new Graph();

        graph.addNode(nodeS);
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodet);

        graph = Code.calculateShortestPathFromSource(graph, nodeS);

        for (Node a : graph.getNodes()) {
            System.out.println("node \t\t distancefrom'SourceVertex S' ");
            System.out.println(a.getName() + "\t\t\t\t\t" + a.getDistance());

        }

    }

}


