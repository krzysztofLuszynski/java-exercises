package exercise.graph.bfs;

import java.util.*;

class Bfs {
    List<Node> getProcessedNodes(final Node root, final Collection<Node> nodes) {
        if (root == null) {
            throw new IllegalArgumentException("Root can not be null !");
        } else if (nodes == null || nodes.isEmpty()) {
            throw new IllegalArgumentException("Nodes can not be null or empty!");
        }

        final List<Node> processed = new ArrayList<>();
        final Queue<Node> elements = new LinkedList<>();

        processed.add(root);
        elements.add(root);

        while(!elements.isEmpty()) {
            final Node currentNode = elements.remove();

            if (processed.size() == nodes.size()) {
                break;
            } else {
                for (Node child : currentNode.getChildren()) {
                    if (!processed.contains(child)) {
                        processed.add(child);
                        elements.add(child);
                    }
                }
            }
        }

        return processed;
    }
}
