import java.lang.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  Zainab Hussein
 * @version 3-8-2017
 */
public class CustomerTest
{
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsArrive(), 5.1, delta );
        
        Customer test2 = new Customer( 6.3, 16.8 );
        assertEquals( test2.getIsArrive(), 6.3, delta );
        
        Customer test3 = new Customer( 1.1, 115.9 );
        assertEquals( test3.getIsArrive(), 1.1, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
     /**
     * test getIsJoinQueue()
     */
    @Test
    public void tesGetIsJoinQueue()
    {
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsJoinQueue(), 5.1, delta );
        
        Customer test2 = new Customer( 6.3, 16.8 );
        assertEquals( test2.getIsJoinQueue(), 6.3, delta );
        
        Customer test3 = new Customer( 1.1, 115.9 );
        assertEquals( test3.getIsJoinQueue(), 1.1, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
     /**
     * test getIsWait()
     */
    @Test
    public void tesGetIsWait()
    {
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsWait(), 6.6, delta );
        
        Customer test2 = new Customer( 6.3, 16.8 );
        assertEquals( test2.getIsWait(), 7.8, delta );
        
        Customer test3 = new Customer( 1.1, 115.9 );
        assertEquals( test3.getIsWait(), 2.6, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
     /**
     * test getIsServed()
     */
    @Test
    public void tesGetIsServed()
    {
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsServed(), 11.7, delta );
        
        Customer test2 = new Customer( 6.3, 16.8 );
        assertEquals( test2.getIsServed(), 14.1, delta );
        
        Customer test3 = new Customer( 1.1, 115.9 );
        assertEquals( test3.getIsServed(), 3.7, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
     /**
     * test getIsDepart()
     */
    @Test
    public void tesGetIsDepart()
    {
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsDepart(), 23.4, delta );
        
        Customer test2 = new Customer( 6.3, 16.8 );
        assertEquals( test2.getIsDepart(), 28.2, delta );
        
        Customer test3 = new Customer( 1.1, 115.9 );
        assertEquals( test3.getIsDepart(), 7.4, delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
     /**
     * test getIsTurnedAway()
     */
    @Test
    public void tesGetIsTurnedAway()
    {
        Customer test1 = new Customer( 5.1, 15.9 );
        assertEquals( test1.getIsTurnedAway(), 0, delta );
        
        Customer test2 = new Customer( 26.3, 16.8 );
        assertEquals( test2.getIsTurnedAway(), 26.3, delta );
        
        Customer test3 = new Customer( 17.1, 15.9 );
        assertEquals( test3.getIsTurnedAway(), 17.1,delta );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
}
