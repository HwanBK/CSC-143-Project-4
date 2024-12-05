/**
 * Method requirements for BstDup class
 * @param <E>   type parameter for data stored in the tree
 */
public interface BstDupInterface<E> {

    // BstDup should have a no-parameter constructor

    /**
     * Clears the entire tree of data
     */
    public void clear();

    /**
     * Retrieves whether the tree contains the specified data
     * @param   data    the data to search for
     * @return          true if the data is present in the tree; false, if not
     */
    public boolean contains(E data);

    /**
     * Traverses the tree to count the elements stored in the tree (including duplicates)
     * @return  the number of elements stored in the tree
     */
    public int size();

    /**
     * Adds data to the tree, incrementing match count as necessary (if data already exists), or adding
     *      new data to the tree (if data does not already exist)
     *
     * @param   data    the data to add to the tree
     */
    public void add(E data);

    /**
     * Retrieves all data from the tree (including duplicates), using an in-order traversal
     *
     * @param   template    an array of the right datatype, of any length (can even be 0);
     *                      the template's data will not be modified within this method
     * @return              an array containing the tree data, with duplicates
     */
    public E[] getAllDataInOrder(E[] template);

}
