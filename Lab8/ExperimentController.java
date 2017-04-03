
/**
 * Class ExperimentController -  inserts 100 Integers into a Heap 
 * and then prints them out by removing them one at a time.
 * 
 * @author Zainab Hussein
 * @version 3-31-2017
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    /**
     * static main class
     */
    public static void main( String[] args )
    {
        Heap<Integer> tester = new Heap<Integer>();
        for( int i = 0; i < 100; i++ ){
            //inserted not in right order
            tester.insert( i );
            //root is not updated after removal
            System.out.println( "Removed integer :" + tester.removeMin() );
        }
    }
}
