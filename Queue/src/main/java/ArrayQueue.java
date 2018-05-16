public class ArrayQueue<T> implements Queue<T> {

    private int lastIndex, size;
    private int capacity = 2;
    private Object[] elements;

    ArrayQueue() {
        this.elements = new Object[capacity];
        this.lastIndex = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T data) {
        ensureCapacity();
        elements[++lastIndex] = data;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueue("Queue is empty!");
        }
        T element = (T) elements[0];
        size--;
        moveElementsBackByOne();
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (isFull()) {
            capacity *= 2;
            Object[] newElements = new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            this.elements = newElements;
        }
    }

    private boolean isFull() {
        return size == capacity;
    }

    private void moveElementsBackByOne() {
        for (int i = 1; i < size + 1; i++) {
            elements[i - 1] = elements[i];
        }
        lastIndex--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(elements[i]);
        }
        return stringBuilder.toString();
    }
}
