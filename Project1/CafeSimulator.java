import java.util.*;
import java.io.*;

/**
 * Class CafeSimulator - runs a simulation of the cafe
 * 
 * Construction: 5 parameters: availableCashiers, profit, 
 * cashierCost, avgNoCustArrPerMin, and avgNoCustServPerMin
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 * 
 */
public class CafeSimulator
{
    // instance variables - replace the example below with your own
    //private int x;
    
    /**
     * quick test
     */
    public static void main( String[] args )
    {
        CafeSimulator s = new CafeSimulator( 5,16.3,2.3,1.0,2.0);
        s.runSim();
        
//         File outFile = new File ("dataout.txt");
        
//         //catch exception
//         try{
//             FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() );
//             PrintWriter pWriter = new PrintWriter ( fWriter );
//             
//             //sim.runSim( 960 );  runs for a long time
//             
//             //checking 10 different seeds per number of items
// //             pWriter.println( " " );
// //             pWriter.println( sim.arriving( 1.0 ) + "," );
// //             pWriter.println( sim.joinQueue() + "," );
// //             pWriter.println( sim.waiting() + "," );
// //             pWriter.println( sim.serving( 2.0 ) + "," );
// //             pWriter.println( sim.departing( 1.0, 2.0 ) + "," );
// //             pWriter.println( sim.turnAway( 1.0, 5 ) + "," );
//               pWriter.println( s.runSim() );      
//           
//             pWriter.close();
//         }
//         
//         catch(Exception e){
//              System.out.println(e);
//         }
    }
    
    /**
     * Constructor for objects of class CafeSimulator
     */
    public CafeSimulator(  int s, double p, double c, double lamda, double r )
    {
        // initialise instance variables
        eventSet            = new PriorityQueue<Event>();
        availableCashiers   = s;
        profit              = p;
        cashierCost         = c;
        avgNoCustArrPerMin  = lamda;
        avgNoCustServPerMin = r;

        //schedule first arrival
        nextArrival( avgNoCustArrPerMin );
    }
    double stopTime = 960;
    
    /**
     * Run the simulation until stopping time occurs
     */
    public void runSim()
    {
        // put your code here
        Event e = null;
        double waitTime;
        double serviceTime;
        

        while( !eventSet.isEmpty() ){
            e = eventSet.remove();

            //if time is passed stopTime, stop simulation
            if( e.time > stopTime ){
                break;
            }

            if( e.what == Event.DEPART ){   //leave
                availableCashiers++;
                System.out.println( "Customer " + e.who + " departs at " + e.time + " " );
                
                e.what = Event.ARRIVE;
                eventSet.add( e );
            }
            else{   //arrive
                System.out.print( "Customer " + e.who + " arrives at " + e.time + " " );
                if( availableCashiers > 0 ){
                    availableCashiers--;
                    double serviceInterval = -( Math.log( u )/avgNoCustServPerMin );
                    //serviceTime = nextArrivalTime + serviceInterval;
                    if( custNum == 0 ){
                        waitTime = 0;
                    }
                    else{
                        waitTime = serviceInterval;
                        //waitTime = serviceTime - nextArrivalTime;
                    }
                    //double departTime = (nextArrivalTime+serviceTime);
                    System.out.println( " and waits for " + waitTime + " minutes " );
                   

                    e.time += serviceInterval;
                    e.what = Event.DEPART;
                    eventSet.add( e );
                    //                     System.out.println( "Customer " + e.who + " arrives at " + nextArrivetime + " departs at "
                    //                                             + departTime + " service " + serviceInterval + " served by " +
                    //                                                serviceTime + " waited " + waitTime + " ");
                    
                }
                else{
                    System.out.println( "OVERFLOW!" );
                }
                nextArrival( avgNoCustArrPerMin );
            }
        }
    }

    private int custNum = 0;
    private double nextArriveTime = 0;
    private double arriveTime;
    /**
     * Add an arrival to eventSet at the current time,
     * and schedule one for arriveTime in future.
     * 
     * Place a new ARRIVE event into the event queue.
     * Then advance the time when next ARRIVE event will occur.
     * ArriveTime follows a poisson distribution
     */
    private void nextArrival( double lamda )
    {
        Event ev = new Event( custNum++, nextArriveTime, Event.ARRIVE );
        eventSet.add( ev );
        arriveTime = -( Math.log( u )/lamda );
        nextArriveTime += arriveTime;
        
        //CustomerTracker A = new CustomerTracker( nextArriveTime, stopTime );
    }

    private PriorityQueue<Event> eventSet;  //Pending events
    private double u = Math.random();;

    //basic parameters of the simulation
    private int availableCashiers;      //number of available cashiers
    private double profit;              //total profit
    private double cashierCost;         //cost per cashier
    private double avgNoCustArrPerMin;  //average numver of customers arriving per minute
    private double avgNoCustServPerMin; //average number of customers served per minute

    /**
     * The event class
     * Implements the Comparable interface
     * to arrange events by time of occurence
     * (Nested in CafeSimulator)
     */ 
    private static class Event implements Comparable<Event>
    {
        static final int ARRIVE = 1; 
        static final int DEPART = 2;      
        //static final double TurnedAway = 6;

        /**
         * Constructor for objects of class Operations
         * calls second constructor
         */
        public Event()
        {
            //call second constructor
            this( 0, 0, ARRIVE );   //customer id, time, type of event
        }

        public Event(int name, double tm, int type)
        {
            who = name;
            time = tm;
            what = type;
        }

        public int compareTo( Event rhs )
        {
            //primitive to reference type double
            Double evTime = this.time;
            Double inputTime = rhs.time;

            return evTime.compareTo( inputTime );
        }

        //basic parameters of operation
        int who;        //the number of the user       
        double time;    //when event will occur
        int what;       //type of operation ARRIVE or DEPART
    }
}
