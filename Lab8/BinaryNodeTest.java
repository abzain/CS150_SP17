import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BinaryNodeTest.
 *
 * @author  Zainab Hussein
 * @version  3-21-2017
 */
public class BinaryNodeTest
{
    /**
     * Default constructor for test class BinaryNodeTest
     */
    public BinaryNodeTest()
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
    
    BinaryNode<Integer> myLeft;
    BinaryNode<Integer> myRight;
    Integer myElement;
    @Test
    public void testBinaryNode()
    {
        BinaryNode<Integer> node = new BinaryNode<Integer>( myElement, 
                                        myLeft, myRight );
        assertEquals( node.element, myElement );
        assertEquals( node.left, myLeft );
        assertEquals( node.right, myRight );
    }
}
