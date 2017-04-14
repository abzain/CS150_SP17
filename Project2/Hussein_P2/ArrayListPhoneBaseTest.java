

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArrayListPhoneBaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArrayListPhoneBaseTest
{
    /**
     * Default constructor for test class ArrayListPhoneBaseTest
     */
    public ArrayListPhoneBaseTest()
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
        ArrayListPhoneBase test = new ArrayListPhoneBase();
        Long a = new Long( 57L );
        Long b = new Long( 68L );
        Long c = new Long( 36L );
        
        long A = 57L;
        long B = 68L;
        long C = 36L;
        
        test.add( A );
        test.add( B );
        test.add( C );
        //compare instances
        Long[] testList = test.getArray();
        Long[] expList = {c, a, b};
        //check they are equal
        assertEquals( testList, expList );
    }

    @Test
    public void testSelect()
    {
        ArrayListPhoneBase test = new ArrayListPhoneBase();
        test.add( 57L );
        test.add( 68L );
        test.add( 36L );
        //test.select( 2 );
        //compare instances
        Long testLong = test.select( 2 );
        Long expLong = 68L;
        //check they are equal
        assertEquals( testLong, expLong );
    }
}


