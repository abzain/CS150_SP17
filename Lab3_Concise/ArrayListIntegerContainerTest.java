import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArrayListIntegerContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArrayListIntegerContainerTest
{
    /**
     * Default constructor for test class ArrayListIntegerContainerTest
     */
    public ArrayListIntegerContainerTest()
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
    public void TestAddToFront()
    {
       ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
       
       //add element to front
       test1.addToFront(7);
       test1.addToFront(99);
       test1.addToFront(58);
       test1.addToFront(5);
       
       //check most recent added is at front
       Integer[] test_list = {5,58,99,7};
       assertArrayEquals( test1.getArray(), test_list );
       
    }
    
    @Test
    public void TestAddToBack()
    {
       ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
        
       //add element to back
       test1.addToBack(7);
       test1.addToBack(99);
       test1.addToBack(58);
       test1.addToBack(5);
       
       //check most recent added is at back
       Integer[] test_list = {7,99,58,5};
       assertArrayEquals( test1.getArray(), test_list );
       
    }
    
    @Test
    public void TestAddSorted()
    {
        ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
        
        //add elements to arraylist
        test1.addSorted(7);
        test1.addSorted(3);
        test1.addSorted(54);
        test1.addSorted(9);
        test1.addSorted(22);
        
       //check list sorted
       Integer[] test_list = {3,7,9,22,54};
       assertArrayEquals( test1.getArray(), test_list );
        
    }
    
    @Test
    public void TestInsertionSort()
    {
        ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
        
        //add elements to arraylist
        test1.addToFront(7);
        test1.addToFront(3);
        test1.addToFront(5);
        test1.addToFront(9);
        test1.addToFront(22);
    
        //sort arralist
        test1.insertionSort();
         
        //check list sorted
        Integer[] test_list = {3,5,7,9,22};
        assertArrayEquals( test1.getArray(), test_list );
        
    }
    
    @Test
    public void TestLinearSearch()
    {
        ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
        
        //add elements to arraylist
        test1.addToBack(7);
        test1.addToBack(3);
        test1.addToBack(5);
        test1.addToBack(9);
        test1.addToBack(22);
        
        //order {7,3,5,9,22}
        //find 9, at index = 1
        assertEquals( test1.linearSearch(9), 3 );
        //find non-existent val
        //find 4, not present so should give -1
        assertEquals( test1.linearSearch(4), -1 );
        
    }
    
    @Test
    public void TestBinarySearch()
    {
        ArrayListIntegerContainer test1 = new ArrayListIntegerContainer();
        
        //add elements to arraylist
        test1.addToBack(7);
        test1.addToBack(3);
        test1.addToBack(5);
        test1.addToBack(9);
        test1.addToBack(22);
        
        //order {7,3,5,9,22}
        //find 9, at index = 1
        assertEquals( test1.binarySearch(9), 3 );
        //find non-existent val
        //find 4, not present so should give -1
        assertEquals( test1.binarySearch(4), -1 );
    }
}
