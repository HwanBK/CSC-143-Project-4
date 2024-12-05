
import static org.junit.jupiter.api.Assertions.*;

class BstDupTest {

    private BstDup<String> stringTree;
    private BstDup<Customer> custoTree;

    public BstDupTest() {
        stringTree = new BstDup<>();
        custoTree = new BstDup<>();
    }

    @org.junit.jupiter.api.Test
    void clear() {
        // Check to ensure test begins with an empty BST //
        assertEquals(0, stringTree.size());

        // Adds a single item; incrementing size //
        stringTree.add("Orange");
        assertEquals(1, stringTree.size());
        assertTrue(stringTree.contains("Orange"));

        // Checks for size of 0 and data removal //
        stringTree.clear();
        assertEquals(0, stringTree.size());
        assertFalse(stringTree.contains("Orange"));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        // Contains test after adding //
        stringTree.add("Orange");
        stringTree.add("Blue");
        stringTree.add("Red");
        assertTrue(stringTree.contains("Orange"));
        assertTrue(stringTree.contains("Blue"));
        assertTrue(stringTree.contains("Red"));

        // Contains test after clearing //
        stringTree.clear();
        assertFalse(stringTree.contains("Orange"));
        assertFalse(stringTree.contains("Blue"));
        assertFalse(stringTree.contains("Red"));
    }

    @org.junit.jupiter.api.Test
    void size() {
        // Size when empty/root data is null //
        assertEquals(0, stringTree.size());

        // Size after adding duplicates //
        stringTree.add("Orange");
        stringTree.add("Orange");
        stringTree.add("Orange");
        stringTree.add("Orange");
        stringTree.add("Orange");
        assertEquals(5, stringTree.size());

        // Size after adding non-duplicates //
        stringTree.add("Blue");
        stringTree.add("Black");
        stringTree.add("Red");
        stringTree.add("Purple");
        assertEquals(9, stringTree.size());

        // Size after clearing the tree //
        stringTree.clear();
        assertEquals(0, stringTree.size());
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(0, stringTree.size());
        stringTree.add("Orange");
        assertEquals(1, stringTree.size());
        assertTrue(stringTree.contains("Orange"));
        stringTree.add("Pink");
        stringTree.add("Blue");
        String[] stringArray = stringTree.getAllDataInOrder(new String[0]);

        // Checks for proper ordering w/o duplicates //
        assertEquals("Blue", stringArray[0]);
        assertEquals("Orange", stringArray[1]);
        assertEquals("Pink", stringArray[2]);

        custoTree.add(new Customer("Wallace", "Barret", "777-777-7777", 777.77));
        custoTree.add(new Customer("Wallace", "Marlene", "767-767-7676", 767.67));
        custoTree.add(new Customer("Wallace", "David", "676-676-6767", 676.76));

        Customer[] custoArray = custoTree.getAllDataInOrder(new Customer[0]);

        // Checks for proper duplicate additions //
        assertEquals(new Customer("Wallace", "Barret", "777-777-7777", 777.77),
                                                                                                        custoArray[0]);
        assertEquals(new Customer("Wallace", "Marlene", "767-767-7676", 767.67),
                                                                                                        custoArray[2]);
        assertEquals(new Customer("Wallace", "David", "676-676-6767", 676.76),
                                                                                                        custoArray[1]);
    }

    @org.junit.jupiter.api.Test
    void getAllDataInOrder() {
        stringTree.add("Turquoise");
        stringTree.add("Green");
        stringTree.add("Purple");
        stringTree.add("Pink");
        stringTree.add("Yellow");
        stringTree.add("Blue");
        stringTree.add("Black");
        stringTree.add("Turquoise");
        stringTree.add("Turquoise");
        stringTree.add("Turquoise");

        String[] colorArray = stringTree.getAllDataInOrder(new String[1000]);
        assertEquals(10, colorArray.length);

        assertEquals("Black", colorArray[0]);
        assertEquals("Blue", colorArray[1]);
        assertEquals("Green", colorArray[2]);
        assertEquals("Pink", colorArray[3]);
        assertEquals("Purple", colorArray[4]);
        assertEquals("Turquoise", colorArray[5]);
        assertEquals("Turquoise", colorArray[6]);
        assertEquals("Turquoise", colorArray[7]);
        assertEquals("Turquoise", colorArray[8]);
        assertEquals("Yellow", colorArray[9]);
    }

    @org.junit.jupiter.api.Test
    void getAllDataReverseInOrder() {
        stringTree.add("Turquoise");
        stringTree.add("Green");
        stringTree.add("Purple");
        stringTree.add("Pink");
        stringTree.add("Yellow");
        stringTree.add("Blue");
        stringTree.add("Black");
        stringTree.add("Turquoise");
        stringTree.add("Turquoise");
        stringTree.add("Turquoise");

        String[] reverseArray = stringTree.getAllDataInOrder(new String[0], false);
        assertEquals(10, reverseArray.length);

        assertEquals("Yellow", reverseArray[0]);
        assertEquals("Turquoise", reverseArray[1]);
        assertEquals("Turquoise", reverseArray[2]);
        assertEquals("Turquoise", reverseArray[3]);
        assertEquals("Turquoise", reverseArray[4]);
        assertEquals("Purple", reverseArray[5]);
        assertEquals("Pink", reverseArray[6]);
        assertEquals("Green", reverseArray[7]);
        assertEquals("Blue", reverseArray[8]);
        assertEquals("Black", reverseArray[9]);
    }
}