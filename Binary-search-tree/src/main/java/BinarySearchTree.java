import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class BinarySearchTree {

    private Node root;

    private BinarySearchTree(Node root) {
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

    public boolean search(Integer number) {
        return findNumber(root, number);
    }

    private boolean findNumber(Node node, Integer number) {
        boolean found = false;
        if (node != null) {
            if (number == node.getData()) return true;
            if (number < (Integer) node.getData()) { found = findNumber(node.getLeftChild(), number); }
            if (number > (Integer) node.getData()) { found = findNumber(node.getRightChild(), number); }
        }
        return found;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        printTreeAscending(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void printTreeAscending(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            printTreeAscending(node.getLeftChild(), stringBuilder);
            stringBuilder.append(" ");
            stringBuilder.append(node.getData().toString());
            printTreeAscending(node.getRightChild(), stringBuilder);
        }
    }
}
