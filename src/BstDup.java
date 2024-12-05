import java.util.Arrays;

/**
 * Class for Binary Search Trees that handle duplicates with a center node reference.
 *
 * @author Hwansu Kim (Billy)
 * @version 05.25.2022
 */
public class BstDup<E extends Comparable<E>> implements BstDupInterface<E> {

    /** The root node */
    private Node<E> root;
    /** The size of the BST */
    private int size;

    /**
     * Class constructor
     */
    public BstDup() {
        root = null;
        size = 0;
    }


    /**
     * Clears the entire tree of data
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }


    /**
     * Retrieves whether the tree contains the specified data
     *
     * @param data the data to search for
     * @return true if the data is present in the tree; false, if not
     */
    @Override
    public boolean contains(E data) {
        return contains(data, root);
    }

    /**
     * Recursive method for contains
     *
     * @param data the data to search for
     * @param startNode the current node being checked
     * @return true if the data is present in the tree; false, if not
     */
    private boolean contains(E data, Node<E> startNode) {
        if (startNode == null) {
            return false;
        } else if (data.compareTo(startNode.data) == 0) {
            return true;
        } else if (data.compareTo(startNode.data) < 0) {
            return contains(data, startNode.left);
        } else {
            return contains(data, startNode.right);
        }
    }


    /**
     * Traverses the tree to count the elements stored in the tree (including duplicates)
     *
     * @return the number of elements stored in the tree
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * Recursive method for size
     *
     * @param startNode the current node being traversed through
     * @return the number of elements stored in the tree
     */
    private int size(Node<E> startNode) {
        if (startNode == null) {
            return 0;
        } else {
            return 1 + size(startNode.left) + size(startNode.right) + size(startNode.center);
        }
    }


    /**
     * Adds data to the tree, incrementing match count as necessary (if data already exists), or adding
     * new data to the tree (if data does not already exist)
     *
     * @param data the data to add to the tree
     */
    @Override
    public void add(E data) {
        root = add(data, root);
        size++;
    }

    /**
     * Recursive method for add
     *
     * @param data The data to be added to the tree
     * @param startNode The current node being checked and/or added to
     * @return The node that the data was added to
     */
    private Node<E> add(E data, Node<E> startNode) {
        if (startNode == null) {
            startNode = new Node<>(data);
        } else if (data.compareTo(startNode.data) < 0) {
            startNode.left = add(data, startNode.left);
        } else if (data.compareTo(startNode.data) > 0){
            startNode.right = add(data, startNode.right);
        } else {
            if (startNode.center != null) {
                Node<E> newCenter = new Node<>(data);
                newCenter.center = startNode.center;
                startNode.center = newCenter;
            } else {
                startNode.center = new Node<>(data);
            }
        }
        return startNode;
    }


    /**
     * Retrieves all data from the tree (including duplicates), using an in-order traversal
     *
     * @param template an array of the right datatype, of any length (can even be 0);
     *                 the template's data will not be modified within this method
     * @return an array containing the tree data, with duplicates
     */
    @Override
    public E[] getAllDataInOrder(E[] template) {
        template = Arrays.copyOf(template, size);
        getAllDataInOrder(template, root, 0);
        return template;
    }

    /**
     * Overload of getAllDataInOrder; allows choice between InOrder or reverse InOrder
     *
     * @param template an array of the right datatype, of any length (can even be 0);
     *                 the template's data will not be modified within this method
     * @param isAscending true for ascending, false for descending
     * @return an array containing the tree data, with duplicates
     */
    public E[] getAllDataInOrder(E[] template, boolean isAscending) {
        if (isAscending) {
            return getAllDataInOrder(template);
        } else {
            template = Arrays.copyOf(template, size);
            getAllDataReverseInOrder(template, root, 0);
        }
        return template;
    }

    /**
     * Recursive method for getAllDataInOrder
     *
     * @param arrayToFill the array to be filled with data
     * @param startNode the current node to check and/or retrieve data from
     * @param currentIndex the next index of the array to be filled
     * @return the assigned array index of the current node based on inOrder traversal
     */
    private int getAllDataInOrder(E[] arrayToFill, Node<E> startNode, int currentIndex) {
        if (startNode != null) {
            currentIndex = getAllDataInOrder(arrayToFill, startNode.left, currentIndex);
            arrayToFill[currentIndex++] = startNode.data;
            currentIndex = getAllDataInOrder(arrayToFill, startNode.center, currentIndex);
            currentIndex = getAllDataInOrder(arrayToFill, startNode.right, currentIndex);
        }
        return currentIndex;
    }

    /**
     * getAllDataInOrder for an array in reverse Inorder (descending).
     *
     * @param arrayToFill the array to be filled with data
     * @param startNode the current node to check and/or retrieve data from
     * @param currentIndex the next index of the array to be filled
     * @return the assigned array index of the current node based on reverse InOrder traversal
     */
    private int getAllDataReverseInOrder(E[] arrayToFill, Node<E> startNode, int currentIndex) {
        if (startNode != null) {
            currentIndex = getAllDataReverseInOrder(arrayToFill, startNode.right, currentIndex);
            arrayToFill[currentIndex++] = startNode.data;
            currentIndex = getAllDataReverseInOrder(arrayToFill, startNode.center, currentIndex);
            currentIndex = getAllDataReverseInOrder(arrayToFill,startNode.left, currentIndex);
        }
        return currentIndex;
    }


    /**
     * Nested-class for Nodes
     *
     * @param <T> Generic type parameter
     */
    private static class Node<T> {
        /** The node's data */
        T data;
        /** The left child node */
        Node<T> left;
        /** The right child node */
        Node<T> right;
        /** The center child node */
        Node<T> center;

        /**
         * Node constructor
         *
         * @param data The node's data
         */
        public Node(T data) {
            this.data = data;
            left = right = center = null;
        }
    }
}
