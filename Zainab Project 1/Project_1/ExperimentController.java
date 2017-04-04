import java.util.*;
import java.io.*;
/**
 * Class Experiment Controller runs averages for the simulation
 */
public class ExperimentController
{
    /**
     * Constructor for class ExperimentController
     */
    public ExperimentController() {}
    
    public static void main(String [] args)
    {
        //lambdas to test --2.0, 1.5, 1, 0.5, 0.3, 0.2
        ExperimentController EC = new ExperimentController();
        
        //for( int i=0; i<10; i++ ){
          //  EC.runSims(i,2.0,300.00,.3,.2);
        //}
        EC.runSims(4,2.0,300.00,.3,.2);
    }

    /**
     * Method runSimsXia runs a simulation once and just prints to the terminal
     * @param numCashiers the number of cashiers in the simulation
     * @param profitperCustomer the amount of money made per customer
     * @param costCashier the cashier's salary/day
     * @param avgServiceLen the average service length of a customer
     * @param lambda the customer arrival interval
     */
    public void runSimsXia(int numCashiers, double profitperCustomer, double costCashier, double avgServiceLen, double lambda){
        //variables to average 
        double minWait = 0;
        double avgWait = 0;
        double maxWait = 0;
        double overflowRate = 0; 
        double netProfit = 0;

        OperationSim os = new OperationSim(numCashiers, avgServiceLen, lambda); //create an OperationSim object using the parameters
        os.runSim(960); //run the simulation

        int numcustomersServed = os.countServedCustomers();      //number of served customers

        double expenditures = numCashiers *costCashier;    // expenditures -- rate * number 
        double totalIncome = profitperCustomer*numcustomersServed;   //total Income=rate * number
        netProfit = totalIncome - expenditures;    //net profit =income - expenditures 
        overflowRate = (double)os.getoverflowCustomers().size()/os.getCustomers().size();  //overflow rate is number of overflows over total number
        minWait = os.minWait();
        avgWait = os.avgWait();
        maxWait = os.maxWait(); 

        System.out.println("****************************RESULTS****************************"); //print outs to terminal 
        System.out.println("Overflow Number: " + os.getoverflowCustomers().size());//give prints
        System.out.println("Served number: " +numcustomersServed); //give prints
        System.out.println("Total customers: "+ os.getCustomers().size()); //give prints

        System.out.println();
        System.out.printf("Min Wait (mins): %.2f \n",minWait);
        System.out.printf("Avg Wait (mins): %.2f \n",avgWait);
        System.out.printf("MaxWait (mins): %.2f \n",maxWait);
        System.out.printf("Overflow Rate: %.2f \n",overflowRate);
        System.out.printf("Net Profit: $%.2f \n",netProfit);
    }

