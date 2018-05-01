public class Stack<E> {

    private int capacity;
    private Object[] elements;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }
}
