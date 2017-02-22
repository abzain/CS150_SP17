import java.util.*;

/**
 * Class MyLinkedList is a singly-linked, non-circular list implementing the iterable interface.
 * 
 * @author Zainab Hussein
 * @version 2/14/2017
 * https://docs.google.com/document/u/0/d/1rlkqvSc-mFH37dAqpi4qniqkuZgnDaCFcqNeIIxRUFI/pub
 */
public class MyLinkedList<Any> implements Iterable<Any>
{
    // instance variables - replace the example below with your own
    private Node<Any> head;
    private Node<Any> tail;
    private Node<Any> temp;
    Any notFound; 
    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        // initialise instance variables
        head = null;
        tail = null;
        temp = null;

    }

    /**
     * iterator method - to implement iterable interface. 
     * Returns - instance of MyLinkedListIterator initialized 
     */
    public Iterator<Any> iterator()
    {
        return new MyLinkedListIterator<Any>();
    }

    /**
     * addFirst method - adds value to front of list
     */
    public void addFirst(Any value)
    {
        if( head == null ){
            head = new Node<Any>( value, head );
        }
        else{
            //set old head to head.next
            temp = head;
            head = new Node<Any>( value, head );
            head.next = temp;
        }
    }

    /**
     * addEnd method - adds value to end of list
     * Boundary cases: empty - value will be first item (head), 
     * not empty - value will replace the null at the end and 
     * it's next set to null
     */
    public void addEnd(Any value)
    {
        if( (head == null) && (tail == null) ){
            head = new Node<Any>( value, head );
        }
        else{   //either one or more nodes
            //to add new data, need to add from the front (head) and recurse through
            //to the end dummy node
            temp = head;
            while( temp.next != null ){ //just till tail node
                temp = temp.next;   //search for tail
            }
            //create a dummy node after the tail
            temp.next = new Node<Any>( value, null );   //set node after tail to null
        }
    }

    /**
     * get method - given as index, returns element
     */
    public Any getValue( int index )
    {
        //specify usable index
        if( index < 0  || head == null ){
            return null;
        }
        else{
            //have head as reference since position known
            if ( index == 0 ){
                return head.data;
            }
            else{
                //use other variable for head to traverse nodes
                Node<Any> first = head;
                //couter to track index
                int cnt = 0;
                while( cnt < index+1 ){
                    first = first.next; //step to next node
                    if( first != null ){    //just reach tail
                        return first.data;
                    }
                }
                return notFound;    //element not found
            }
        }
    }
    
     /**
     * getArray method
     */
    public Integer[] getArray() 
    {
        int size;
        Node<Any> i = head;
        
        ArrayList<Any> data_store = new ArrayList<Any>(); 
        while(  i != tail ){
            data_store.add( head.data ); 
            i = head.next;
        }
        
        Integer[] list = new Integer[ data_store.size() ];
        return list = data_store.toArray( list );
    }  
}