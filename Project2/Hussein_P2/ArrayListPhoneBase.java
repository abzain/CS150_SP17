import java.util.ArrayList;
import java.util.*;
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
    private ArrayList<Long> phoneNumList;

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
        if( !phoneNumList.contains(n) ){
            //add element - simple add(E e)
            phoneNumList.add( n );
            //sort added input
            Collections.sort( phoneNumList );
            return true;
        }
        else{
            return false;
        }
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
}
