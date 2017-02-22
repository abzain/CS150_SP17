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
        Worker test = new Worker();
        String firstName;
        
        //declare and check
        firstName = "Zainab";
        test.setFirstName( "Zainab" );
        assertEquals( test.getFirstName(), firstName );
        
        firstName = "Nillah";
        test.setFirstName( "Nillah" );
        assertEquals( test.getFirstName(), firstName );
        
        firstName = "Yusuf";
        test.setFirstName( "Yusuf" );
        assertEquals( test.getFirstName(), firstName );
    }
    
    /**
     * test getLastName
     */
    @Test
    public void testGetLastName()
    {
        Worker test = new Worker();
        String lastName;
        
        //declare and check
        lastName = "Hussein";
        test.setLastName( "Hussein" );
        assertEquals( test.getLastName(), lastName );
        
        lastName = "Mursal";
        test.setLastName( "Mursal" );
        assertEquals( test.getLastName(), lastName );
        
        lastName = "Fadamullah";
        test.setLastName( "Fadamullah" );
        assertEquals( test.getLastName(), lastName );
    }
    
    /**
     * test getId
     */
    @Test
    public void testGetId()
    {
        Worker test = new Worker();
        long Id;
        
        //declare and check
        Id = -664L;
        test.setId( -664L );
        assertEquals( test.getId(), Id );
        
        Id = 8005L;
        test.setId( 8005L );
        assertEquals( test.getId(), Id );
        
        Id = 325L;
        test.setId( 325L );
        assertEquals( test.getId(), Id );
    }
}
