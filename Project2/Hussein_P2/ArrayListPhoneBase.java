import java.util.ArrayList;
import java.util.*;
import java.lang.*;
//ArrayListPhoneBase class
//
//CONSTRUCTION - with no arguments
//
//*****************PUBLIC OPERATIONS***********************
//boolean add( x )      --> insert x
//long select( k )      --> selects item at index k
//String toString()     --> represent as string
//*********************************************************
/**
 * Implementing PhoneBase interface using an ArrayList
 */
public class ArrayListPhoneBase implements PhoneBase
{
    // instance variables - replace the example below with your own
    private ArrayList<Long> phoneNumList = new ArrayList<Long>();;

    /**
     * Constructor for objects of class ArrayListPhoneBase
     */
    public ArrayListPhoneBase()
    {
        // initialise instance variables
        phoneNumList = null;
    }

    /**
     * Implementation of abstract method adds a phone number 
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n )
    {
        //check no duplicates - boolean !contains(Object 0) : no specified element found
        //         if( !phoneNumList.contains(n) ){
        //             //add element - simple add(E e)
        //             phoneNumList.add( n );
        //             //sort added input
        //             Collections.sort( phoneNumList );
        //             return true;
        //         }
        //         else{
        //             return false;
        //         }
        Long N = new Long ( n );//               N.valueOf(n);
        int i = Collections.binarySearch( phoneNumList, n ); 
        phoneNumList.add( (-i+1), n );
        return true;

    }

    /**
     * Implementation of abstract method select the kth smallest phone number
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k )
    {
        return phoneNumList.get( k );
    }

    /**
     * return an integer array whose entries are equal to the arraylist - 
     * ArrayList converted to array 
     */
    public Long[] getArray() 
    {
        //create a list of integer array wih size of the arraylist
        Long list[] = new Long[phoneNumList.size()];
        return list = phoneNumList.toArray(list);
    }

}
