

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
        assertEquals( node.getElement(), myElement );
        assertEquals( node.getLeft(), myLeft );
        assertEquals( node.getRight(), myRight );
    }
    
    @Test
    public void testSize()
    {
        BinaryNode<Integer> node0 = new BinaryNode<Integer>( 2, null,
                                        null ); 
        BinaryNode<Integer> node1 = new BinaryNode<Integer>( 5, null,
                                        null );
        BinaryNode<Integer> node2 = new BinaryNode<Integer>( 9, node0, 
                                        node1 );
        BinaryNode<Integer> node3 = new BinaryNode<Integer>( 1, node2, 
                                        node1 );
         
        assertEquals( node0.size( node0 ), 1 );
        assertEquals( node1.size( node1 ), 1 );
        assertEquals( node2.size( node2 ), 3 );
        assertEquals( node3.size( node3 ), 5 );
    }
    
    @Test
    public void testGetElement()
    {
        BinaryNode<Integer> node0 = new BinaryNode<Integer>( 2, null,
                                        null ); 
        BinaryNode<Integer> node1 = new BinaryNode<Integer>( 5, null,
                                        null );
        BinaryNode<Integer> node2 = new BinaryNode<Integer>( 9, node0, 
                                        node1 );
        BinaryNode<Integer> node3 = new BinaryNode<Integer>( 1, node2, 
                                        node1 );
         
        assertEquals( (Integer)node0.getElement(), (Integer)2 );
        assertEquals( (Integer)node1.getElement(), (Integer)5 );
        assertEquals( (Integer)node2.getElement(), (Integer)9 );
        assertEquals( (Integer)node3.getElement(), (Integer)1 );
    }
    
     @Test
    public void testGetRight()
    {
        BinaryNode<Integer> node0 = new BinaryNode<Integer>( 2, null,
                                        null ); 
        BinaryNode<Integer> node1 = new BinaryNode<Integer>( 5, null,
                                        null );
        BinaryNode<Integer> node2 = new BinaryNode<Integer>( 9, node0, 
                                        node1 );
        BinaryNode<Integer> node3 = new BinaryNode<Integer>( 1, node2, 
                                        node1 );
         
        assertEquals( node0.getRight( ), null );
        assertEquals( node1.getRight( ), null );
        assertEquals( node2.getRight( ), node1 );
        assertEquals( node3.getRight( ), node1 );
    }
    
     @Test
    public void testGetLeft()
    {
        BinaryNode<Integer> node0 = new BinaryNode<Integer>( 2, null,
                                        null ); 
        BinaryNode<Integer> node1 = new BinaryNode<Integer>( 5, null,
                                        null );
        BinaryNode<Integer> node2 = new BinaryNode<Integer>( 9, node0, 
                                        node1 );
        BinaryNode<Integer> node3 = new BinaryNode<Integer>( 1, node2, 
                                        node1 );
         
        assertEquals( node0.getLeft( ), null );
        assertEquals( node1.getLeft( ), null );
        assertEquals( node2.getLeft( ), node0 );
        assertEquals( node3.getLeft( ), node2 );
    }
}
