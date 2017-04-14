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
//long[] toArray()      --> converts arraylist to array
//long get(k)           --> returns item at index k
//*********************************************************
/**
 * Implementing PhoneBase interface using an ArrayList
 */
public class ArrayListPhoneBase implements PhoneBase
{
    // instance variables - replace the example below with your own
    private ArrayList<Long> phoneNumList;
    /**
     * Constructor for objects of class ArrayListPhoneBase
     */
    public ArrayListPhoneBase()
    {
        // initialise instance variables
        phoneNumList = new ArrayList<Long>();
    }

    /**
     * Implementation of abstract method adds a phone number 
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n )
    {
        //check no duplicates - boolean !contains(Object 0) : no specified element found
        if( !phoneNumList.contains(n) ){
            //add element - simple add(E e)
            phoneNumList.add( n );
            //sort added input
            Collections.sort( phoneNumList );
        }
        return true;
    }

    /**
     * Implementation of abstract method select the kth smallest phone number
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k )
    {
        return phoneNumList.get( k -1);
    }

    /**
     * return an integer array whose entries are equal to the arraylist - 
     * ArrayList converted to array 
     */
    public long[] getArray() 
    {
        //create a list of long array wih size of the arraylist
        long result[] = new long[phoneNumList.size()];
        //convert Long[] to long[]
        result = phoneNumList.stream().mapToLong(l -> l).toArray();
        return result;
    }

    /**
     * get method to test add methods in unitTest
     */
    public long get( int index )
    {
        return this.phoneNumList.get( index );
    }
}
