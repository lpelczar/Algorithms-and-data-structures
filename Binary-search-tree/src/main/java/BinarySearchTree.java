import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class BinarySearchTree {

    private Node<Integer> root;

    private BinarySearchTree(Node<Integer> root) {
        this.root = root;
    }

    public static BinarySearchTree fromArray(Integer[] array) {

        if (IntStream.range(0, array.length - 1).anyMatch(i -> array[i] > array[i + 1])) {
            throw new IllegalArgumentException("Array not sorted!");
        }

        if (!Arrays.stream(array).allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("Elements are not unique!");
        }

        return new BinarySearchTree(getBinarySearchTree(array, 0, array.length - 1));
    }

    private static Node<Integer> getBinarySearchTree(Integer[] array, Integer start, Integer end) {

        if (start > end) return null;
        Integer mid = start + (end - start) / 2;
        Node<Integer> root = new Node<>(array[mid]);
        root.setLeftChild(getBinarySearchTree(array, start, mid - 1));
        root.setRightChild(getBinarySearchTree(array, mid + 1, end));
        return root;
    }

    public boolean contains(Integer number) {
        return findNumber(root, number);
    }

    private boolean findNumber(Node<Integer> node, Integer number) {
        boolean found = false;
        if (node != null) {
            if (number.equals(node.getData())) return true;
            if (number < node.getData()) { found = findNumber(node.getLeftChild(), number); }
            if (number > node.getData()) { found = findNumber(node.getRightChild(), number); }
        }
        return found;
    }

    public void add(Integer number) {

        if (contains(number)) {
            throw new IllegalArgumentException("Tree already contains this number!");
        }

        root = insert(root, number);
    }

    private Node<Integer> insert(Node<Integer> root, Integer number) {

        if (root == null) {
            root = new Node<>(number);
            return root;
        }

        if (number < root.getData()) {
            root.setLeftChild(insert(root.getLeftChild(), number));
        } else if (number > root.getData()) {
            root.setRightChild(insert(root.getRightChild(), number));
        }
        return root;
    }

    public void remove(Integer number) {

        root = delete(root, number);
    }

    private Node<Integer> delete(Node<Integer> root, Integer number) {

        if (root == null) return null;

        if (number < root.getData()) {
            root.setLeftChild(delete(root.getLeftChild(), number));
        } else if (number > root.getData()) {
            root.setRightChild(delete(root.getRightChild(), number));
        } else {
            /* Node has one child or is the leaf */
            if (root.getLeftChild() == null)
                return root.getRightChild();
            else if (root.getRightChild() == null)
                return root.getLeftChild();

            /* Node has two children -> get smallest value from the right child descendants */
            root.setData(getLowestChildValue(root.getRightChild()));

            /* Delete the smallest from the right child descendants */
            root.setRightChild(delete(root.getRightChild(), root.getData()));
        }

        return root;
    }

    private Integer getLowestChildValue(Node<Integer> root) {

        Integer minValue = root.getData();
        while (root.getLeftChild() != null)
        {
            minValue = root.getLeftChild().getData();
            root = root.getLeftChild();
        }
        return minValue;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        printTreeAscending(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void printTreeAscending(Node<Integer> node, StringBuilder stringBuilder) {
        if (node != null) {
            printTreeAscending(node.getLeftChild(), stringBuilder);
            stringBuilder.append(" ");
            stringBuilder.append(node.getData().toString());
            printTreeAscending(node.getRightChild(), stringBuilder);
        }
    }
}
