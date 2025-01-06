public class Exercise {

    // Part 0: Returns a list from an array of integers
    public static NodeInt arrayToList(int[] a)
    {
        NodeInt first = new NodeInt(a[0]);
        NodeInt last = first;
        for (int i=1; i<a.length; i++)
        {
            last = ListOp.insert(last, a[i]);
        }
        return first;
    }

    // Part 1: Returns the number of times 'x' appears in the list
    public static int countValue(NodeInt first, int x)
    {
        NodeInt p = first;
        int count = 0;
        while ( p != null)
        {
            if ( p.getValue() == x )
                count++;
            p = p.getNext();
        }
        return count;
    }

    // Part 2: Returns the first index of 'x' in the list
    public static int indexOf(NodeInt first, int x)
    {
        NodeInt p = first;
        int index = 0;
        while ( p != null)
        {
            if ( p.getValue() == x )
                return index;
            p = p.getNext();
            index++;
        }
        return -1;
    }

    // Part 3: Inserts 'x' into the list, by index. Index 1 is the first element
    public static NodeInt insert(NodeInt first, int x, int index)
    {
        // Handle case where index is 1
        if (index == 1)
        {
            return new NodeInt(x, first);
        }

        NodeInt p = first;
        for (int i=2; i<index; i++)
        {
            if (p == null)
            {
                System.out.println("Error: index too high.");
                return first;
            }
            p = p.getNext();
        }
        ListOp.insert(p, x);
        return first;
    }

    // Part 4: Get a sorted list and insert 'x' into the list
    public static NodeInt insertSorted(NodeInt first, int x)
    {
        // Handle case where x is smaller than the first element
        if (x < first.getValue())
        {
            return new NodeInt(x, first);
        }
        NodeInt p = first;
        while ( p != null)
        {
            if ( x > p.getValue() && (p.getNext() == null ||    // Handle case where x is larger than the last element
                    x <= p.getNext().getValue()) )               // Handle case where x is between two elements
            {
                ListOp.insert(p, x);    // Insert x after p
                return first;
            }
            p = p.getNext();
        }
        // ListOp.insert(p, x);
        return first;   // Should never reach here
    }

    // Part 5: Remove all occurrences of 'x' from the list
    public static NodeInt removeAll(NodeInt first, int x)
    {
        NodeInt p = first;
        while ( p != null)
        {
            if ( p.getValue() == x )
            {
                if (p == first)     // Handle case where x is the first element
                {
                    first = p.getNext();
                    p = first;
                }
             }
            else
            {
                if (p.getNext() == null)        // Handle case where x is the last element
                    return first;
                else if (p.getNext().getValue() == x)   // Handle case where x is in the middle
                {
                    NodeInt temp = p.getNext();
                    p.setNext(temp.getNext());
                }
                else
                p = p.getNext();
            }
        }
        return first;
    }
}
