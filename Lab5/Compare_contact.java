import java.util.*;
import java.lang.*;

/**
 * Class Compare_contact - implements Comparable to compares contacts alphabetically by 
 * last name then first name
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
class Compare_contact implements Comparator<Contact>
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Compare_contact
     */
    public Compare_contact()
    {
        // initialise instance variables

    }

    /**
     * compare method to make Contact class comparable
     * 
     * @param - lastName, firstName
     * @return ordering of contacts by last and first name
     */
    public int compare( Contact c1, Contact c2 )
    {
        if( c1.getLastName().equals( c2.getLastName() ) ){
             return c1.getFirstName().compareTo( c2.getFirstName() );
        }
        else{
            return c1.getLastName().compareTo( c2.getLastName() );
        }
    }
}
