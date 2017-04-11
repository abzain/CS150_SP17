
/**
 * Class Node is a simple node class to be used by the 
 * SoretdLinkedList class
 * 
 * @author Zainab Hussein 
 * @version 4/4/2017
 */
public class SoretdLinkedListNode<E>
{
    // instance variables - replace the example below with your own
    private E data;
    private SoretdLinkedListNode<E> next;
    private SoretdLinkedListNode<E> same;

    /**
     * Constructor for objects of class Node
     */
    public SoretdLinkedListNode( E data, SoretdLinkedListNode<E> next, SoretdLinkedListNode<E> same )
    {
        // initialise instance variables
        this.data = data;
        this.next = next;
        this.same = same;
    }

    public E getData()
    {
        return data;
    }
    
    public void setData( E myData ){
        this.data = myData;
    }
    
    public SoretdLinkedListNode<E> getNext()
    {
        return next;
    }
    
    public void setNext( SoretdLinkedListNode<E> myNext ){
        this.next = myNext;
    }
    
    public SoretdLinkedListNode<E> getSame()
    {
        return same;
    }
    
    public void setSame( SoretdLinkedListNode<E> mySame ){
        this.same = mySame;
    }
}
