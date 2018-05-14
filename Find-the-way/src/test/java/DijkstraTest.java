import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

    @Test
    void findTheWayTest() {
        Node warsaw = new Node("Warsaw");
        Node london = new Node("London");
        Node paris = new Node("Paris");
        Node lisbon = new Node("Lisbon");
        Node athens = new Node("Athens");

        warsaw.addDestination(paris, 100);
        warsaw.addDestination(london, 450);
        paris.addDestination(lisbon, 300);
        london.addDestination(athens, 500);
        lisbon.addDestination(athens, 800);
        lisbon.addDestination(london, 250);

        Graph graph = new Graph();
        graph.addNode(warsaw);
        graph.addNode(london);
        graph.addNode(paris);
        graph.addNode(lisbon);
        graph.addNode(athens);

        Dijkstra.calculateShortestPathFromSource(graph, warsaw);

        List<Node> shortestPath = athens.getShortestPath();

        StringBuilder result = new StringBuilder();
        for (Node node : shortestPath) {
            result.append(" ");
            result.append(node);
        }
        result.append(", Cost: ");
        result.append(athens.getDistance());

        String expected = " Warsaw London, Cost: 950";
        assertEquals(expected, result.toString());
    }
}
