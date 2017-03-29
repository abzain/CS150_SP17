

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestCustomer.
*/
public class TestCustomer
{

    @Test
    public void testToString()
    {
        //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call toString
        String info = c.toString();
        //this is what the method should give
        String shouldBe = "Customer 5 has an arrival time of 0.00 mins, a wait time of 0.00 mins, a service time of 0.00 mins, and departs at 0.00 mins.";
        assertEquals(info, shouldBe);
    }
    
    @Test
    public void testcsvToString()
    {
         //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call toString
        String info = c.csvString();
        //this is what the method should give
        String shouldBe = "5,0.0,0.0,0.0,0.0,OVERFLOW";
        assertEquals(info, shouldBe);
    }
    
    @Test
    public void testgetarrivalTime()
    {
       //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call getserveTime--should return 0.0
        double time = c.getarrivalTime();
        
        //compare a Theoretical array with an actual Array by casting time to an int
        int [] Theoretical = {0};
        int [] Actual = {(int)time};
        assertArrayEquals(Actual, Theoretical);
    }
    
    @Test
    public void testgetwaitTime()
    {
        //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call getserveTime--should return 0.0
        double time = c.getwaitTime();
        
        //compare a Theoretical array with an actual Array by casting time to an int
        int [] Theoretical = {0};
        int [] Actual = {(int)time};
        assertArrayEquals(Actual, Theoretical);
    }
    
    @Test
    public void testgetserveTime()
    {
       //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call getserveTime--should return 0.0
        double time = c.getserveTime();
        
        //compare a Theoretical array with an actual Array by casting time to an int
        int [] Theoretical = {0};
        int [] Actual = {(int)time};
        assertArrayEquals(Actual, Theoretical);
    }
    
    @Test
    public void testgetdepartTime()
    {
      //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call getserveTime--should return 0.0
        double time = c.getdepartTime();
        
        //compare a Theoretical array with an actual Array by casting time to an int
        int [] Theoretical = {0};
        int [] Actual = {(int)time};
        assertArrayEquals(Actual, Theoretical);
    }
    
    @Test
    public void testgetCustomerNum()
    {
        //create a new customer object
        Customer c = new Customer(5, 0.0);
        //call getCustomerNum--should return 0.0
        int num = c.getCustomerNum();
        assertEquals(5, num);
    }
    
    @Test
    public void testsetarrivalTime()
    {
        //Create a new customer object
        Customer c = new Customer(5, 0.0);
        //set the time
        c.setarrivalTime(5.0);
        //get the time
        double time = c.getarrivalTime();
        //compare the times as ints
        assertEquals((int)5.0,(int)time);
     
    }
    
    @Test
    public void testsetserveTime()
    {
        //Create a new customer object
        Customer c = new Customer(5, 0.0);
        //set the time
        c.setserveTime(5.0);
        //get the time
        double time = c.getserveTime();
        //compare the times as ints
        assertEquals((int)5.0,(int)time);
     
    }
    
    @Test
    public void testsetwaitTime()
    {
        //Create a new customer object
        Customer c = new Customer(5, 0.0);
        //set the time
        c.setwaitTime(5.0);
        //get the time
        double time = c.getwaitTime();
        //compare the times as ints
        assertEquals((int)5.0,(int)time);
     
    }
    
    @Test
    public void testsetdepartTime()
    {
        //Create a new customer object
        Customer c = new Customer(5, 0.0);
        //set the time
        c.setdepartTime(5.0);
        //get the time
        double time = c.getdepartTime();
        //compare the times as ints
        assertEquals((int)5.0,(int)time);
     
    }
}
