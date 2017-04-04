

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeapTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HeapTest
{
    /**
     * Default constructor for test class HeapTest
     */
    public HeapTest()
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
    public void testInsert()
    {
        Heap<String> h = new Heap<String>();
        h.insert( "Nini" );
        h.insert( "Nani" );
        h.insert( "Kwanini" );
        h.insert( "Sababu" );
        
        //check inserted in right order
        h.printInOrder();
    }
}
