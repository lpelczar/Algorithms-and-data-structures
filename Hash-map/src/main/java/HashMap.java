import java.util.LinkedList;

public class HashMap<K, V> {

    private int bucketSize = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] elements = new LinkedList[bucketSize];

    {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public void add(K key, V value) {
        int position = getHashPosition(key);
        LinkedList<Entry<K, V>> list = elements[position];

        for (Entry<K, V> entry : list) {
            if (entry.getKey() == key) throw new IllegalArgumentException("Key already exists!");
        }
        list.add(new Entry<>(key,value));
        // resizeIfNecessary();
    }

    public V getValue(K key) {
        int position = getHashPosition(key);
        LinkedList<Entry<K, V>> list = elements[position];

        for (Entry<K, V> entry : list) {
            if (entry.getKey() == key) return entry.getValue();
        }
        throw new IllegalArgumentException("Key not found!");
    }

    public boolean remove(K key) {
        boolean removed = false;
        int position = getHashPosition(key);
        LinkedList<Entry<K, V>> list = elements[position];

        for (Entry<K, V> entry : list) {
            if (entry.getKey() == key) {
                list.remove(entry);
                removed = true;
                break;
            }
        }
        return removed;
    }

    public void clearAll() {
        for (LinkedList<Entry<K, V>> list : elements) {
            for (Entry<K, V> entry : list) {
                list.remove(entry);
            }
        }
    }

    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> list : elements) {
            if (!list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private int getHashPosition(K key) {
        return key.hashCode() % bucketSize;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<Entry<K, V>> list : elements) {
            for (Entry<K, V> entry : list) {
                stringBuilder.append(" ").append(entry.getKey()).append(" : ").append(entry.getValue());
            }
        }
        return stringBuilder.toString();
    }
}
