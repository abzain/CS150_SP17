import java.util.*;
import java.io.*;

/**
 * Write a description of class ExperimentController here.
 * 
 * @author Zainab Hissein
 * @version 2/7/2017
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
     * static method for lab 3
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
                    pWriter.print( exp.timeAddToFront_al( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeAddToFront_ls( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeAddToBack_al( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeAddToBack_ls( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeAddSorted_al( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeAddSorted_ls( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeSortOfUnsortedList_al( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeSortOfUnsortedList_ls( numberOfItems, seed ) + ",");
                    pWriter.print( exp.timeSortOfSortedList_al() + "," );
                    pWriter.print( exp.timeSortOfSortedList_ls() + "," );
                    pWriter.print( exp.timeLinearSearch_al( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeLinearSearch_ls( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeBinarySearch_al( numberOfItems, seed ) + "," );
                    pWriter.print( exp.timeBinarySearch_ls( numberOfItems, seed ) + "," );
                    //Order of times printed: timeAddToFront timeAddToBack timeAddSorted 
                    //timeSortOfUnsortedList timeSortOfSortedList timeLinearSearch timeBinarySearch
                    
                }
            }
            
            pWriter.close();

         }
         catch(Exception e){
             System.out.println(e);
         }
        
        }
        
    /**
     * timeAddToFront method
     */
    public long timeAddToFront_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        long startTime_al = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.addToFront( randNum.nextInt() );
        }
        long stopTime_al = System.nanoTime();
              
        System.out.println( "timeAddToFront_al: " + ( stopTime_al - startTime_al ) );
        return ( (stopTime_al - startTime_al) );   //arraylist
    }
    
    /**
     * timeAddToFront method
     */
    public long timeAddToFront_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        long startTime_ls = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.addToFront( randNum.nextInt() );
        }
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeAddToFront_ls: " + ( stopTime_ls - startTime_ls ) );
        return ( (stopTime_ls - startTime_ls) );   //linkedlist
    }
    
    /**
     * timeAddToBack method
     */
    public long timeAddToBack_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();        
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        long startTime_al = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.addToBack( randNum.nextInt() );
        }
        long stopTime_al = System.nanoTime();
              
        System.out.println( "timeAddToBack_al: " + ( stopTime_al - startTime_al ) );
        return ( (stopTime_al - startTime_al) );
    }
    
    /**
     * timeAddToBack method
     */
    public long timeAddToBack_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        long startTime_ls = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.addToBack( randNum.nextInt() );
        }
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeAddToBack_ls: " + ( stopTime_ls - startTime_ls ) );
        return ( (stopTime_ls - startTime_ls) );
    }
    
    /**
     * timeAddSorted method
     */
    public long timeAddSorted_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        long startTime_al = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.addSorted( randNum.nextInt() );
        }
        long stopTime_al = System.nanoTime();
        
        System.out.println( "timeAddSorted_al: " + ( stopTime_al - startTime_al ) );
        return ( (stopTime_al - startTime_al) );
        
    }
    
    /**
     * timeAddSorted method
     */
    public long timeAddSorted_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        long startTime_ls = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.addSorted( randNum.nextInt() );
        }
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeAddSorted_ls: " + ( stopTime_ls - startTime_ls ) );
        return ( (stopTime_ls - startTime_ls) );
        
    }
    
    /**
     * timeSortOfUnsortedList method
     */
    public long timeSortOfUnsortedList_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.addToBack( randNum.nextInt() );
        }
        
        long startTime_al = System.nanoTime();
        arrInt.insertionSort();
        long stopTime_al = System.nanoTime();
        
        System.out.println( "timeSortOfUnsortedList_al: " + ( stopTime_al - startTime_al ) + "," );
        return ( (stopTime_al - startTime_al) );
        
    }
    
    /**
     * timeSortOfUnsortedList method
     */
    public long timeSortOfUnsortedList_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.addToBack( randNum.nextInt() );
        }
        
        long startTime_ls = System.nanoTime();
        linInt.insertionSort();
        long stopTime_ls = System.nanoTime();

        System.out.println( "timeSortOfUnsortedList_ls: " + ( stopTime_ls - startTime_ls ) + "," );
        return ( (stopTime_ls - startTime_ls) );
        
    }
    
    /**
     * timeSortOfSortedList method
     */
    public long timeSortOfSortedList_al()
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        
        arrInt.insertionSort();
        
        long startTime_al = System.nanoTime();
        arrInt.insertionSort();
        long stopTime_al = System.nanoTime();
        
        System.out.println( "timeSortOfSortedList_al: " + ( stopTime_al - startTime_al ) + "," );
        return ( (stopTime_al - startTime_al) );

    }
    
    /**
     * timeSortOfSortedList method
     */
    public long timeSortOfSortedList_ls()
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        
        linInt.insertionSort();
        
        long startTime_ls = System.nanoTime();
        linInt.insertionSort();
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeSortOfSortedList_ls: " + ( stopTime_ls - startTime_ls ) + "," );
        return ( (stopTime_ls - startTime_ls) );

    }
    
    /**
     * timeLinearSearch method
     */
    public long timeLinearSearch_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        long startTime_al = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.linearSearch( randNum.nextInt() );
        }
        long stopTime_al = System.nanoTime();
               
        System.out.println( "timeLinearSearch_al: " + ( stopTime_al - startTime_al ) + "," );
        return ( (stopTime_al - startTime_al) ); 
    }
    
    /**
     * timeLinearSearch method
     */
    public long timeLinearSearch_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        long startTime_ls = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.linearSearch( randNum.nextInt() );
        }
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeLinearSearch_ls: " + ( stopTime_ls - startTime_ls ) + "," );
        return ( (stopTime_ls - startTime_ls) ); 
    }
    
    /**
     * timeBinarySearch method
     */
    public long timeBinarySearch_al( int numberOfItems, int seed )
    {
        ArrayListIntegerContainer arrInt = new ArrayListIntegerContainer();
        Random randNum = new Random( seed );
        
        //ArrayList time measure
        long startTime_al = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            arrInt.binarySearch( randNum.nextInt() );
        }
        long stopTime_al = System.nanoTime();
               
        System.out.println( "timeBinarySearch_al: " + ( stopTime_al - startTime_al ) + "," );
        return ( (stopTime_al - startTime_al) ); 
    }
    
    /**
     * timeBinarySearch method
     */
    public long timeBinarySearch_ls( int numberOfItems, int seed )
    {
        LinkedListIntegerContainer linInt = new LinkedListIntegerContainer();
        Random randNum = new Random( seed );
        
        //LinkedList time measure
        long startTime_ls = System.nanoTime();
        for( int i = 0; i < numberOfItems; i++ ){
            linInt.binarySearch( randNum.nextInt() );
        }
        long stopTime_ls = System.nanoTime();
        
        System.out.println( "timeBinarySearch_ls: " + ( stopTime_ls - startTime_ls ) + "," );
        System.out.println( " " );
        return ( (stopTime_ls - startTime_ls) ); 
    }
}
