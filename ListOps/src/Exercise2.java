public class Exercise2 {
    // Method gets a value and add this value after every item in the list
    public static void addAfter(NodeInt first, int x) {
        NodeInt p = first;
        while (p != null) {
            NodeInt q = new NodeInt(x, p.getNext());
            p.setNext(q);
            p = q.getNext();
        }
    }

    // method gets a list (pointer to the first item) and removes the items in the even indexes
    public static void removeEven(NodeInt first) {
        NodeInt p = first;
        while (p != null && p.getNext() != null) {
            p.setNext(p.getNext().getNext());
            p = p.getNext();
        }
    }

    // method gets a list of ints (pointer to the first item) and removes the items whose value is even
    public static NodeInt removeEvenValues(NodeInt first) {
        NodeInt p = first;
        while (p != null && p.getValue() % 2 == 0) {    // handle the case where the first item is even
            p = p.getNext();
        }
        NodeInt q = p;
        while (p != null) {
            if (p.getValue() % 2 == 0) {
                p.setValue(p.getNext().getValue());
                p.setNext(p.getNext().getNext());
            }
            p = p.getNext();
        }
        return q;
    }

    // method gets a list of ints and prints the values in reverse order
    public static void printReverse(NodeInt first) {
        if (first == null) {
            return;
        }
        printReverse(first.getNext());
        System.out.print(first.getValue() + " ");
    }

    // method gets a list of ints and prints for each value the number of times it appears in the list
    // (in the order of appearance, without repetitions)
    public static void printCount(NodeInt first) {
        boolean alreadPrinted = false;
        for (NodeInt p = first; p != null; p = p.getNext()) {
            alreadPrinted = false;
            for (NodeInt q = first; q != p; q = q.getNext()) {
                if (p.getValue() == q.getValue()) {
                    alreadPrinted = true;
                    break;
                }
            }
            if (!alreadPrinted) {
                int count = 0;
                for (NodeInt q = first; q != null; q = q.getNext()) {
                    if (p.getValue() == q.getValue()) {
                        count++;
                    }
                }
                System.out.println(p.getValue() + " appears " + count + " times");
            }
        }
    }

    }
