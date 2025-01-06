public class Test
{
    public static void linkListTest()
    {
        System.out.printf("Hello and welcome!\n\n");
        // an array of integers
        int[] a = {10, 2, 3, 2, 5, -4, 0, 2, 3, 0, 3, 9};
        // create a list from the array
        NodeInt first = Exercise.arrayToList(a);
        // print the list
        ListOp.printList(first);
        // count the number of times 3 appears in the list
        System.out.println("3 appears " + Exercise.countValue(first, 3) + " times");
        // find the first index of 3 in the list
        System.out.println("The first index of 3 is " + Exercise.indexOf(first, 3) + " (zero-based)\n");
        // Insert 7 into the list at index 5
        System.out.println("Inserting 7 at index 5:");
        first = Exercise.insert(first, 7, 5);
        ListOp.printList(first);
        // Insert 7 into the list at index 1
        System.out.println("Inserting 7 at index 1:");
        first = Exercise.insert(first, 7, 1);
        ListOp.printList(first);
        // Insert 7 into the list at index 15
        System.out.println("Inserting 7 at index 20:");
        NodeInt temp = Exercise.insert(first, 7, 20);
        ListOp.printList(temp);
        //
        int[] b = {1, 3, 5, 7, 9, 11, 13, 15, 17, 22, 30};
        NodeInt firstF = Exercise.arrayToList(b);
        // Insert 8 into a sorted list
        System.out.println("\nInserting 8 into a sorted list:");
        firstF = Exercise.insertSorted(firstF, 8);
        ListOp.printList(firstF);
        // Insert -2 into a sorted list
        System.out.println("Inserting -2 into a sorted list:");
        firstF = Exercise.insertSorted(firstF, -2);
        ListOp.printList(firstF);
        // Insert 30 into a sorted list
        System.out.println("Inserting 30 into a sorted list:");
        firstF = Exercise.insertSorted(firstF, 30);
        ListOp.printList(firstF);
        // Remove all 3s from the list
        System.out.println();
        first = Exercise.insert(first, 7, 15);
        ListOp.printList(first);
        System.out.println("Removing all 3s from the list:");
        first = Exercise.removeAll(first, 3);
        ListOp.printList(first);
        //first = Exercise.insert(first, 10, 1);
        //first = Exercise.insert(first, 10, 12);
        //ListOp.printList(first);
        System.out.println("Removing all 7s from the list:");
        first = Exercise.removeAll(first, 7);
        ListOp.printList(first);
    }
}