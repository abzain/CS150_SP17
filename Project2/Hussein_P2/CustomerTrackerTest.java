

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTrackerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTrackerTest
{
    /**
     * Default constructor for test class CustomerTrackerTest
     */
    public CustomerTrackerTest()
    {
    }
    
    //depreciated thus Math.abs(expected-actual)<delta
    private static final double delta = 1e-10;
    
    @Test
    public void testgetIsArrive()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 0.0, 0 );
        
        //check they match
        assertEquals( test.getIsArrive(), 0.0, delta );
    }
    
    @Test
    public void testsetIsArrive()
    {
        // instance of class under test
        CustomerTracker test = new CustomerTracker( 0.0, 0 );
        
        // compare instances
        double at = 15.0;
        test.setIsArrive( at );
        
        //check they match
        assertEquals( test.getIsArrive(), at, delta );
    }
    
    @Test
    public void testgetIsWait()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 0.0, 0 );
        
        //compare instances
        double wt = 5.0;
        test.setIsWait( wt );
        
        //check they match
        assertEquals( test.getIsWait(), wt, delta );
    }
    
    @Test
    public void testgetIsServe()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 0.0, 0 );
        
        //compare instances
        double st = 2.0;
        test.setIsServe( st );
        
        //check they match
        assertEquals( test.getIsServe(), st, delta );
    }
    
    @Test
    public void testgetIsDepart()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 0.0, 0 );
        
        //compare instances
        double dt = 7.0;
        test.setIsDepart( dt );
        
        //check they match
        assertEquals( test.getIsDepart(), dt, delta );
    }
    
    @Test
    public void testgetCustId()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 4.0, 5 );
        
        //check they match
        assertEquals( test.getCustId(), 5 );
    }
    
    @Test
    public void testtoString()
    {
        //instance of class under test
        CustomerTracker test = new CustomerTracker( 4.0, 5 );
        
        //compare instances
        String expected =  "Customer 5 arrives at 4.0 mins, waits for 0.0 mins, is served for 0.0 mins, and departs at 0.0 mins,";
        assertEquals( test.toString(), expected );
        
        double wt = 0.5;
        double st = 1.0;
        double dt = 7.0;
        test.setIsWait( wt );
        test.setIsServe( st );
        test.setIsDepart( dt );
        
        String nowExpected = "Customer 5 arrives at 4.0 mins, waits for 0.5 mins, is served for 1.0 mins, and departs at 7.0 mins,";
        assertEquals( test.toString(), nowExpected );
        
    }
}
