import java.util.LinkedList;

public class HashMap<K, V> {

    private int bucketSize = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] elements = new LinkedList[bucketSize];

    {
        initializeElementsLists();
    }

    private void initializeElementsLists() {
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
        size++;
        resizeIfNeeded();
    }

    private void resizeIfNeeded() {
        if (size > bucketSize * 2) {
            bucketSize *= 2;
            createNewArrayAndCopyElements();
        }
        if (size < bucketSize / 2) {
            bucketSize /= 2;
            createNewArrayAndCopyElements();
        }
    }

    @SuppressWarnings("unchecked")
    private void createNewArrayAndCopyElements() {
        LinkedList<Entry<K, V>>[] elementsCopy = elements.clone();
        elements = new LinkedList[bucketSize];
        initializeElementsLists();

        for (LinkedList<Entry<K, V>> list : elementsCopy) {
            for (Entry<K, V> entry : list) {
                int position = getHashPosition(entry.getKey());
                elements[position].add(new Entry<>(entry.getKey(), entry.getValue()));
            }
        }
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
                size--;
                break;
            }
        }
        resizeIfNeeded();
        return removed;
    }

    public void clearAll() {
        for (LinkedList<Entry<K, V>> list : elements) {
            for (Entry<K, V> entry : list) {
                list.remove(entry);
            }
        }
        size = 0;
        resizeIfNeeded();
    }

    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> list : elements) {
            if (!list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    public int getBucketSize() {
        return bucketSize;
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
