import java.util.*;

/**
 * Class WorkerList - extends abstract class SortedList and implements 
 * abstract method printData. 
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class WorkerList<Any> extends SortedList<Any>
{
    // instance variables - replace the example below with your own
    //Worker employee = new Worker(); ??
    /**
     * Constructor for objects of class WorkerList
     */
    public WorkerList()
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
