import java.util.*;
import java.io.*;
import java.lang.Object;

/**
 * Write a description of class PrintText here.
 * 
 * @author Zainab Hussein
 * @version 1/28/2017
 */
public class PrintText_old
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class PrintText
     */
    public PrintText_old()
    {
        // initialise instance variables
      }

    /**
     * static class-method 
     */ 
    public static void main( String[] args ) //throws IOException
    {
        PrintText_old text = new PrintText_old(); 
        
        //catch exception
        try{
            File inFile = new File( "datain.txt" ); //throws IO exception
            Scanner scan = new Scanner( inFile ); 
            String item_class = null;
            String cheapest_item = null;
            while( scan.hasNext() ){
                //arraylist to find the index of min price
                ArrayList num = new ArrayList( scan.nextInt() );
                int min_num_index = num.indexOf( Collections.min(num));
                
                //array to get the item class and cheapest item
                Object[] inputs = new Object[]{ scan.next() };
                for( int i=0; i<inputs.length; i++){
                    item_class = inputs[0].toString();
                    System.out.println( "item class :" + item_class );
                    
                    cheapest_item = inputs[min_num_index-1].toString();
                    System.out.println( "cheapest item :" + cheapest_item );
                }
                scan.close();
                
            }
            
            File outFile = new File( "dataout.txt" );
            FileWriter written = new FileWriter( outFile.getAbsoluteFile() );
            PrintWriter print = new PrintWriter( written );
            while( written != null ){
                print.println( "the cheapest " + item_class +
                "is " + cheapest_item);
            }
            print.close();
        }
        catch( Exception e ){
            System.out.println( e );
        }

    }
}
