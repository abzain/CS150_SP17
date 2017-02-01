import java.util.*;
import java.io.*;
/**
 * Write a description of class FileWriter here.
 * 
 * @author Zainab Hussein 
 * @version 1/24/2017
 */
public class Writer
{
    /**
     * Constructor for objects of class FileWriter
     */
    public Writer()
    {
        // initialise instance variables
    }

    public static void main( String[] args )
    {
        Writer write = new Writer(); //throws IO exception
        write.input();
        write.output();
    }
    
    public void input()
    {
        Scanner scan = null;
        try{
            scan = new Scanner( new FileReader( "datain.txt" ) );
            while( scan.hasNextFloat() ){
                float number = scan.nextFloat();
                int numberInt = new Integer( number );
                int cheapestInt;
                
                for( int i=0; i<numberInt; i++ ){
                    if( i==0 && numberInt>0 ){
                        cheapestInt = numberInt;
                    }
                    
                    if( numberInt < cheapestInt ){
                        cheapestInt = numberInt;
                    }
                }
                System.out.println( Float.valueOf( cheapestInt ) );
                
            }
            scan.close();
        }
        catch( Exception e ){
            System.out.println( e );
        }
    }
    
    public void output()
    {
        try{
            FileWriter written = new FileWriter( new FileWriter( "dataout" ) );
            PrintWriter print = new PrintWriter( written );
            while( written.hasNext() ){
                print.println( "the cheapest writting tool is " + written.next() );
                print.println( "the cheapest flight is " + written.next() );
                print.println( "the cheapest bottled water is " + written.next() );
                print.println( "the cheapest color is " + written.next() );
                print.println( "the cheapest laptop is " + written.next() );
            }
            print.close();
       }
       catch( Exception e ){
           System.out.println( e );
       }
    }
}
