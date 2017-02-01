import java.util.*;

//import Lab6.Life;

import java.io.*;

public class PrintText {

	public PrintText() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	   	//give some Arraylists to store the lowest price and item in each class
		 ArrayList<String> class_name = new ArrayList<String>();
		 ArrayList<Integer> lowest_price = new ArrayList<Integer>(); // actually has no use
		 ArrayList<String> item = new ArrayList<String>();
		 // create input and output files
		 File inFile = new File("lab1_read.txt");
	     try {
	        Scanner in_file = new Scanner( inFile );
	        while(in_file.hasNextLine()) 
	        {
	           //take one line(class of items) as a case, solve it, and go next
	           String whole_class = in_file.nextLine();
	           Scanner in_line = new Scanner(whole_class);
	           if(in_line.hasNext()){
	        	   //get the class name first is better than mix it together with item name
	        	   String item_class = in_line.next();
	        	   //create structure to store values for comparison
	        	   //name is OK to be stored by String, you don't have to use Object
	        	   //a item and its price will have the same index 
		           ArrayList<String> item_name = new ArrayList<String>();
	        	   ArrayList<Integer> item_price = new ArrayList<Integer>();
		           while(in_line.hasNext()){
		        	  item_name.add(in_line.next());
		        	  item_price.add(in_line.nextInt());
		        	//the for loop should not be in the read in while, or it will always print the same thing
		           }
		           //compare and store
		           //get the index of the cheapest item and use the index to get its name
		           //class name and the cheapest item in that class will has the same index
		          int min_index= item_price.indexOf(Collections.min(item_price));
		          class_name.add(item_class);
		          lowest_price.add(item_price.get(min_index));
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
	 	File outFile = new File ("lab1_write.txt");
		try{
	        FileWriter fWriter = new FileWriter (outFile.getAbsoluteFile());
		    PrintWriter pWriter = new PrintWriter (fWriter);
		    for(int i=0;i<class_name.size();i++){
		    	pWriter.println ("The cheapest "+ class_name.get(i) + " is " + item.get(i));
		    }
		    pWriter.close();

		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	}

}

