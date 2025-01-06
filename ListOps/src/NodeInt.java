/* The class NodeInt **/    
public class NodeInt
{
    private int value;                  // Node value (int)
    private NodeInt next;               // next Node

    // Constructor  - returns a Node with 'value' as value and without a successor Node
    public NodeInt(int value)
    {
        this.value = value;
        this.next = null;
    }

    // Constructor  - returns a Node with 'value' as value and its successor is 'next'
    public NodeInt(int value, NodeInt next)
    {
        this.value = value;
        this.next = next;
    }
    
    /* Returns the Node value **/    
    public int getValue()
    {
        return  value;
    }

    /* Returns the Node next Node **/        
    public NodeInt getNext()
    {   
        return next;
    }
    
    /* Return true if the current Node has a successor **/
    public boolean hasNext()
    {
         return (next != null);
    }    

    /* Set the value of the current Node to be 'value' **/
    public void setValue(int value)
    {
         this.value = value;
    }
    
    /* Set the next value to be 'next' **/
    public void setNext(NodeInt  next)
    {
         this.next = next;
    }

    /* Returns a string that describes the Node (and its successors) **/
    public String toString()
    {
            return value + " --> " + next;
    }
}
