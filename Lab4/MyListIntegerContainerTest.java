import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyListIntegerContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyListIntegerContainerTest
{
    /**
     * Default constructor for test class MyListIntegerContainerTest
     */
    public MyListIntegerContainerTest()
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
     * test addToFront method
     */
    @Test
    public void testAddToFront()
    {
        MyListIntegerContainer<Integer> test = 
        new MyListIntegerContainer<Integer>();
        
        //add values to linkedlist
        test.addToFront(98);
        test.addToFront(4);
        
        //printcheck
        System.out.println( test.giveVal(0) );   //4
        System.out.println( test.giveVal(1) );   //98
        
        //check values are at correct location
        Integer four = Integer.valueOf(4);
        Integer a = Integer.valueOf(98);

        assertEquals( test.giveVal(0), four );    
        assertEquals( test.giveVal(1), a );
    }
    
    /**
     * test addToEnd method
     */
    @Test
    public void testAddToBack()
    {
        MyListIntegerContainer<Integer> test = 
        new MyListIntegerContainer<Integer>();
        
        //add values to linkedlist
        test.addToBack(98);
        test.addToBack(4);
        
        //printcheck
        System.out.println( test.giveVal(0) );   //98
        System.out.println( test.giveVal(1) );   //4
        
        //check values are at correct location
        Integer four = Integer.valueOf(4);
        Integer a = Integer.valueOf(98);

        assertEquals( test.giveVal(0), a );    
        assertEquals( test.giveVal(1), four );
    }
    
    /**
     * test itrSearch method
     */
    @Test
    public void testItrSearch()
    {
        MyListIntegerContainer<Integer> test = 
        new MyListIntegerContainer<Integer>();
        
        //add values to linkedlist
        test.addToFront(98);
        test.addToFront(4);
        test.addToFront(8);
        test.addToFront(14);
        
        Integer a = Integer.valueOf(8);
        Integer b = Integer.valueOf(2);
        //search for 8
        test.itrSearch(8);
        assertEquals( test.giveVal(1), a );
        
        //search for non-existing val, thus the val is null
        test.itrSearch(2);
        assertEquals( test.giveVal(-1), null );
    }
    
    /**
     * test noItrSearch method
     */
    @Test
    public void testNoItrSearch()
    {
        MyListIntegerContainer<Integer> test = 
        new MyListIntegerContainer<Integer>();
        
        //add values to linkedlist
        test.addToFront(98);
        test.addToFront(4);
        test.addToFront(8);
        test.addToFront(14);
        
        Integer a = Integer.valueOf(8);
        Integer b = Integer.valueOf(2);
        
        //search for 8
        test.noItrSearch(8);
        assertEquals( test.giveVal(1), a );
        
        //search for non-existing val, thus the val is null
        test.noItrSearch(2);
        assertEquals( test.giveVal(-1), null );
    }
}
