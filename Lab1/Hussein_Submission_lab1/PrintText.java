import java.util.*;
import java.io.*;

/**
 * Class PrintText reads a list of type string and int from an input file
 * containing the family name of the items, followed by the specific items 
 * and their prices in each line. 
 * 
 * This lab expects the read method to iterate through each line to find the 
 * cheapest item in a given family of items. The write method prints to an output 
 * file a statement of what the cheapest item is for any given class of items. 
 * 
 * @author Zainab Hussein
 * @version 1/29/2017
 */
public class PrintText {

    public PrintText() {
        // initialise instance variables ables
    }

    /**
     * static class-method 
     */ 
    public static void main(String[] args) {
        //give some Arraylists to store the lowest price and item in each class
         ArrayList<String> class_name = new ArrayList<String>();
         ArrayList<Integer> lowest_price = new ArrayList<Integer>(); // actually has no use
         ArrayList<String> item = new ArrayList<String>();
         
         // read method
         File inFile = new File("data_read.txt");
         
         //catch exception
        try {
            Scanner in_file = new Scanner( inFile );
            while(in_file.hasNextLine()) 
            {
               //taking one line(class of items) as a case, solve it, and go to next
               String whole_class = in_file.nextLine();
               Scanner in_line = new Scanner(whole_class);
               
               if(in_line.hasNext()){
                   //get the class name first 
                   String item_class = in_line.next();
                   
                   //create structure to store values for comparison
                   ArrayList<String> item_name = new ArrayList<String>();
                   ArrayList<Integer> item_price = new ArrayList<Integer>();
                   
                   //an item and its price will have the same index 
                   while(in_line.hasNext()){
                        item_name.add(in_line.next());
                        item_price.add(in_line.nextInt());
                    }
                    
                   //compare and store
                   //get the index of the cheapest item and use the index to get its name
                   int min_index= item_price.indexOf(Collections.min(item_price));
                   lowest_price.add(item_price.get(min_index));
                   
                   //class name and the cheapest item in that class will has the same index
                   class_name.add(item_class);
                   item.add(item_name.get(min_index));
               }
               in_line.close();
            }
             in_file.close();
         }
         catch( Exception e ) { 
                System.out.println(e);
        }
         
         //write method
        File outFile = new File ("data_write.txt");
        
        //catch exception
        try{
            FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() );
            PrintWriter pWriter = new PrintWriter ( fWriter );
            for( int i=0; i<class_name.size(); i++ ){
                pWriter.println ("The cheapest "+ class_name.get(i) + " is " + item.get(i));
            }
            pWriter.close();

         }
         catch(Exception e){
             System.out.println(e);
         }
    }

}

