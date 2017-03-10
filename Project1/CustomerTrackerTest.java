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
     * double u = Math.random();
     * System.out.println(  -( Math.log( u )/0.3 )+ " serviceInterval" );
     * serviceInterval = 8.691066108858035 (used for testing here)
     * custServeTime = arrive time + 8.691066108858035 
     */
   
    /**
     * test getIsArrive()
     */
    @Test
    public void tesGetIsArrive()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1, 15.9, 0.3 );
        assertEquals( test1.getIsArrive(), 5.1, delta );

        CustomerTracker test2 = new CustomerTracker( 6.3, 16.8, 0.3 );
        assertEquals( test2.getIsArrive(), 6.3, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsWait()
     */
    @Test
    public void tesGetIsWait()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1, 15.9, 0.3 );
        assertEquals( test1.getIsWait(), 0, delta );

        CustomerTracker test2 = new CustomerTracker( 6.3, 16.8, 0.3 );
        assertEquals( test2.getIsWait(), 8.69, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsServed()
     */
    @Test
    public void tesGetIsServed()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1, 15.9, 0.3 );
        assertEquals( test1.getIsServed(), 5.1557, delta );

        CustomerTracker test2 = new CustomerTracker( 6.3, 16.8, 0.3 );
        assertEquals( test2.getIsServed(), 14.99, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsDepart()
     */
    @Test
    public void tesGetIsDepart()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1, 15.9, 0.3 );
        assertEquals( test1.getIsDepart(), 13.79, delta );

        CustomerTracker test2 = new CustomerTracker( 6.3, 16.8, 0.3 );
        assertEquals( test2.getIsDepart(), 23.68, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( "  " );
    }

    /**
     * test getIsTurnedAway()
     */
    @Test
    public void tesGetIsTurnedAway()
    {
        CustomerTracker test1 = new CustomerTracker( 5.1, 15.9, 0.3 );
        assertEquals( test1.getIsTurnedAway(), 0, delta );

        CustomerTracker test2 = new CustomerTracker( 26.3, 16.8, 0.3 );
        assertEquals( test2.getIsTurnedAway(), 26.3, delta );

        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );

        System.out.println( "  " );
    }
}
