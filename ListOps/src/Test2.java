public class Test2 {
    // Test file for exercise 2 with linked lists
    public static void linkListTest() {
        System.out.printf("Hello and welcome to part 2!\n\n");
        NodeInt myNull = null;
        // an array of integers
        int[] a = {10, 2, 2, 5, -3, -3};
        // create a list from the array
        NodeInt first = Exercise.arrayToList(a);
        // print the list
        ListOp.printList(first);

        // 1. addAfter: 1.	כתוב פעולה המקבלת ערך ומוסיפה איבר עם ערך זה אחרי כל איבר ברשימה
        System.out.println("Adding 7 after each item, then add 4:");
        Exercise2.addAfter(first, 7);
        ListOp.printList(first);
        Exercise2.addAfter(first, 4);
        ListOp.printList(first);
        System.out.println("Testing with null:");
        Exercise2.addAfter(myNull, 4);
        ListOp.printList(myNull);

        // 2. removeEven: 2.	כתוב פעולה המוחקת את האיברים באינדקסים הזוגיים
        System.out.println("Removing items in even indexes:");
        Exercise2.removeEven(first);
        ListOp.printList(first);
        System.out.println("Testing with null:");
        Exercise2.removeEven(myNull);
        ListOp.printList(myNull);

        // 3. removeEvenValues:	3.	כתוב פעולה המוחקת את האיברים שהערכים שלהם זוגיים ברשימה
        System.out.println("Removing items with even values:");
        first = Exercise2.removeEvenValues(first);
        ListOp.printList(first);
        System.out.println("Removing a single even value:");
        ListOp.printList(Exercise2.removeEvenValues(new NodeInt(2)));
        System.out.println("Testing with null:");
        myNull = Exercise2.removeEvenValues(myNull);
        ListOp.printList(myNull);

        // 4. test printReverse: 4.	כתוב פעולה המדפיסה את הערכים ברשימה בסדר הפוך
        System.out.println("Printing the list in reverse order:");
        Exercise2.printReverse(first);
        System.out.println();
        ListOp.printList(first);
        System.out.println("Testing with null:");
        Exercise2.printReverse(myNull);
        //System.out.println();
        ListOp.printList(myNull);

        // 5. test printCount: 5.	כתוב פעולה המדפיסה לכל ערך ברשימה את מספר הופעותיו ברשימה ללא חזרות
        ListOp.printList(first);
        System.out.println("Printing the count of each value:");
        Exercise2.printCount(first);
        ListOp.printList(first);
        System.out.println("Testing with null:");
        Exercise2.printCount(myNull);
        ListOp.printList(myNull);
        System.out.println("Testing with a single item:");
        Exercise2.printCount(new NodeInt(2));
    }
}