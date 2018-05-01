public class CustomQueue<T> {

    private Node<T> firstNode;

    public CustomQueue() {}

    public void enqueue(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(value);
        } else {
            Node<T> current = firstNode;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(new Node<>(value));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = firstNode;
        while (current != null) {
            stringBuilder.append(" ");
            stringBuilder.append(current.getValue());
            current = current.getNextNode();
        }
        return stringBuilder.toString();
    }
}
