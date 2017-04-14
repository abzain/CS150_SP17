

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HashSetPhoneBaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HashSetPhoneBaseTest
{
    /**
     * Default constructor for test class HashSetPhoneBaseTest
     */
    public HashSetPhoneBaseTest()
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

    @Test
    public void testAdd()
    {
        HashSetPhoneBase test1 = new HashSetPhoneBase();
        test1.add( 98L );
        test1.add( 76L );
        test1.add( 89L );
        String s = test1.toString();      //check correctly print to terminal
        System.out.println( test1.toString() );
        //String expec = "Array of phone numbers in hashset: 987689";
        //assertEquals( s , expec );
    }

    @Test
    public void testSelect()
    {
        HashSetPhoneBase test1 = new HashSetPhoneBase();
        test1.add( 98L );
        test1.add( 76L );
        test1.add( 89L );
        //compare instances
        long toCheck = test1.select( 2 );
        long expected = 98L;
        //check
        assertEquals( toCheck, expected );  
    }
}


