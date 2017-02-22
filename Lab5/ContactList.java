import java.util.*;

/**
 * Class ContactList - extends abstract class SortedList and implements 
 * abstract method printData. 
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class ContactList<Any> extends SortedList<Any>
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class ContactList
     */
    public ContactList()
    {
        // initialise instance variables
    }

    public Any printData()
    {
        for( Any val : container ){
            System.out.println( val );
            return val;
        }
        return null;
    }
}
