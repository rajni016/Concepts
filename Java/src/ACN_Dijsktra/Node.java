package ACN_Dijsktra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;

    private List<ACN_Dijsktra.Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<ACN_Dijsktra.Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(ACN_Dijsktra.Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ACN_Dijsktra.Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<ACN_Dijsktra.Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<ACN_Dijsktra.Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<ACN_Dijsktra.Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

}
