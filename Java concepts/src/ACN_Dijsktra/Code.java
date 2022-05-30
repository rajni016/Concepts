package ACN_Dijsktra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Code {

    public static ACN_Dijsktra.Graph calculateShortestPathFromSource(Graph graph, ACN_Dijsktra.Node source) {
        source.setDistance(0);

        Set<ACN_Dijsktra.Node> settledNodes = new HashSet<>();
        Set<ACN_Dijsktra.Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            ACN_Dijsktra.Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry <ACN_Dijsktra.Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                ACN_Dijsktra.Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static ACN_Dijsktra.Node getLowestDistanceNode(Set <ACN_Dijsktra.Node> unsettledNodes) {
        ACN_Dijsktra.Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (ACN_Dijsktra.Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(ACN_Dijsktra.Node evaluationNode, Integer edgeWeigh, ACN_Dijsktra.Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<ACN_Dijsktra.Node> shortestPath = new LinkedList<Node>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
