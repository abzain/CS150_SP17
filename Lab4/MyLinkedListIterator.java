import java.util.*;

/**
 * Class MyLinkedListIterator implements iterator interface. 
 * 
 * @author Zainab Hussein
 * @version 2/14/2017
 */
public class MyLinkedListIterator<Any> implements Iterator<Any>
{
    // instance variables - replace the example below with your own
    private Node<Any> nextNode;
    private Node<Any> head;

    /**
     * Constructor for objects of class MyLinkedListIterator
     */
    public MyLinkedListIterator()
    {
        // initialise instance variables
        nextNode = head;    //first node to be iterated is head
    }
    
    /**
     * implementation of iterator interface method hasNext() for iterator
     * returns - true if the iteration has more elements
     */
    public boolean hasNext()
    {
        if( nextNode != null ){
            return true;
        }
        return false;
    }
    
     /**
     * implementation of iterator interface method next() for iterator
     * returns - next element in the iteration
     */
    public Any next()
    {
        if( !hasNext() ){   //if empty, no elements to be iterated through
            throw new NoSuchElementException();
        }
        else{   //assign data in head to val, then move to next node
            Any val = nextNode.data;
            nextNode = nextNode.next;
            return val;
        }
    }
}
