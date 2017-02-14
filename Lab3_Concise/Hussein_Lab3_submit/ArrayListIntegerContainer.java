import java.util.*;

/**
 * Class ArrayListIntegerContainer IS-A IntegerContainer, so inherits methods
 * and parameters from this baseclass.
 * 
 * @author Zainab Hussein
 * @version 2/7/2017
 */
public class ArrayListIntegerContainer extends IntegerContainer
{
    // instance variables - replace the example below with your own

    /**
     * Default Constructor for objects of class ArrayListIntegerContainer
     */
    public ArrayListIntegerContainer()
    {
        // initialise instance variables
        super();
        data = new ArrayList<Integer>();
    }

    /**
     * Copy Constructor for objects of class ArrayListIntegerContainer
     */
    public ArrayListIntegerContainer( ArrayListIntegerContainer obj )
    {
        // initialise instance variables
        super( obj );
        this.data = obj.data;
    }
    
}
