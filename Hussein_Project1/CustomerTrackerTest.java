import java.lang.*;

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

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    //depreciated thus Math.abs(expected-actual)<delta
    private static final double delta = 1e-10;
   
    /**
     * test getIsArrive()
     */
    @Test
    public void tesGetIsArrive()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1,5,15, 5.9, 0.3  );
        assertEquals( test1.getIsArrive(), 5.1, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsWait()
     */
    @Test
    public void tesGetIsWait()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1,5,15, 5.9, 0.3  );
        assertEquals( test1.getIsWait(), -11.0, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( "  " );
    }

    /**
     * test getStartServed()
     */
    @Test
    public void testGetStartServed()
    {
       CustomerTracker test1 = new CustomerTracker( 5.1,5,15, 5.9, 0.3  );
        assertEquals( test1.getStartServed(), 5.9, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsDepart()
     */
    @Test
    public void tesGetIsDepart()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1,5,15, 5.9, 0.3  );
        assertEquals( test1.getIsDepart(), 11.3, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsTurnedAway()
     */
    @Test
    public void tesGetIsTurnedAway()
    {
       CustomerTracker test1 = new CustomerTracker( 5.1,5,15, 5.9, 0.3  );
        assertEquals( test1.getIsTurnedAway(), 0, delta );
        
       CustomerTracker test2 = new CustomerTracker( 5.1,5,45, 5.9, 0.3  );
        assertEquals( test2.getIsTurnedAway(), 5.1, delta ); 

        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );

        System.out.println( "  " );
    }
}
