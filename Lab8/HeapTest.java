

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
        h.insert( "Nani" );
        h.insert( "Kwanini" );
        h.insert( "Nini" );
        h.insert( "Sababu" );
        
        //check inserted strings in right order
        h.printInOrder();
        h.printPreOrder();
        h.printPostOrder();
        
        Heap<Integer> k = new Heap<Integer>();
        k.insert( 58 );
        k.insert( 45 );
        k.insert( 63 );
        k.insert( 98 );
        
        //check inserted integers in right order
        k.printInOrder();
        k.printPreOrder();
        k.printPostOrder();
    }
    
    @Test
    public void testRemoveMin()
    {
        Heap<String> m = new Heap<String>();
        m.insert( "Nani" );
        m.insert( "Kwanini" );
        m.insert( "Nini" );
        m.insert( "Sababu" );
        
        //remove and check strings
        m.removeMin();
        m.printInOrder();
        m.removeMin();
        m.printInOrder();
        m.removeMin();
        m.printInOrder();
        
        Heap<Integer> n = new Heap<Integer>();
        n.insert( 58 );
        n.insert( 45 );
        n.insert( 63 );
        
        //remove and check integers
        n.removeMin();
        n.printInOrder();
        n.removeMin();
        n.printInOrder();
        n.removeMin();
        n.printInOrder();
    }
}
