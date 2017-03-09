import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimulationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimulationTest
{
    /**
     * Default constructor for test class SimulationTest
     */
    public SimulationTest()
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
     * test run sim method
     */
    @Test
    public void testRunSim()
    {
        Simulation test = new Simulation( 5, 16.5, 2.0, 1.0, 2.0 );
        System.out.println( "Success?" );
        test.runSim();
        System.out.println( "Success!" );
    }
    
}
