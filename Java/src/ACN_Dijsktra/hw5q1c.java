package ACN_Dijsktra;

public class hw5q1c {

    public static void main(String[] args) {


        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeJ = new Node("J");
        Node nodeK = new Node("K");

        nodeA.addDestination(nodeE, 1);
        nodeA.addDestination(nodeB, 1);

        nodeB.addDestination(nodeA, 1);
        nodeB.addDestination(nodeC, 1);

        nodeC.addDestination(nodeG, 1);
        nodeC.addDestination(nodeF, 3);
        nodeC.addDestination(nodeJ, 4);
        nodeC.addDestination(nodeB, 1);

        nodeD.addDestination(nodeH, 1);
        nodeD.addDestination(nodeK, 1);
        nodeD.addDestination(nodeJ, 2);
        nodeD.addDestination(nodeE, 5);

        nodeE.addDestination(nodeG, 1);
        nodeE.addDestination(nodeD, 5);
        nodeE.addDestination(nodeA, 1);

        nodeF.addDestination(nodeK, 1);
        nodeF.addDestination(nodeC, 3);

        nodeG.addDestination(nodeE, 1);
        nodeG.addDestination(nodeH, 1);
        nodeG.addDestination(nodeC, 1);

        nodeH.addDestination(nodeG, 1);
        nodeH.addDestination(nodeD, 1);

        nodeJ.addDestination(nodeC, 4);
        nodeJ.addDestination(nodeD, 2);

        nodeK.addDestination(nodeD, 1);
        nodeK.addDestination(nodeF, 1);


        Graph graph = new Graph();


        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);
        graph.addNode(nodeJ);
        graph.addNode(nodeK);

        graph = Code.calculateShortestPathFromSource(graph, nodeA);

        for (Node a : graph.getNodes()) {
            System.out.println("Node \t distancefromSource'A'");
            System.out.println(a.getName() + "\t\t\t\t" + a.getDistance());


        }

    }
}
