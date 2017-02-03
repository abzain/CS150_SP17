import java.util.*;
import java.io.*;

/**
 * Write a description of class ExperimentController here.
 * 
 * @author Zainab Hissein
 * @version 1/31/2017
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
     * static main method for lab 2
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
                for( int seed = 1000; seed < 11000; seed = (seed + 1000) ){
                    pWriter.println( " " );
                    pWriter.print( exp.timeAddToFront( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeAddToBack( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeAddSorted( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeSortOfUnsortedList( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeSortOfSortedList() + " " );
                    //Order of times printed: timeAddToFront timeAddToBack timeAddSorted 
                    //timeSortOfUnsortedList timeSortOfSortedList
                    //pWriter.print( "numberOfItems :" + numberOfItems );
                }
            }
            
            pWriter.close();

         }
         catch(Exception e){
             System.out.println(e);
         }
            
    }

    /**
     * have a loop to give the average of 10 runs per range of seed, 
     * and another per range of numberItems
     * 
     * write to output file using csv then plot in excel
     */
    /**
     * timeAddToFront method
     */
    public long timeAddToFront( int numberOfItems, int seed )
    {
        RandomIntegerContainer randINT = new RandomIntegerContainer();
        Random randNum = new Random( seed );
        
        long startTime = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            randINT.addToFront( randNum.nextInt() );
        }
        long stopTime = System.nanoTime();
        
        System.out.println( "timeAddToFront: " + ( stopTime - startTime ) );

        return ( stopTime - startTime );
    }
    
    /**
     * timeAddToBack method
     */
    public long timeAddToBack( int numberOfItems, int seed )
    {
        RandomIntegerContainer randINT = new RandomIntegerContainer();
        Random randNum = new Random( seed );
        
        long startTime = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            randINT.addToBack( randNum.nextInt() );
        }
        long stopTime = System.nanoTime();
        
        System.out.print( "timeAddToBack: " + ( stopTime - startTime + ",") );
        return ( stopTime - startTime );
    }
    
    /**
     * timeAddSorted method
     */
    public long timeAddSorted( int numberOfItems, int seed )
    {
        RandomIntegerContainer randINT = new RandomIntegerContainer();
        Random randNum = new Random( seed );
        
        long startTime = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            randINT.addSorted( randNum.nextInt() );
        }
        long stopTime = System.nanoTime();
        
        System.out.print( "timeAddSorted: " + ( stopTime - startTime + ",") );
        return ( stopTime - startTime );
    }
    
    /**
     * timeSortOfUnsortedList method
     */
    public long timeSortOfUnsortedList( int numberOfItems, int seed )
    {
        RandomIntegerContainer randINT = new RandomIntegerContainer();
        Random randNum = new Random( seed );
        
        for( int i = 0; i < numberOfItems; i++ ){
            randINT.addToBack( randNum.nextInt() );
        }
        
        long startTime = System.nanoTime();
        randINT.insertionSort();
        long stopTime = System.nanoTime();
        
        System.out.print( "timeSortOfUnsortedList: " + ( stopTime - startTime + ",") );
        return ( stopTime - startTime );
    }
    
    /**
     * timeSortOfSortedList method
     */
    public long timeSortOfSortedList()
    {
        RandomIntegerContainer randINT = new RandomIntegerContainer();
        randINT.insertionSort();
        
        long startTime = System.nanoTime();
        randINT.insertionSort();
        long stopTime = System.nanoTime();
        
        System.out.print( "timeSortOfSortedList: " + ( stopTime - startTime + ",") );
        System.out.println( " " );
        return ( stopTime - startTime );
    }
}
