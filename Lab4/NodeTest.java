import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    Integer mydata;
    Node<Integer> mynext;
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest( )
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
     * test node is created
     */
    @Test
    public void testNode()
    {
        Node<Integer> node = new Node<Integer>( mydata, mynext);
        assertEquals( node.data, mydata );
        assertEquals( node.next, mynext );
    }
}
