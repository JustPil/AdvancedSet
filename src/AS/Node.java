package AS;

public class Node
{
    private int data;
    private Node next;

    /**
     * Constructor sets a node's data to the value passed in, and the next node to null.
     * @param data The value to be held by the node.
     */
    public Node(int data)
    {
        this.data = data;
        next = null;
    }

    /**
     * setData Sets the node's data to the value passed in.
     * @param data The data to be held bu the node.
     */
    public void setData(int data)
    {
        this.data = data;
    }

    /**
     * getData Returns the data held by the node.
     * @return The data held by the node.
     */
    public int getData()
    {
        return data;
    }

    /**
     * setNext Sets the next node in the linked list to the node passed in.
     * @param next The next node in the linked list.
     */
    public void setNext(Node next)
    {
        this.next = next;
    }

    /**
     * getNext Returns the next node in the linked list.
     * @return The next node in the linked list.
     */
    public Node getNext()
    {
        return next;
    }
}