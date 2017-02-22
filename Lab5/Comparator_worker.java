import java.util.*;
import java.lang.*;

/**
 * Class Compare_worker - implements Comparable to compares 
 * workers using their ID's
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
class Comparator_worker implements Comparator<Worker>
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Compare_worker
     */
    public Comparator_worker()
    {
        // initialise instance variables
    }

    /**
     * compare method to make Worker class comparable
     * 
     * @param - id
     * @return ordering of workers by id numbers
     */
    public int compare( Worker w1, Worker w2 )
    {
        /** 
         * long being a primitive can't be dereferenced
         * so convert to Long object
         */
        
        Long w1_val = new Long( w1.getId() );
        Long w2_val = new Long( w2.getId() );
        
        return w1_val.compareTo( w2_val );
    }
}
