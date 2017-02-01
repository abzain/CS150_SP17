import java.util.*;
import java.io.*;

/**
 * Write a description of class TextWriter here.
 * 
 * @author Zainab Hussein 
 * @version 1/25/2017
 */
public class TextWriter
{
    /**
     * Constructor for objects of class TextWriter
     */
    public TextWriter()
    {
        // initialise instance variables
    }

    /**
     * static class-method 
     */ 
    public static void main( String[] args )
    {
        TextWriter text = new TextWriter(); 
        text.input();
        //text.output();
    }
    
    /**
     * input method that reads in data from an input .txt file
     */
    public void input()
    {
        //input method variables
        double min;
        
        File inFile = new File( "datain.txt" );
        
        //catch exception
        try{
            Scanner scan = new Scanner( inFile ); //throws IO exception
            Scanner scan2 = new Scanner( inFile );
            //read first word of each line
            while( scan2.hasNextLine() ){
                scan2 = new Scanner(scan2.nextLine() );
                while( scan2.hasNextLine() ){
                    String s = scan2.next();
                    System.out.println( "general item class :" + s );
                    
                }
            }
            
            //min price and cheapest item
            while( scan.hasNext() ) { 
                //read list of prices and find the min
                double price1 = scan.nextDouble();
                double price2 = scan.nextDouble();
                double price3 = scan.nextDouble();
                double price4 = scan.nextDouble();
                
                if( price1<price2 && price1<price3 && price1<price4 ){
                    min = price1;
                }
                else if( price2<price1 && price2<price3 && price2<price4 ){
                    min = price2;
                }
                else if( price3<price1 && price3<price2 && price3<price4 ){
                    min = price3;
                }
                else{
                    min = price4;
                }
                
                //read cheapest item
                //String cheapest_item = 
               // scan.findInLine( "(\\s+) Double.valueOf( min ) (\\w+)" );
                /**
                 * want to read the first word of each line
                 * 
                 * want to read the doubles of each line and compare to find min
                 * 
                 * want to read the string before the min in an if statement
                 */
                //find min 
//                 for( int i=0; i<read; i++ ){
//                     if( i==0 && read>0 ){
//                         cheapest = read;
//                        }
//                     if( read < cheapest ){
//                         cheapest = read;
//                        }
//                    }
                //check expected value and if above method works
                //System.out.println( "show my expected cheap value :" + cheapest );
                
            }
            scan.close();
        }
        catch( Exception e ){
            System.out.println( e );
        }
    }
    
//     /**
//      * output method that writes and prints read data into an output .txt file
//      */
//     public void output()
//     {
//         File outFile = new File ( "dataout.txt" ); //throws IO exception
//         
//         //catch exception
//         try{
//             FileWriter written = new FileWriter( outFile.getAbsoluteFile() );
//             PrintWriter printed = new PrintWriter ( written );
//             
//             //output on outfile
//             printed.println( "the cheapest writting tool is " + written );
//             printed.println( "the cheapest flight is " + written );
//             printed.println( "the cheapest bottled water is " + written );
//             printed.println( "the cheapest color is " + written );
//             printed.println( "the cheapest laptop is " + written );
//             /**
//              * assuming the written is a price value rather than name of the
//              * product (aware that written = address of value of written)
//              */
//             printed.close();
// 
//         }
//             catch(Exception e){
//             System.out.println(e);
//          }
// 
//     }
}
