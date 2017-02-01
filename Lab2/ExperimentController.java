import java.util.*;

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
        
        exp.timeAddToFront( 10000, 86 );
        exp.timeAddToBack( 10000, 86 );
        exp.timeAddSorted( 10000, 86 );
        exp.timeSortOfUnsortedList( 10000, 86 );
        exp.timeSortOfSortedList();
                
    }

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
        
        System.out.println( "timeAddToBack: " + ( stopTime - startTime ) );
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
        
        System.out.println( "timeAddSorted: " + ( stopTime - startTime ) );
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
        
        System.out.println( "timeSortOfUnsortedList: " + ( stopTime - startTime ) );
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
        
        System.out.println( "timeSortOfSortedList: " + ( stopTime - startTime ) );
        System.out.println( " " );
        return ( stopTime - startTime );
    }
}
