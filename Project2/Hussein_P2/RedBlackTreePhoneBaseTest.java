

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RedBlackTreePhoneBaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RedBlackTreePhoneBaseTest
{
    /**
     * Default constructor for test class RedBlackTreePhoneBaseTest
     */
    public RedBlackTreePhoneBaseTest()
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
        //test with Long values
        RedBlackTreePhoneBase test1 = new RedBlackTreePhoneBase();
        test1.add( 98L );
        test1.add( 76L );
        test1.add( 89L );
        test1.printTree();  //check correctly print to terminal
        
    }

    @Test
    public void testSelect()
    {
         //test with Long values
        RedBlackTreePhoneBase test1 = new RedBlackTreePhoneBase();
        test1.add( 98L );
        test1.add( 76L );
        test1.add( 89L );
        test1.printTree();
        //compare instances
        long toCheck = test1.select( 1 );
        test1.printTree();
        long expected = 76L;
        //check
        assertEquals( toCheck, expected );     
        
    }
}


