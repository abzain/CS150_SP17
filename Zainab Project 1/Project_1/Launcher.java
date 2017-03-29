
/**
* Class Launcher runs the simulation once and prints to terminal given a set of paramaeters to the command line
*/
public class Launcher
{
   
    /**
     * Constructor for objects of class Launcher
     */
    public Launcher()
    {
    }

    public static void main(String [] args)
    {
         // parse all parameters

        int cashierCount = Integer.parseInt(args[0]);

        double profit = Double.parseDouble(args[1]);

        double cost = Double.parseDouble(args[2]);

        double lambda = Double.parseDouble(args[3]);

        double rateOfService = Double.parseDouble(args[4]);

        // start the simulation

        ExperimentController EC = new ExperimentController();
        
        EC.runSimsXia(cashierCount, profit, cost, rateOfService, lambda); //call runSimsXia from ExperimentController
    }
}
