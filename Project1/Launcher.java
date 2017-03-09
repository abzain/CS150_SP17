
/**
 * Write a description of class Launcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        Simulation sim = new Simulation( cashierCount, profit, cost, lambda, rateOfService );
        sim.runSim();


    }
}
