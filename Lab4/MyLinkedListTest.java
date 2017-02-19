import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyLinkedListTest
{
    /**
     * Default constructor for test class MyLinkedListTest
     */
    public MyLinkedListTest()
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
    public void testAddFirst() //give no args or test method is ignored by bluej
    {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();

        //add values to linkedlist
        test.addFirst(98);
        test.addFirst(4);
        
        //printcheck
        System.out.println( test.getValue(0) );   //4
        System.out.println( test.getValue(1) );   //98
        
        //check values are at correct location
        Integer four = Integer.valueOf(4);
        Integer a = Integer.valueOf(98);

        assertEquals( test.getValue(0), four );    
        assertEquals( test.getValue(1), a );

    }
    
    @Test
    public void testAddEnd() //give no args or test method is ignored by bluej
    {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();

        //add values to linkedlist
        test.addEnd(98);
        test.addEnd(4);
        
        //printcheck
        System.out.println( test.getValue(0) );   //98
        System.out.println( test.getValue(1) );   //4
        
        //check values are at correct location
        Integer four = Integer.valueOf(4);
        Integer a = Integer.valueOf(98);

        assertEquals( test.getValue(0), a );    
        assertEquals( test.getValue(1), four );

    }
    
    /**
     * test getValue() method
     */
    @Test
    public void testGetValue()
    {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        
        //add values to linkedlist
        test.addEnd(9);
        test.addFirst(98);
              
        //convert int to Integer
        Integer a = Integer.valueOf(98);
        Integer b = Integer.valueOf(9);
        
        //printcheck
        System.out.println( test.getValue(0) );   //98
        System.out.println( test.getValue(1) );   //9
              
        //check values are at correct location
        assertEquals( test.getValue(0), a );    
        assertEquals( test.getValue(1), b );
        
    }
}
