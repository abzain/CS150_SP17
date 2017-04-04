

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BinarySearchTreeTest.
 *
 * @author  Zainab Hussein
 * @version 3-21-2017
 */
public class BinarySearchTreeTest
{
    /**
     * Default constructor for test class BinarySearchTreeTest
     */
    public BinarySearchTreeTest()
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
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        
    }
    
    @Test
    public void testPrintPreOrder()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        bst.printPreOrder();
    }
    
    @Test
    public void testPrintPostOrder()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        bst.printPostOrder();
    }
    
    @Test
    public void testPrintInOrder()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        bst.printInOrder();
    }
    
    @Test
    public void testRemove()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        
        assertEquals( bst.remove(9), false );
        
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        assertEquals( bst.remove(9), true );
    }
    
    @Test
    public void testContains()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
    }
    
    @Test
    public void testFindMax()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        
        assertEquals( bst.findMax(), (Integer)9 );
    }
    
    @Test
    public void testFindMin()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        assertEquals( bst.findMin(), (Integer)1 );
    }
    
    @Test
    public void testEmpty()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.empty();
        assertEquals( bst.isEmpty() , true );
    }
    
    @Test
    public void testIsEmpty()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        bst.insert( 5 );
        bst.insert( 9 );
        bst.insert( 1 );
        
        assertEquals( bst.isEmpty(), false );
        bst.empty();
        assertEquals( bst.isEmpty(), true );
    }
    
    @Test
    public void testSize()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert( 3 );
        assertEquals( bst.size(), 1 );
        bst.insert( 5 );
        assertEquals( bst.size(), 2 );
        bst.insert( 9 );
        assertEquals( bst.size(), 3 );
        bst.insert( 1 );
        assertEquals( bst.size(), 4 );
        
    }
}

