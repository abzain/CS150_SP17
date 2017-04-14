import java.io.*;
import java.util.*;
/**
 * Class ExperimentController simulates averages for the simulation
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
        // initialise instance variables
    }

    public static void main(String [] args)
    {
        ExperimentController EC = new ExperimentController();
        for( int num = 100; num<1_100; num=num+100 ){
            for( int seed = 0; seed< 60; seed = seed+30 ){
                EC.simulate( num, seed );
            }
        }
    }
    
     /**
     * Method simulate runs the simulations for a specified amount of runs and takes an average.  All results are exported to a csv.
     * @param avgTimeRed_1 average time for simulation 1% select with RedBlackTree
     * @param avgTimeRed_0_1 average time for simulation .1% select with RedBlackTree
     * @param avgTimeRed_0_0_1 average time for simulation .01% select with RedBlackTree
     * @param avgTimeHash_1 average time for simulation 1% select with HashSet
     * @param avgTimeHash_0_1 average time for simulation .1% select with HashSet
     * @param avgTimeHash_0_0_1 average time for simulation .01% select with HashSet
     * @param avgTimeArr_1 average time for simulation 1% select with ArrayList
     * @param avgTimeArr_0_1 average time for simulation .1% select with ArrayList
     * @param avgTimeArr_0_0_1 average time for simulation .01% select with ArrayList
     */
    public void simulate( int numOperations, int seed ){
        //variables to average or record
        int numberOfRuns = 0;  //number of trials for averaging
        boolean report = false; //boolean whether to report this simulation to a .csv file or not
        //io tools
        PrintWriter pw = null;  //print writer for the file
        Scanner in = new Scanner(System.in);
        
        long avgTimeArr_1 = 0;
        long avgTimeArr_0_1 = 0;
        long avgTimeArr_0_0_1 = 0;
        long avgTimehash_1 = 0;
        long avgTimeHash_0_1 = 0;
        long avgTimeHash_0_0_1 = 0;
        long avgTimeRed_1 = 0;
        long avgTimeRed_0_1 = 0;
        long avgTimeRed_0_0_1 = 0;

        //ask user for inputs
        try{
            System.out.print("Would you like to report this simulation to a csv? Yes/No: ");
            String s = in.next();
            if(s.equals("Yes") || s.equals("yes")){
                report = true;
            }
            System.out.print("Number of averaged runs?: ");
            numberOfRuns = in.nextInt();
        } catch(Exception e){
            e.printStackTrace();
        }

        File Experimentcsv = new File("Experiment with " + numOperations + " Operations " + ".csv"); //create a new file for this experiment
        int cycle = 0; //trial number
        while(cycle<numberOfRuns){  //run simluation n times
            DrawPhoneNum draw = new DrawPhoneNum(); //create an DrawPhoneNum object using the parameters
            
             avgTimeArr_1       += draw.timeArr_1( numOperations, seed );
             avgTimeArr_0_1     += draw.timeArr_0_1( numOperations, seed );
             avgTimeArr_0_0_1   += draw.timeArr_0_0_1( numOperations, seed );
             avgTimehash_1      += draw.timeHash_1( numOperations, seed );
             avgTimeHash_0_1    += draw.timeHash_0_1( numOperations, seed );
             avgTimeHash_0_0_1  += draw.timeHash_0_0_1( numOperations, seed );
             //avgTimeRed_1       += draw.timeRed_1( numOperations, seed );
            // avgTimeRed_0_1     += draw.timeRed_0_1( numOperations, seed );
             //avgTimeRed_0_0_1   += draw.timeRed_0_0_1( numOperations, seed );

            
            System.out.println("****************************RESULTS FOR CYCLE " + cycle + "****************************"); 
            System.out.println();
            //Report the trial data to a csv file
            if(report){
                try{
                    if(!Experimentcsv.exists()){ //if the file does not exist, create a new one
                        Experimentcsv.createNewFile();
                        pw = new PrintWriter(new FileWriter(Experimentcsv));
                        pw.println("Trial," + cycle);
                        pw.println("ArrayList_1%,ArrayList_.1% ArrayList_.01%, HashSet_1%,HashSet_.1%, HashSet_.01%,RBT_1%,RBT_.1%,RBT_.01%"); //these are the cell headers
                        pw.println( draw.toCSV( numOperations,seed ) );
                        pw.flush();
                        pw.close();
                        //summary message--include for all experiments
                        System.out.println(".csv created --check the working directory");
                    } else { //else just append to the existing file using the same prior logic 
                        pw = new PrintWriter(new FileWriter(Experimentcsv, true));
                        pw.println();
                        pw.println("Trial," + cycle);
                        pw.println("ArrayList_1%,ArrayList_.1% ArrayList_.01%, HashSet_1%,HashSet_.1%, HashSet_.01%,RBT_1%,RBT_.1%,RBT_.01%");
                        pw.println( draw.toCSV( numOperations,seed ) );
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
         avgTimeArr_1        = avgTimeArr_1/ numberOfRuns;     
         avgTimeArr_0_1      = avgTimeArr_0_1/ numberOfRuns;     
         avgTimeArr_0_0_1    = avgTimeArr_0_0_1/ numberOfRuns;
         avgTimehash_1       = avgTimehash_1/ numberOfRuns;
         avgTimeHash_0_1     = avgTimeHash_0_1/ numberOfRuns;
         avgTimeHash_0_0_1   = avgTimeHash_0_0_1/ numberOfRuns;
         //avgTimeRed_1        = avgTimeRed_1/ numberOfRuns;
        // avgTimeRed_0_1      = avgTimeRed_0_1/ numberOfRuns;
         //avgTimeRed_0_0_1    = avgTimeRed_0_0_1/ numberOfRuns;
         
         //represent average times as strings
         String s = String.valueOf( avgTimeArr_1)+","+String.valueOf(avgTimeArr_0_1)+","+String.valueOf(avgTimeArr_0_0_1)+","+
                    String.valueOf(avgTimehash_1)+","+String.valueOf(avgTimeHash_0_1)+","+String.valueOf(avgTimeHash_0_0_1)+","+
                    String.valueOf(avgTimeRed_1)+","+String.valueOf(avgTimeRed_0_1)+","+String.valueOf(avgTimeRed_0_0_1 );

        //reopen the working file and append the averaged results to the bottom
        if(report){
            try{
                pw = new PrintWriter(new FileWriter(Experimentcsv,true));
                pw.println();
                pw.println("avgAL1,avgAL01, avgAL001, avgHashSet1,avgHashSet01, avgHashSet001,avgRBT1,avgRBT01,avgRBT001"); //headers
                pw.printf(s); //results
                pw.flush();
                pw.close(); //close it 
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //give printouts for the averaged results--to the terminal 
        System.out.println("****************************AVERAGED RESULTS****************************");
        System.out.printf("avgAL1 (ms): ",avgTimeArr_1);
        System.out.printf("avgAL01 (ms): ",avgTimeArr_0_1);
        System.out.printf("avgAL001 (ms): ",avgTimeArr_0_0_1);
        System.out.printf("avgHashSet1 (ms): ",avgTimehash_1);
        System.out.printf("avgHashSet01 (ms): ",avgTimeHash_0_1);
        System.out.printf("avgHashSet001 (ms): ",avgTimeHash_0_0_1);
        //System.out.printf("avgTimeRed_1 (ms): ",avgTimeRed_1);
        // System.out.printf("avgTimeRed_0_1 (ms): ",avgTimeRed_0_1);
        //System.out.printf("avgTimeRed_0_0_1 (ms): ",avgTimeRed_0_0_1);
    }
}
