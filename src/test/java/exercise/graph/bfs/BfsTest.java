package exercise.graph.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BfsTest {
    private final Bfs bfs = new Bfs();

    @Test
    void nullNode() {
        assertThatThrownBy(()-> bfs.getProcessedNodes(null, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Root can not be null !");
    }

    @Test
    void nullNodes() {
        final Node node1 = new Node("1", Collections.emptyList());

        assertThatThrownBy(()-> bfs.getProcessedNodes(node1, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nodes can not be null or empty!");
    }

    @Test
    void emptyNodes() {
        final Node node1 = new Node("1", Collections.emptyList());

        assertThatThrownBy(()-> bfs.getProcessedNodes(node1, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nodes can not be null or empty!");
    }

    @Test
    void oneNode() {
        final Node node1 = new Node("1", Collections.emptyList());

        final List<Node> processed = bfs.getProcessedNodes(node1, Arrays.asList(node1));

        assertThat(processed).containsExactly(node1);
    }

    @Test
    void bigGraph() {
        final Node node11 = new Node("11", Collections.emptyList());
        final Node node12 = new Node("12", Collections.emptyList());

        final Node node10 = new Node("10", Collections.emptyList());
        final Node node9 = new Node("9", Collections.emptyList());

        final Node node8 = new Node("8", Collections.emptyList());
        final Node node7 = new Node("7", Arrays.asList(node11, node12));

        final Node node6 = new Node("6", Collections.emptyList());
        final Node node5 = new Node("5", Arrays.asList(node9, node10));

        final Node node4 = new Node("4", Arrays.asList(node7, node8));
        final Node node3 = new Node("3", Collections.emptyList());
        final Node node2 = new Node("2", Arrays.asList(node5, node6));
        final Node node1 = new Node("1", Arrays.asList(node2, node3, node4));

        final Collection<Node> nodes = Arrays.asList(node1, node2, node3);

        final List<Node> processed = bfs.getProcessedNodes(node1, nodes);

        assertThat(processed).containsExactly(
                node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12
        );
    }
}
