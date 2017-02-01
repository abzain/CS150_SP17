import java.util.*;
import java.io.*;
import java.lang.Object;
/**
 * the link to the lab is here: I am done with part 1, now working on part 2
 * https://docs.google.com/document/d/1xLaLN3M2FT1Wbxbil1k1N5_GOAj3IanTf_1vKU5lzMc/pub
 */
/**
 * Write a description of class TextPrinter here.
 * 
 * @author Zainab Hussein
 * @version 1/28/2017
 */
public class TextPrinter
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class TextPrinter
     */
    public TextPrinter()
    {
        // initialise instance variables
    }

    /**
     * static class-method 
     */ 
    public static void main( String[] args ) throws IOException
    {
        TextPrinter text = new TextPrinter(); 
        text.input();
        //text.output();
    }
    
    /**
     * input method that reads in data from an input .txt file
     */
    public void input()
    {
        //input method variables
        File inFile = new File( "datain.txt" );
        Scanner scan = new Scanner( inFile ); //throws IO exception
        //catch exception
        try{
            /**
             * multiple type array discussion in stackoverflow
             */
//             while( scan.nextInt() ){
//                 Object[] numbers = new Object[]{scan.nextInt() };
//                 int min_num = getMinValue( numbers );
//                 //int min_num_index = get
//             }
            
            /**
             * Use arraylist instead of array
             * example from stackoverflow
             */
//             while( scan.hasNextInt() ){
//                 ArrayList<Integer> num = new ArrayList<Integer>( scan.nextInt() );
//                 //int min_num = getMinValue( numbers );
//                 int min_num_index = num.indexOf( Collections.min(num));
//             }
            
//             while( scan.hasNext() ){
//                 ArrayList<String> inputs = new ArrayList<String>( scan.next() );
//                 //item class
//                 String item_class = inputs.get(0);
//                 System.out.println( "item class :" + item_class );
//                 //cheapest item
//                 String cheapest_item = inputs.get(min_num-1);                     
//                 System.out.println( "cheapest item :" + cheapest_item );
//             }
            
            while( scan.hasNext() ){
               
                ArrayList num = new ArrayList( scan.nextInt() );
                //int min_num = getMinValue( numbers );
                int min_num_index = num.indexOf( Collections.min(num));
               
                
                Object[] inputs = new Object[]{ scan.next() };
                for( int i=0; i<inputs.length; i++){
                    String item_class = inputs[0].toString();
                    System.out.println( "item class :" + item_class );
                    
                    String cheapest_item = inputs[min_num_index-1].toString();
                    System.out.println( "cheapest item :" + cheapest_item );
                }
                scan.close();
            }
        }
        catch( Exception e ){
            System.out.println( e );
        }
    }
    
//     /**
//      * get the min value
//      * 
//      * Algorithm taken from stackoverflow by Blubberguy22
//      */
//     public static int getMinValue( int[] array )
//     {
//         int min = array[0];
//         for( int i=1; i<array.length; i++ ){
//             if( array[i] < min ){
//                 min = array[i];
//             }
//         }
//         return min;
//     }
}
