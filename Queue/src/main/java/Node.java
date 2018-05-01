class Node<T> {

    private T value;
    private Node<T> nextNode;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return this.value;
    }

    Node<T> getNextNode() {
        return this.nextNode;
    }

    void setNextNode(Node<T> node) {
        this.nextNode = node;
    }
}
