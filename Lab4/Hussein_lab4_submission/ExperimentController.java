import java.util.*;
import java.io.*;

/**
 * Class ExperimentController evaluates performance of both searches 
 * against one another. 
 * 
 * @author Zainab Hussein
 * @version 2/18/2017
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

     /**
     * static method for lab 4
     */
    public static void main(String [] args)
    {
        ExperimentController exp = new ExperimentController();
            
        //write out
        File outFile = new File ("dataout.txt");
        //catch exception
        try{
            FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() );
            PrintWriter pWriter = new PrintWriter ( fWriter );
            
            //checking 10 different seeds per number of items
            for( int numberOfItems = 1000; numberOfItems < 11000; numberOfItems = (numberOfItems + 1000) ){
                for( int seed = 1000; seed < 5000; seed = (seed + 1000) ){
                    pWriter.println( " " );
                    pWriter.print( exp.timeItrSearch( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeNoItrSearch( numberOfItems, seed ) + "," );
                    //Order of times printed: timeItrSearch timeNoItrSearch 
                    
                }
            }
            
            pWriter.close();

        }
        catch(Exception e){
             System.out.println(e);
        }
        
    }
        
    /**
     * timeItrSearch method
     */
    public long timeItrSearch( int numberOfItems, int seed )
    {
        MyListIntegerContainer<Integer> linInt = new MyListIntegerContainer<Integer>();
        Random randNum = new Random( seed );
        
        //time measure
        long startTime = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.itrSearch( randNum.nextInt() );
        }
        long stopTime = System.nanoTime();
              
        System.out.println( "timeItrSearch: " + ( stopTime - startTime ) );
        return ( (stopTime - startTime) );   
    }
    
    /**
     * timeNoItrSearch method
     */
      public long timeNoItrSearch( int numberOfItems, int seed )
    {
        MyListIntegerContainer<Integer> linInt = new MyListIntegerContainer<Integer>();
        Random randNum = new Random( seed );
        
        //time measure
        long startTime = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.noItrSearch( randNum.nextInt() );
        }
        long stopTime = System.nanoTime();
              
        System.out.println( "timeNoItrSearch: " + ( stopTime - startTime ) );
        return ( (stopTime - startTime) );   
    }
}
