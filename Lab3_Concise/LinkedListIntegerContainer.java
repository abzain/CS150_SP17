import java.util.*;

/**
 * Class LinkedListIntegerContainer IS-A IntegerContainer, so inherits methods
 * and parameters from this baseclass.
 * 
 * @author Zainab Hussein
 * @version 2/7/2017
 */
public class LinkedListIntegerContainer extends IntegerContainer
{
    // instance variables - replace the example below with your own

    /**
     * Default Constructor for objects of class LinkedListIntegerContainer
     */
    public LinkedListIntegerContainer()
    {
        // initialise instance variables
        super();
        data = new LinkedList<Integer>();
    }

    /**
     * Copy Constructor for objects of class LinkedListIntegerContainer
     */
    public LinkedListIntegerContainer( LinkedListIntegerContainer obj )
    {
        // initialise instance variables
        super( obj );
        this.data = obj.data;
    }
    
}

