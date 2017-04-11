import java.util.*;
/**
 * SoretdLinkedList class - implements a kind of singly linked linkedlist
 * where elements with equal value are inserted to another pointer.
 * 
 * @author Zainab Hussein
 * @version 4-4-2017
 */
public class SoretdLinkedList<E extends Comparable<E>>
{
    // instance variables - replace the example below with your own
    private SoretdLinkedListNode<E> head;
    private SoretdLinkedListNode<E> temp;

    /**
     * Constructor for objects of class SoretdLinkedList
     */
    public SoretdLinkedList()
    {
        // initialise instance variables
        head = null;
    }

    /**
     * add method - if input exists, should be added to the 
     * same linkedList,
     * otherwise, added to correct position in in array
     */
    public void add( E e )
    {
         if( head == null ){
            head = new SoretdLinkedListNode<E>( e, head, null );
        }
        else{
            int compareResult = e.compareTo(head.getData());
            if( compareResult == 0 ){ //same as head data
                head.setSame(new SoretdLinkedListNode<E>( e, head, head ));
            }
            else{
                //added to front
                temp = head;
                head.setNext( temp );
                head = new SoretdLinkedListNode<E>( e, head, null );
            }
        }
    }
    
    /**
     * counts number of repeats of an element
     */
    public int count( E e )
    {
        //repeated elements are in same linkedlist
        SoretdLinkedListNode<E> first = head;
        SoretdLinkedListNode<E> after = head.getNext();
        int cnt = 0;
        if( head == null ){
            cnt = 0;
        }
        else{
           while( head.getSame() != null && head.getSame().getData() == e ){ //equal in head node
               first = first.getSame();
               cnt += 1;
           }
           while( after.getSame() != null && after.getSame().getData() == e){ //equal in other nodes
               cnt += 1;
           }
           cnt = cnt;
        }
        return cnt;
    }
    
    /**
     * method remove - remove element from list, if repeated
     * removes the first on the equal linkedlist
     */
    public boolean remove( E e )
    {
        if( head == null ){
            return false;
        }
        else{
            if( head.getData() == e && head.getSame() == null ){
                head = null;
                return true;
            }
            else if( head.getNext().getData() == e && head.getNext().getSame() == null){
                SoretdLinkedListNode<E> nextNode = head.getNext(); 
                nextNode = null;
                return true;
            }
            else if( head.getSame() != null && head.getSame().getData() == e ){
                SoretdLinkedListNode<E> firstSame = head.getSame();
                firstSame = null;
                return true;
            }
            else if(head.getNext().getSame() != null && head.getNext().getSame().getData() == e ){
                SoretdLinkedListNode<E> otherSame = head.getNext().getSame();
                otherSame = null;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns a string representation
     */
    public String toString()
    {
        return "(" + head.getData() + "-" + count(head.getData()) +
                    " " + head.getNext().getData() + "-" + count(head.getNext().getData())
                    + " " + ")";
    }
}