    /**
     * Method runSims runs the simulations for a specified amount of runs and takes an average.  All results are exported to a csv.
     * @param numCashiers the number of cashiers in the simulation
     * @param profitperCustomer the amount of money made per customer
     * @param costCashier the cashier's salary/day
     * @param avgServiceLen the average service length of a customer
     * @param lambda the customer arrival interval
     */
    public void runSims(int numCashiers, double profitperCustomer, double costCashier, double avgServiceLen, double lambda){
        //variables to average or record
        double minWait = 0;
        double avgWait = 0;
        double maxWait = 0;
        double overflowRate = 0; 
        double netProfit = 0;

        int numberOfRuns = 0;  //number of trials for averaging
        boolean report = false; //boolean whether to report this simulation to a .csv file or not
        //io tools
        PrintWriter pw = null;  //print writer for the file
        Scanner in = new Scanner(System.in);

        //ask user for inputs
        try{
            System.out.print("Would you like to report this simulation to a csv? Yes/No: ");
            String s = in.next();
            if(s.equals("Yes") || s.equals("yes")){
                report = true;
            }
            System.out.print("How many runs do you want to do for this experiment? I will take an average of calculations: ");
            numberOfRuns = in.nextInt();
        } catch(Exception e){
            e.printStackTrace();
        }

        File Experimentcsv = new File("Experiment with " + numCashiers + " cashiers " + "and lambda equal to " + lambda+ ".csv"); //create a new file for this experiment
        int cycle = 0; //trial number
        while(cycle<numberOfRuns){  //run simluation n times
            OperationSim os = new OperationSim(numCashiers, avgServiceLen, lambda); //create an OperationSim object using the parameters
            os.runSim(960); //run the simulation

            int numcustomersServed = os.countServedCustomers();      //number of served customers
            double expenditures = numCashiers *costCashier;    // expenditures -- rate * number 
            double totalIncome = profitperCustomer*numcustomersServed;   //total Income=rate * number
            netProfit += totalIncome - expenditures;    //net profit =income - expenditures 
            overflowRate += (double)os.getoverflowCustomers().size()/os.getCustomers().size();  //overflow rate is number of overflows over total number
            minWait += os.minWait(); //compound for every trial
            avgWait += os.avgWait(); //compound for every trial
            maxWait += os.maxWait(); // compound for every trial

            System.out.println("****************************RESULTS FOR CYCLE " + cycle + "****************************"); //print outs to terminal per cycle
            System.out.println();
            System.out.println("Overflow Number: " + os.getoverflowCustomers().size());//give prints
            System.out.println("Served number: " +numcustomersServed); //give prints
            System.out.println("Total customers: "+ os.getCustomers().size()); //give prints

            //Report the trial data to a csv file
            if(report){
                try{
                    if(!Experimentcsv.exists()){ //if the file does not exist, create a new one
                        Experimentcsv.createNewFile();
                        pw = new PrintWriter(new FileWriter(Experimentcsv));
                        pw.println("Trial," + cycle);
                        pw.println("Customer,Arrival Time,Waiting Time,Service Time,Depart Time,Status"); //these are the cell headers
                        for(Customer c : os.getCustomers()){ //for every customer in OperationSim's customer array, print their data to csv
                            pw.println(c.csvString());
                        }
                        pw.flush();
                        pw.close();
                        //summary message--include for all experiments
                        System.out.println(".csv created --check the working directory");
                    } else { //else just append to the existing file using the same prior logic 
                        pw = new PrintWriter(new FileWriter(Experimentcsv, true));
                        pw.println();
                        pw.println("Trial," + cycle);
                        pw.println("Customer,Arrival Time,Service Time,Depart Time,Waiting Time,Status");
                        for(Customer c : os.getCustomers()){ //for every customer in OperationSim's customer array, print their data to csv
                            pw.println(c.csvString());
                        }
                        pw.flush();
                        pw.close(); //close the file
                        System.out.println(".csv amended--check the working directory");
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            cycle++;//update trial
        }

        //take averages
        minWait = (double)minWait/numberOfRuns;
        avgWait = (double)avgWait/numberOfRuns;
        maxWait = (double)maxWait/numberOfRuns;
        overflowRate = (double)overflowRate/numberOfRuns; 
        netProfit = (double)netProfit/numberOfRuns;

        //reopen the working file and append the averaged results to the bottom
        if(report){
            try{
                pw = new PrintWriter(new FileWriter(Experimentcsv,true));
                pw.println();
                pw.println("Minimum Wait,Average Wait, Maximum Wait, Overflow Rate, NetProfit"); //headers
                pw.printf("%.2f,%.2f,%.2f,%.2f,%.2f",minWait,avgWait,maxWait,overflowRate,netProfit); //results
                pw.flush();
                pw.close(); //close it 
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //give printouts for the averaged results--to the terminal 
        System.out.println("****************************AVERAGED RESULTS****************************");
        System.out.printf("Min Wait (mins): %.2f \n",minWait);
        System.out.printf("Avg Wait (mins): %.2f \n",avgWait);
        System.out.printf("MaxWait (mins): %.2f \n",maxWait);
        System.out.printf("Overflow Rate: %.2f \n",overflowRate);
        System.out.printf("Net Profit: $%.2f \n",netProfit);
    }
}
