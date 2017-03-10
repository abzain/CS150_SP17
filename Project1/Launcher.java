
/**
 * Class Launcher - simple independent main class to test the project
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

        int cashierCount = Integer.parseInt(args[0]);
        double profit = Double.parseDouble(args[1]);
        double cost = Double.parseDouble(args[2]);
        double lambda = Double.parseDouble(args[3]);
        double rateOfService = Double.parseDouble(args[4]);

        // start the simulation
        CafeSimulator sim = new CafeSimulator( cashierCount, profit, cost, lambda, rateOfService );
        sim.runSim();


    }
}
