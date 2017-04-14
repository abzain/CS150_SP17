import java.util.*;
/**
 * Write a description of class DrawPhoneNum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawPhoneNum
{
    // instance variables - replace the example below with your own
    private ArrayListPhoneBase A;
    private RedBlackTreePhoneBase B;
    private HashSetPhoneBase C;
    private Random rand;
    /**
     * Constructor for objects of class DrawPhoneNum
     */
    public DrawPhoneNum()
    {
        // initialise instance variables
        A = new ArrayListPhoneBase();
        B = new RedBlackTreePhoneBase();
        C = new HashSetPhoneBase();
    }
    
    public static void main( String[] arg )
    {
        DrawPhoneNum draw = new DrawPhoneNum();
        draw.timeArr_1( 20, 44 );
        draw.timeArr_0_1( 20, 44 );
        draw.timeArr_0_0_1( 20, 44 );
        draw.timeHash_1( 20, 44 );
        draw.timeHash_0_1( 20, 44 );
        draw.timeHash_0_0_1( 20, 44 );
        draw.timeRed_1( 20, 44 );
        draw.timeRed_0_1( 20, 44 );
        draw.timeRed_0_0_1( 20, 44 );
    }
    
    /**
     * ArrayList Test when 1% operations are select's
     */
    public long timeArr_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.01*numItems; j++ ){
                for( int k=0; k<0.99*numItems; k++ ){
                    //randomly generated long values
                    A.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.99numItems]
                A.select( rand.nextInt( numItems ));    
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by ArrayList for 1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations."  );
        //return time
        return (stop-start);
    }
    
    /**
     * ArrayList Test when 0.1% operations are select's
     */
    public long timeArr_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.001*numItems; j++ ){
                for( int k=0; k<0.999*numItems; k++ ){
                    //randomly generated long values
                    A.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.999numItems]
                A.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by ArrayList for 0.1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
    
    /**
     * ArrayList Test when 0.01% operations are select's
     */
     public long timeArr_0_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.0001*numItems; j++ ){
                for( int k=0; k<0.9999*numItems; k++ ){
                    //randomly generated long values
                    A.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.9999numItems]
                A.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by ArrayList for 0.01% select: " + (stop-start)+ " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
    
    /**
     * RedBlackTree Test when 1% operations are select's
     */
    public long timeRed_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.01*numItems; j++ ){
                for( int k=0; k<0.99*numItems; k++ ){
                    //randomly generated long values
                    B.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.99numItems]
                B.select( rand.nextInt( numItems ));    
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by RBT for 1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations."  );
        //return time
        return (stop-start);
    }
    
    /**
     * RedBlackTree Test when 0.1% operations are select's
     */
    public long timeRed_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.001*numItems; j++ ){
                for( int k=0; k<0.999*numItems; k++ ){
                    //randomly generated long values
                    B.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.999numItems]
                B.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by RBT for 0.1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
    
    /**
     * RedBlackTree Test when 0.01% operations are select's
     */
     public long timeRed_0_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.0001*numItems; j++ ){
                for( int k=0; k<0.9999*numItems; k++ ){
                    //randomly generated long values
                    B.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.9999numItems]
                B.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by RBT for 0.01% select: " + (stop-start)+ " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
    
    /**
     * HashSet Test when 1% operations are select's
     */
    public long timeHash_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.01*numItems; j++ ){
                for( int k=0; k<0.99*numItems; k++ ){
                    //randomly generated long values
                    C.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.99numItems]
                C.select( rand.nextInt( numItems ));    
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by HashSet for 1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations."  );
        //return time
        return (stop-start);
    }
    
    /**
     * HashSet Test when 0.1% operations are select's
     */
    public long timeHash_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.001*numItems; j++ ){
                for( int k=0; k<0.999*numItems; k++ ){
                    //randomly generated long values
                    C.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.999numItems]
                C.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by HashSet for 0.1% select: " + (stop-start) + " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
    
   
    /**
     * HashSet Test when 0.01% operations are select's
     */
     public long timeHash_0_0_1( int numItems, int seed )
    {
        //generate random numbers
        rand = new Random( seed );
        //simulate for the specified number of items
        long start = System.currentTimeMillis();
        for( int i=0; i<numItems; i++ ){
            for( int j=0; j<0.0001*numItems; j++ ){
                for( int k=0; k<0.9999*numItems; k++ ){
                    //randomly generated long values
                    C.add( rand.nextLong() );
                }
                //randomly chosen indices (0,.9999numItems]
                C.select( rand.nextInt( numItems ));     //rand.nextInt( numItems*(int).01 ) );
            }
        }
        long stop = System.currentTimeMillis();
        //see in terminal
        System.out.println( "Time taken by HashSet for 0.01% select: " + (stop-start)+ " ms" + " for: " + numItems + " 0perations." );
        //return time
        return (stop-start);
    }
}
