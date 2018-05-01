class Stack<E> {

    private int capacity;
    private Object[] elements;

    Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    int getCapacity() {
        return capacity;
    }

    int getFreeSpaceSize() {
        int freeElementsQuantity = 0;
        for (Object elem : elements) {
            if (elem == null) freeElementsQuantity++;
        }
        return freeElementsQuantity;
    }
}

