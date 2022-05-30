package ACN_Dijsktra;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<ACN_Dijsktra.Node> nodes = new HashSet<>();

    public void addNode(ACN_Dijsktra.Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<ACN_Dijsktra.Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

}