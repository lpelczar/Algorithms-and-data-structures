import java.util.LinkedList;

public class HashMap<K, V> {

    private int bucketSize = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] elements = new LinkedList[bucketSize];

    public void add(K key, V value) {
        int position = getHashPosition(key);
        LinkedList<Entry<K, V>> list = elements[position];

        for (Entry<K, V> entry : list) {
            if (entry.getKey() == key) throw new IllegalArgumentException("Key already exists!");
        }
        list.add(new Entry<>(key,value));
        // resizeIfNecessary();
    }

    private int getHashPosition(K key) {
        return key.hashCode() % bucketSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<Entry<K, V>> elem : elements) {
            for (Entry<K, V> entry : elem) {
                stringBuilder.append(" ").append(entry.getKey()).append(":").append(entry.getValue());
            }
        }
        return stringBuilder.toString();
    }
}
