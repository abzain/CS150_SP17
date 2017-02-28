import java.util.*;

/**
 * Class ContactList - extends abstract class SortedList and implements 
 * abstract method printData. 
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class ContactList extends SortedList<Contact>
{
    // instance variables - replace the example below with your ow
    /**
     * Constructor for objects of class ContactList
     */
    public ContactList( )
    {
        // initialise instance variables
    }

    @Override
    public void printData()
    {

        for( int i=0; i<container.size(); i++ ){
            System.out.println( "firstname: " + container.get(i).getFirstName()); 
            System.out.println( "lastname: " + container.get(i).getLastName() );
            System.out.println( "phone_number: " + container.get(i).getPhoneNo() );
            System.out.println( "email: " + container.get(i).getEmail() );
            System.out.println( "  ");
            
        }

    }
    
    /**
     * return an integer array whose entries are equal to the arraylist - 
     * ArrayList converted to array 
     */
    public Contact[] getArray() 
    {
        //create a list of integer array wih size of the arraylist
        Contact list[] = new Contact[container.size()];
        return list = container.toArray(list);
    }
    
    /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        for( int i=0; i<container.size(); i++ ){
            return "(" + container.get(i).getFirstName() + "," 
                       + container.get(i).getLastName() + "," 
                       + container.get(i).getPhoneNo() + "," 
                       + container.get(i).getEmail() + "," 
                       + " " + ")";
        }
        return "Nada";
    }
    
    /**
     * return the value at the given index
     */
    public Contact getValue( int index ) 
    {
        //create a list of integer array wih size of the abstractlist
        return container.get( index );
    }
}
