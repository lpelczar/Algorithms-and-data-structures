class Node<T> {

    private T value;
    private Integer priority;
    private Node<T> nextNode;

    Node(T value, Integer priority) {
        this.value = value;
        this.priority = priority;
    }

    T getValue() {
        return this.value;
    }

    public Integer getPriority() {
        return priority;
    }

    Node<T> getNextNode() {
        return this.nextNode;
    }

    void setNextNode(Node<T> node) {
        this.nextNode = node;
    }

    @Override
    public String toString() {
        return "Value: " + value + " Priority: " + priority;
    }
}
