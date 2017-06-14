
/**
 * Class Launcher - simple independent main class to test the project
 * runs the simulation once and prints to terminal given a set of 
 * paramaeters to the command line
 * 
 * @author Zainab Hussein
 * @version 3/10/2017
 */
public class Launcher
{
    // instance variables - replace the example below with your own
    /**
     * Static main class
     */
    public static void main( String[] args )
    {
        // parse all parameters

        int numberOfOperations = Integer.parseInt(args[0]);
        int seed = Integer.parseInt(args[1]);
        

        // start the simulation
        ExperimentController C = new ExperimentController();
        
        C.simulate( numberOfOperations, seed );


    }
}
