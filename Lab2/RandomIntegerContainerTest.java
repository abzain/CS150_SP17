import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomIntegerContainerTest.
 *
 * @author  Zainab Hussein
 * @version 1/31/2017
 */
public class RandomIntegerContainerTest
{
    /**
     * Default constructor for test class RandomIntegerContainerTest
     */
    public RandomIntegerContainerTest()
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
    ArrayList<Integer> list;
    @Test
    public void TestAddToFront()
    {
       RandomIntegerContainer test1 = new RandomIntegerContainer();
       //add element to front
       test1.addToFront(7);
       
       //check added to front
       assertEquals( test1.getValue(0), 7 );    //ask reference to assertEquals ambiguo
       
       //add more
       test1.addToFront(99);
       test1.addToFront(58);
       test1.addToFront(5);
       
       //check most recent added is at front
       assertEquals( test1.get(0), 5 );
       
       //check contents of test1
       list = new ArrayList<Integer>( Arrays.asList( 5,58,99,7 ) );
       assertEquals( test1.getArray(), list );
       
    }
    
//     @Test
//     public void TestAddToBack()
//     {
//         RandomIntegerContainer test1 = new RandomIntegerContainer();
//         //add element to back
//        test1.addToBack(7);
//        
//        //check added to back
//        assertEquals( test1.get(10), 7 );
//        
//        //add more
//        test1.addToBack(99);
//        test1.addToBack(58);
//        test1.addToBack(5);
//        
//        //check most recent added is at back
//        //API - ArrayList() creates an empty list with initial capacity of 10
//        //assuming arraylist.size() = 10
//        assertEquals( test1.get(10), 5 );     
//        
//        //check contents of test1
//        list = new ArrayList<Integer>( {7,99,58,5}); 
//        assertEquals( test1.getArray(), list );
//     }
//     
//     @Test
//     public void TestAddSorted()
//     {
//         RandomIntegerContainer test1 = new RandomIntegerContainer();
//         //add elements to arraylist
//         test1.addSorted(7);
//         test1.addSorted(3);
//         test1.addSorted(54);
//         test1.addSorted(9);
//         test1.addSorted(22);
//         
//         //check sorted while added
//         assertEquals( test1.get(0), 3 );
//         assertEquals( test1.get(1), 7 );
//         assertEquals( test1.get(2), 9 );
//         assertEquals( test1.get(3), 22 );
//         assertEquals( test1.get(4), 54 );
//         
//         //check contents of test1
//         list = new ArrayList<Integer>( {3,7,9,22,54});
//         assertEquals( test1.getArray(), list );
//     }
//     
//     @Test
//     public void TestInsertionSort()
//     {
//         RandomIntegerContainer test1 = new RandomIntegerContainer();
//         //add elements to arraylist
//         test1.add(7);
//         test1.add(3);
//         test1.add(54);
//         test1.add(9);
//         test1.add(22);
//         
//         //sort arralist
//         test1.insertionSort();
//         
//         //check ordered
//         assertEquals( test1.get(0), 3 );
//         assertEquals( test1.get(1), 7 );
//         assertEquals( test1.get(2), 9 );
//         assertEquals( test1.get(3), 22 );
//         assertEquals( test1.get(4), 54 );
//         
//         //check contents of test1
//         list = new ArrayList<Integer>( {3,7,9,22,54});
//         assertEquals( test1.getArray(), list );
//         
//     }
    
}
