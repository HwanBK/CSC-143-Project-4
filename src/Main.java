import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BstDup<Customer> customerTree = new BstDup<>();
        File customerFile = new File("CustomerInfo.txt");
        Scanner fileIn = new Scanner(customerFile);

        // Passes over header line in file //
        fileIn.nextLine();

        // Split + strip customer info from .txt before adding to BST //
        String[] custArray;
        while (fileIn.hasNextLine()) {
            String custInfo = fileIn.nextLine();
            custArray = custInfo.split(",");
            for (int num = 0; num < 4; num++) {
                custArray[num] = custArray[num].strip();
            }
            double balanceDouble = Double.parseDouble(custArray[3]);
            Customer newCust = new Customer(custArray[0], custArray[1], custArray[2], balanceDouble);
            customerTree.add(newCust);
        }

        fileIn.close();

        // getAllDataInOrder Demo //
        System.out.println("InOrder");
        Customer[] inOrder = customerTree.getAllDataInOrder(new Customer[0], true);
        for (Customer eachCust : inOrder) {
            System.out.println(eachCust);
        }
        System.out.println();

        // EXTRA CREDIT: Reverse InOrder getAllDataInOrder Overload //
        System.out.println("Reverse InOrder");
        Customer[] reverseInOrder = customerTree.getAllDataInOrder(new Customer[0], false);
        for (Customer eachCust : reverseInOrder) {
            System.out.println(eachCust);
        }

        // contains demo for center nodes/duplicates //
        System.out.println(customerTree.contains(new Customer("Little", "Steve",
                                                                "864-938-3741", 32.34)));
        System.out.println(customerTree.contains(new Customer("Little", "Lorelai",
                                                                "489-158-8354", 323.11)));
        System.out.println(customerTree.contains(new Customer("Wilson", "Stuart",
                                                                "846-247-1886", 15.02)));

        // clear demo //
        customerTree.clear();
        System.out.println(customerTree.size());
        System.out.println(customerTree.contains(new Customer("Little", "Steve",
                "864-938-3741", 32.34)));
    }
}
