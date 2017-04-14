

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerQueueTest.
 *
 * @author  Cameron Zurmul
 */
public class CustomerQueueTest
{
    /**
     * Default constructor for test class CustomerQueueTest
     */
    public CustomerQueueTest()
    {
    }

    @Test 
    public void testSize()
    {
        //create a new queue
        CustomerQueue cl = new CustomerQueue();
        //it should be empty
        int size = cl.size();
        //test
        assertEquals(0, size);
    }
    
    @Test
    public void testAdd()
    {
        //create a new queue
        CustomerQueue cl = new CustomerQueue();
        //create a customer to add to that queue
        CustomerTracker c = new CustomerTracker(0,0);
        //the size of the queue should be one after adding
        int size = 1;
        cl.add(c);
        //test
        assertEquals(cl.size(), size);
    }
    
    @Test
    public void testPoll()
    {
        //create a new queue
        CustomerQueue cl = new CustomerQueue();
        //create a customer to add to that queue 
        CustomerTracker c = new CustomerTracker(0,0);
        //add to the queue 
        cl.add(c);
        //retrieve the customer 
        CustomerTracker d = cl.poll();
        //test the references 
        assertEquals(c, d);
    
    }
    
    @Test
    public void testisFull()
    {
        //create a new queue 
        CustomerQueue cl = new CustomerQueue();
        //obtain the boolean if its full or not--should be empty
        boolean full = cl.isFull();
        //test 
        assertEquals(full, false);
    }
    
    @Test
    public void testsetFull()
    {
        //create a new queue 
        CustomerQueue cl = new CustomerQueue();
        //set the queue to full
        cl.setFull();
        boolean full = true;
        //test if the booleans match
        assertEquals(full, cl.isFull());
    
    }
    
    @Test
    public void testsetnotFull()
    {
        //create a new queue 
        CustomerQueue cl = new CustomerQueue();
        //set the queue to not full
        cl.setnotFull();
        boolean full = false;
        //test if the booleans match
        assertEquals(full, cl.isFull());
    
    }
}
