import java.util.*;
import java.io.*;

/**
 * Class ExperimentController evaluates performance of both merge
 * and quick sort for COntactList and WorkerList classes
 * 
 * @author Zainab Hussein
 * @version 2/25/2017
 * 
 * NOTE: MergeSort has error at sections commented in SortedList,
 * Quicksort works fine
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
     * static main method for lab 5
     */
    public static void main (String[] args )
    {
        ContactList test = new ContactList( );
        
        //add contact objects
        Contact a = new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                                  "245-356-5874" );
        Contact b = new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                                  "586-356-5874" );
        Contact c = new Contact( "Simmone", "Amina", "amina@gmail.com", 
                                  "865-356-5874" );
        Contact d = new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                                  "725-356-5874" );
        Contact e = new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                                  "305-356-5874" );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //mergesort data
        //sort based on comparable last name then first name
        //test.mergeSort();
        
        for (int i = 0 ; i < 5; i++) {
            System.out.println(test.getValue(i).getLastName());
        }
//         ExperimentController exp = new ExperimentController();
// 
//         //write out
//         File outFile = new File ("dataout.txt");
//         //catch exception
//         try{
//             FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() );
//             PrintWriter pWriter = new PrintWriter ( fWriter );
// 
//             //checking 15000 different number of items
//             for( int numberOfItems = 1000; numberOfItems < 11000; 
//             numberOfItems = (numberOfItems + 1000) ){
//                 pWriter.println( " " );
//                 //pWriter.print( exp.timeMergeSort_C( numberOfItems ) + "," );
//                 //pWriter.print( exp.timeMergeSort_W( numberOfItems ) + "," );
//                 pWriter.print( exp.timeQuickSort_C( numberOfItems ) + ",");
//                 pWriter.print( exp.timeQuickSort_W( numberOfItems ) + ",");
// 
//             }
//             pWriter.close();
//         }
//         catch(Exception e){
//             System.out.println(e);
//         }
    }

    //     /**
    //      * mergeSort in ContactList
    //      */
    //     public long timeMergeSort_C( int numberOfItems )
    //     //length is the number of characters of the randomString
    //     {
    //         ContactList contact = new ContactList();
    //         
    //         //time measure
    //         for( int i = 0; i < numberOfItems; i++ ){
    //             contact.addElement(new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
    //                                       "245-356-5874" ));
    //             contact.addElement(new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
    //                                       "586-356-5874" ));
    //             contact.addElement( new Contact( "Simmone", "Amina", "amina@gmail.com", 
    //                                       "865-356-5874" ));
    //             contact.addElement( new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
    //                                       "725-356-5874" ));
    //             contact.addElement( new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
    //                                       "305-356-5874" ));
    //         }
    //         
    //         long start = System.nanoTime();
    //         contact.mergeSort();
    //         long stop = System.nanoTime();
    //         
    //         System.out.println( "timeMergeSort_C: " + (stop-start) + "," );
    //         return (stop-start);
    //     }
    //     
    //     /**
    //      * mergerSort in WorkerList
    //      */
    //      public long timeMergeSort_W( int numberOfItems )
    //     {
    //         WorkerList worker = new WorkerList();
    //                 
    //         //time measure
    //         for( int i = 0; i < numberOfItems; i++ ){
    //             worker.addElement(new Worker( "Julian", "Winslow", 65L  ));
    //             worker.addElement(new Worker( "Nathan", "Kariuki", 25L ));
    //             worker.addElement( new Worker( "Simmone", "Amina", 4L ));
    //             worker.addElement( new Worker( "Amaar", "Gismala", 63L ));
    //             worker.addElement( new Worker( "Juju", "Theodr", 14L ));
    //         }
    //         
    //         long start = System.nanoTime();
    //         worker.mergeSort();
    //         long stop = System.nanoTime();
    //         
    //         System.out.println( "timeMergeSort_W: " + (stop-start) + "," );
    //         return (stop-start);
    //     }
    //     
    /**
     * quickSort in ContactList
     */
    public long timeQuickSort_C( int numberOfItems )
    {
        ContactList contact = new ContactList();

        //time measure
        for( int i = 0; i < numberOfItems; i++ ){
            contact.addElement(new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                    "245-356-5874" ));
            contact.addElement(new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                    "586-356-5874" ));
            contact.addElement( new Contact( "Simmone", "Amina", "amina@gmail.com", 
                    "865-356-5874" ));
            contact.addElement( new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                    "725-356-5874" ));
            contact.addElement( new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                    "305-356-5874" ));
        }

        long start = System.nanoTime();
        contact.quickSort();
        long stop = System.nanoTime();

        System.out.println( "timeQuickSort_C: " + (stop-start) + "," );
        return (stop-start);
    }

    /**
     * quickSort in WorkerList
     */
    public long timeQuickSort_W( int numberOfItems )
    {
        WorkerList worker = new WorkerList();

        //time measure
        for( int i = 0; i < numberOfItems; i++ ){
            worker.addElement(new Worker( "Julian", "Winslow", 65L  ));
            worker.addElement(new Worker( "Nathan", "Kariuki", 25L ));
            worker.addElement( new Worker( "Simmone", "Amina", 4L ));
            worker.addElement( new Worker( "Amaar", "Gismala", 63L ));
            worker.addElement( new Worker( "Juju", "Theodr", 14L ));
        }

        long start = System.nanoTime();
        worker.quickSort();
        long stop = System.nanoTime();

        System.out.println( "timeQuickSort_W: " + (stop-start) + "," );
        return (stop-start);
    }

}
