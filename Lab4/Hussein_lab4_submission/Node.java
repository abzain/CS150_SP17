
/**
 * Class Node is a simple node class to be used by the MyLinkedList
 * and MyLinkedListIterator classes
 * 
 * @author Zainab Hussein 
 * @version 2/14/2017
 */
public class Node<Any>
{
    // instance variables - replace the example below with your own
    public Any data;
    public Node<Any> next;

    /**
     * Constructor for objects of class Node
     */
    public Node( Any data, Node<Any> next )
    {
        // initialise instance variables
        this.data = data;
        this.next = next;
    }

}
