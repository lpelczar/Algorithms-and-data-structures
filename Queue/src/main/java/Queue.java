public interface Queue<T> {
    void enqueue(T data);
    T dequeue();
    int size();
    boolean isEmpty();
}
