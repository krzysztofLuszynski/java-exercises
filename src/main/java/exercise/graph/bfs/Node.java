package exercise.graph.bfs;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;

class Node {
    private final String id;

    private final Collection<Node> children;

    public Node(final String id, final Collection<Node> children) {
        this.id = id;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public Collection<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("children", getChildren())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return new EqualsBuilder().append(getId(), node.getId()).append(getChildren(), node.getChildren()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getChildren()).toHashCode();
    }
}
