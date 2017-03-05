import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorkerListTest.
 *
 * @author  Zainab Hussein
 * @version 2/21/2017
 */
public class WorkerListTest
{
    /**
     * Default constructor for test class WorkerListTest
     */
    public WorkerListTest()
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
     * test addElement
     */
    @Test
    public void testAddElement()
    {
        WorkerList test = new WorkerList();
        
        //add worker objects
        Worker w1 = new Worker( "Julian", "Winslow", 65L  );
        Worker w2 = new Worker( "Nathan", "Kariuki", 25L );
        Worker w3 = new Worker( "Simmone", "Amina", 4L );
        Worker w4 = new Worker( "Amaar", "Gismala", 63L );
        Worker w5 = new Worker( "Juju", "Theodr", 14L );
        
        //add them to container arraylst
        test.addElement( w1 );
        test.addElement( w2 );
        test.addElement( w3 );
        test.addElement( w4 );
        test.addElement( w5 );
        //control case
        ArrayList<Worker> alist = new ArrayList<Worker>();
        alist.add( w1 );
        alist.add( w2 );
        alist.add( w3 );
        alist.add( w4 );
        alist.add( w5 );
       
        //show data in container
        assertEquals( test.getValue(1), alist.get(1) );
    }
    
    /**
     * test quickSort
     */
        @Test
    public void testQuickSort()
    {
        WorkerList test = new WorkerList();
        
        //add worker objects
        Worker a = new Worker( "Julian", "Winslow", 65L  );
        Worker b = new Worker( "Nathan", "Kariuki", 25L );
        Worker c = new Worker( "Simmone", "Amina", 4L );
        Worker d = new Worker( "Amaar", "Gismala", 63L );
        Worker e = new Worker( "Juju", "Theodr", 14L );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //quickSort data
        //sort based on comparable id of workers
        test.quickSort();
       
        //show data in container
        assertEquals( test.getValue(0).getId(),4L  );
        assertEquals( test.getValue(1).getId(), 14L );
        assertEquals( test.getValue(2).getId(), 25L );
        assertEquals( test.getValue(3).getId(), 63L );
        assertEquals( test.getValue(4).getId(), 65L );
        
        //assertEquals calls on equals method of the Object class
        //which compares references
        
        //write an equals method in the worker and contact class
        //so that when using the assertEquals methos, it calls
        //that specific method that compares parameters in either
        //class
    }
    
    /**
     * test mergeSort
     */
        @Test
    public void testMergeSort()
    {
        WorkerList test = new WorkerList();
        
        //add worker objects
        Worker a = new Worker( "Julian", "Winslow", 65L  );
        Worker b = new Worker( "Nathan", "Kariuki", 25L );
        Worker c = new Worker( "Simmone", "Amina", 4L );
        Worker d = new Worker( "Amaar", "Gismala", 63L );
        Worker e = new Worker( "Juju", "Theodr", 14L );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //mergeSort data
        //sort based on comparable id of workers
        test.mergeSort();
       
        //show data in container
        assertEquals( test.getValue(0).getId(),4L  );
        assertEquals( test.getValue(1).getId(), 14L );
        assertEquals( test.getValue(2).getId(), 25L );
        assertEquals( test.getValue(3).getId(), 63L );
        assertEquals( test.getValue(4).getId(), 65L );
    }
    
    /**
     * test printData
     */
    @Test
    public void testPrintData()
    {
        WorkerList test = new WorkerList();
        
        //add worker objects
        Worker a = new Worker( "Julian", "Winslow", 65L  );
        Worker b = new Worker( "Nathan", "Kariuki", 25L );
        Worker c = new Worker( "Simmone", "Amina", 4L );
        Worker d = new Worker( "Amaar", "Gismala", 63L );
        Worker e = new Worker( "Juju", "Theodr", 14L );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //mergeSort data
        test.printData();
       
    }
}
