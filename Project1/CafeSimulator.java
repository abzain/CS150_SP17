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
    // write to output file
    File outFile = new File ("dataout.txt");
    FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() ); throw new IOException;
    PrintWriter pWriter = new PrintWriter ( fWriter );
    
    /**
     * static main method
     */
    public static void main( String[] args )
    {
        CafeSimulator s = new CafeSimulator( 5,16.3,2.3,1.0,2.0);
        s.runSim();

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

    double stopTime = 10;
    Queue<CustomerTracker> linCust = new LinkedList<CustomerTracker>();
    ArrayList<CustomerTracker> arrCust = new ArrayList<CustomerTracker>();
    /**
     * Run the simulation until stopping time occurs
     */
    public void runSim()
    {
        // put your code here
        Event e = null;
        double waitTime;
        double serviceTime;
        double cafeTime;
        double totWaitTime = 0;
        double avgWait = 0;
        double maxWait = 0;
        while( !eventSet.isEmpty() ){
            e = eventSet.remove();

            for( int j = 0; j <= custNum; j++ ){
                arrCust.add( new CustomerTracker(nextArriveTime, stopTime, avgNoCustServPerMin) );
            }

            //if time is passed stopTime, stop simulation
            if( e.time > stopTime ){
                break;
            }

            if( e.what == Event.DEPART ){   //leave
                //the departure time printed references this event
                availableCashiers++;
                linCust.remove();
            }
            else{   //arrive
                double enter = e.time;
                //add customers to queue
                for( CustomerTracker item : arrCust ){
                    linCust.add( item );    
                }

                if( availableCashiers > 0 ){
                    availableCashiers--;

                    //period between arrival and departure
                    double serviceInterval = -( Math.log( u )/avgNoCustServPerMin );
                    arriveTime = -( Math.log( u )/avgNoCustArrPerMin );

                    serviceTime = nextArriveTime + serviceInterval;
                    cafeTime = ( arriveTime + serviceInterval );
                    if( e.who == 0 ){   //if it's first customer, service time == arrival time
                        waitTime = 0;
                    }
                    else{
                        waitTime = serviceInterval; //serviceTime - nextArriveTime
                    }
                    double departTime = ( nextArriveTime + waitTime + serviceInterval );

                    e.time += cafeTime;
                    e.what = Event.DEPART;
                    eventSet.add( e );

                    System.out.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                                        + departTime + " is serviced for " + serviceInterval + " minutes " );
                    System.out.println( " is served by time " + serviceTime + " and waited for " + waitTime + " ");
                    System.out.println( " " );
                    
                    //print for output file
                    pWriter.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                        + departTime + " is serviced for " + serviceInterval + " minutes " );
                    pWriter.println( " " );    
                    
                    // total wait time
                    totWaitTime += waitTime;

                    //avgWait calculation
                    avgWait = ( totWaitTime/linCust.size() );

                    //maxWait calculation
                    ArrayList<Double> waitTimeList = new ArrayList<Double>();  //arraylist of all waitTime
                    for( int i = 0; i < linCust.size(); i++ ){
                        waitTimeList.add( waitTime );
                    }
                    maxWait =  Collections.max( waitTimeList );
                }
                else{
                    System.out.println( "Customer " + e.who + " OVERFLOW!" );
                    
                    //print for output file
                    pWriter.println( "Customer " + e.who + " OVERFLOW!" );
                }
                nextArrival( avgNoCustArrPerMin );
            }
        }
        //total profit
        totalProfit( profit );
        pWriter.println( "Total profit " + totalProfit( profit ) );
        
        //cost of  cashier
        cashierCost( availableCashiers, cashierCost );
        pWriter.println( "Total cashier cost " + cashierCost( availableCashiers, cashierCost ) );
        
        //net profit
        netProfit( profit,availableCashiers,cashierCost );
        pWriter.println( "Net profit " + netProfit( profit,availableCashiers,cashierCost )  );
        
        //customers turned away 
        turnAway( availableCashiers );
        pWriter.println( "Turned away customers " + turnAway( availableCashiers ) );
        
        //avg wait time
        System.out.println( "Average wait time " + avgWait + "|" );
        pWriter.println( "Average wait time " + avgWait );
        
        //max wait time
        System.out.println( "Max wait time " + maxWait + "|" );
        pWriter.println( "Max wait time " + maxWait );

        pWriter.close();
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

    /**
     * Net profit method
     * @param - profit of serving each customer is p dollars
     */
    private double netProfit( double p, int s, double c )
    {
        double netProfit = ( ( p*custNum ) - ( s*c ) );
        System.out.print( "Net profit " + netProfit + " | " );
        return netProfit;
    }

    /**
     * Total cashier cost method
     * @param - cost of employing cashiers
     */
    private double cashierCost( int s, double c )
    {
        double costOfCashier = ( s*c );
        System.out.print( "Total cashier cost " + costOfCashier + " | " );
        return costOfCashier;
    }

    /**
     * Total profit method
     * @param - total profit for the day
     */
    private double totalProfit( double p )
    {
        double totalProfit = ( p*custNum ); 
        System.out.println( " " );
        System.out.println( "Total profit " + totalProfit + " | " );
        return totalProfit;
    }

    /**
     * Method to calculate total number of customers turned away
     * @param - custNo turned away
     */
    private int turnAway( int s )
    {
        int cusTurnedAwayCnt = 0;
        while( ( custNum > 8*s) || (nextArriveTime == stopTime) ){
            cusTurnedAwayCnt++;
        }
        System.out.println( "No. of customers turned away " + cusTurnedAwayCnt );
        return cusTurnedAwayCnt;
    }

    private PriorityQueue<Event> eventSet;  //Pending events
    private double u = Math.random();

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