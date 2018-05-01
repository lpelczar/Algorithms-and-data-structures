class Stack<E> {

    private int size = 0;
    private int capacity;
    private Object[] elements;

    Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    int getCapacity() {
        return capacity;
    }

    void push(E element) {
        if (size < capacity) {
            elements[size++] = element;
        } else {
            throw new StackOverflow("Stack if full");
        }
    }

    @SuppressWarnings("unchecked")
    E pop() {
        E element;
        if (size > 0) {
            element = (E) elements[--size];
            elements[size] = null;
        } else {
            throw new StackUnderflow("Stack is empty");
        }
        return element;
    }

    @SuppressWarnings("unchecked")
    E peek() {
        E element;
        if (size > 0) {
            element = (E) elements[size - 1];
        } else {
            throw new StackUnderflow("Stack is empty");
        }
        return element;
    }

    boolean isEmpty() {
        return size >= 0;
    }

    int getSize() {
        return size;
    }

    int getFreeSpaceSize() {
        return capacity - size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object elem : elements) {
            if (elem != null) {
                stringBuilder.append(" ");
                stringBuilder.append(elem);
            }
        }
        return stringBuilder.toString();
    }
}

