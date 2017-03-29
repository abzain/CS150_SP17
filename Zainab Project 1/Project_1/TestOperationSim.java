
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.*;

/**
 * The test class TestOperationsim.
 */
public class TestOperationSim
{
    @Test
    public void testfillArrivals()
    { 
        //test if arrivals were put in the queue 
        OperationSim s = new OperationSim(3,.3,2.0);
        s.fillArrivals(10);
        boolean filled = s.getEventList().size()>0;
        assertEquals(filled, true);
    }

    @Test
    public void testcountservedCustomers()
    {
        OperationSim s = new OperationSim(3,.3,2.0);
        s.runSim(10);
        //test if there are more than one served customers
        boolean morethanOne = s.countServedCustomers()>1;
        assertEquals(true, morethanOne);
    }

    @Test
    public void testcountservedCustomers2(){
        OperationSim s = new OperationSim(3,.3,2.0);
        //now test if the served customers number is less than total customers for an entire simulation
        s.runSim(960);
        boolean lessthanEveryone = s.countServedCustomers()<s.getCustomers().size();
        assertEquals(lessthanEveryone, true);
    }

    @Test
    public void testCalculations(){
        //Run a simluation and gather statistics -- make sure they are all non zero numbers
        OperationSim s = new OperationSim(3,.3,2.0);
        s.runSim(960);
        s.countServedCustomers(); //put the served customers in their list
        double minWait = s.minWait();
        double avgWait = s.avgWait();
        double maxWait = s.maxWait();

        boolean allPositive = (minWait >=0 && avgWait > 0 && maxWait > 0);
        assertEquals(allPositive, true);

    }

}
