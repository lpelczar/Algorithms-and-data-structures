public class CustomQueue<T> {

    private Node<T> firstNode;
    private int size = 0;

    public CustomQueue() {}

    public void enqueue(T value) {
        this.enqueue(value, 0);
    }

    public void enqueue(T value, Integer priority) {
        if (firstNode == null) {
            firstNode = new Node<>(value, priority);
        } else {
            Node<T> newNode = new Node<>(value, priority);
            if (firstNode.getPriority() < priority) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else {
                Node<T> previous = null;
                Node<T> current = firstNode;
                while (current != null && current.getPriority() >= priority) {
                    previous = current;
                    current = current.getNextNode();
                }
                if (previous != null) {
                    previous.setNextNode(newNode);
                }
                newNode.setNextNode(current);
            }
        }
        size++;
    }

    public T peek() {
        if (firstNode == null) {
            throw new EmptyQueue("Queue is empty!");
        } else {
            return firstNode.getValue();
        }
    }

    public T dequeue() {
        Node<T> result;
        if (firstNode == null) {
            throw new EmptyQueue("Queue is empty!");
        } else {
            result = firstNode;
            if (firstNode.getNextNode() != null) {
                firstNode = firstNode.getNextNode();
            } else {
                firstNode = null;
            }
        }
        size--;
        return result.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> current = firstNode;
        while (current != null) {
            System.out.println(current);
            stringBuilder.append(" ");
            stringBuilder.append(current.getValue());
            current = current.getNextNode();
        }
        return stringBuilder.toString();
    }
}
