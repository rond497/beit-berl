import java.util.*;
public class ListOp
{
    public static Scanner reader = new Scanner(System.in);

    public static void printList(NodeInt first)
    {
        NodeInt p = first;
        while ( p != null)
        {
                System.out.print(p.getValue() + " --> ");
                p = p.getNext();
        }
        System.out.println("null");
    }

    public static boolean inList(NodeInt first, int x)
    {
        NodeInt p = first;
        while ( p != null)
        {
            if ( p.getValue() == x )
                return true;
            else
                p = p.getNext();
        }
        return false;
    }
    // Inserts 'x' into the list, right after 'p'
    public static NodeInt insert(NodeInt p, int x)
    {
        NodeInt q = new NodeInt(x);
        q.setNext(p.getNext());
        p.setNext(q);
        return q;
    }

    public static NodeInt readList()
    {
        int n = reader.nextInt();  	// n>0
        NodeInt first = new NodeInt(reader.nextInt());
        NodeInt last = first;
        for (int i=2; i<=n; i++)
        {
            last = insert(last, reader.nextInt());
        }
        return first;
	 }     

}

