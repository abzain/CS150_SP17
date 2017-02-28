import java.lang.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorkerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WorkerTest
{
    /**
     * Default constructor for test class WorkerTest
     */
    public WorkerTest()
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
    
    /**
     * test getFirstName
     */
    @Test
    public void testGetFirstName()
    {
        Worker test1 = new Worker( "Zainab", "Hussein", 4 );
        
        //declare and check
        assertEquals( test1.getFirstName(), "Zainab" );
        
        Worker test2 = new Worker( "Nillah", "Hussein", 4 );
        assertEquals( test2.getFirstName(), "Nillah" );
        
        Worker test3 = new Worker( "Yusuf", "Hussein", 4 );
        assertEquals( test3.getFirstName(), "Yusuf" );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
    /**
     * test getLastName
     */
    @Test
    public void testGetLastName()
    {
        Worker test1 = new Worker( "Zainab", "Hussein", 4 );
        
        //declare and check
        assertEquals( test1.getLastName(), "Hussein" );
        
        Worker test2 = new Worker( "Zainab", "Mursal", 4 );
        assertEquals( test2.getLastName(), "Mursal" );
        
        Worker test3 = new Worker( "Zainab", "Fadamullah", 4 );
        assertEquals( test3.getLastName(), "Fadamullah" );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
    /**
     * test getId
     */
    @Test
    public void testGetId()
    {
        Worker test1 = new Worker( "Zainab", "Hussein", 4 );
        
        //declare and check
        assertEquals( test1.getId(), 4 );
        
        Worker test2 = new Worker( "Zainab", "Hussein", 8005L );
        assertEquals( test2.getId(), 8005L );
        
        Worker test3 = new Worker( "Zainab", "Hussein", 325L );
        assertEquals( test3.getId(), 325L );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
}
