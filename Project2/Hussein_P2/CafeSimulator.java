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
    /**
     * static main method
     */
    public static void main( String[] args )
    {
        CafeSimulator s;
        //for( double lamda = 0.5; lamda < 2; lamda = lamda + .1 ){
        //for( int cashiers = 0; cashiers < 10; cashiers++ ){
        //                 s = new CafeSimulator( cashiers, 2, 300, lamda, 0.3 );
        //                 s.runSim();
        //}
        //}

        s = new CafeSimulator( 1, 2, 300, 0.5, 2 );
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
    int totalCust = 0;
    double startOfServe;
    int custInQueue = 0;
    /**
     * Run the simulation until stopping time occurs
     */
    public void runSim()
    {
        // write to output file
        File outFile = new File ("dataout.txt");

        //catch exception
        try{
            FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() ); 
            PrintWriter pWriter = new PrintWriter ( fWriter );

            Event e = null;
            double waitTime;
            double serviceTime;
            double cafeTime;
            double departureTime = 0;
            double totWaitTime = 0;
            double avgWait = 0;
            double maxWait = 0;
            double serviceInterval = -( Math.log( u )/avgNoCustServPerMin );
            while( !eventSet.isEmpty() ){
                e = eventSet.remove();
                System.out.println( "hello" );
                if( e.time == nextArriveTime){  //create new customer at each arrive event
                    arrCust.add( new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                                            startOfServe, serviceInterval) );
                }
                
                if( e.time > stopTime ){    //if time is passed stopTime, stop simulation
                    break;
                }
                
                //if queue is empty, and cahsiers >0, service time == departure time
                // at departure time, add depart event to priority queue
                for( CustomerTracker item : arrCust ){
                    linCust.add( item );    
                }
                
                custInQueue = linCust.size();
                if( availableCashiers > 0 ){
                    if( custInQueue == 0 ){   //queue empty
                        departureTime = serviceInterval + nextArriveTime;
                    }
                    else{   //customers in queue
                        startOfServe = e.time;
                        departureTime = serviceInterval + startOfServe + nextArriveTime;
                    }
                    //add departure event to priority queue
                    e = new Event( custNum++, departureTime, Event.DEPART );
                    eventSet.add( e );
                }
                else{   //no cashiers available
                    if( e.time == nextArriveTime ){
                        //add incoming customers to queue
                        linCust.add( new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                                            startOfServe, serviceInterval) );
                    }
                }
                
                if( e.what == Event.DEPART ){   //leave
                    //the departure time printed references this event
                    availableCashiers++;
                }
                else{   //arrive
                    double enter = e.time;
                    if( availableCashiers > 0 ){
                        availableCashiers--;
                        
                        //period between arrival and departure
                        cafeTime = ( departureTime + nextArriveTime );
                        waitTime = departureTime - startOfServe - nextArriveTime;
                        
                        e.time += cafeTime;
                        e.what = Event.DEPART;
                        eventSet.add( e );

                        System.out.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                            + departureTime + " is serviced for " + serviceInterval + " minutes " );
                        System.out.println( " at start serve time of " + startOfServe + " and waited for " + waitTime + " ");
                        System.out.println( " " );

                        //print for output file
                        pWriter.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                            + departureTime + " is serviced for " + serviceInterval + " minutes ");
                        pWriter.println( " at start serve time of " + startOfServe + " and waited for " + waitTime + " " );    
                        pWriter.println( " " );    

                        // total wait time
                        totWaitTime += waitTime;
                        
                        //avgWait calculation
                        avgWait = ( totWaitTime/totalCust );

                        //maxWait calculation
                        ArrayList<Double> waitTimeList = new ArrayList<Double>();  //arraylist of all waitTime
                        for( int i = 0; i < linCust.size(); i++ ){
                            waitTimeList.add( waitTime );
                        }
                        maxWait =  Collections.max( waitTimeList );
                    }
                    else{   //wait until cashier available by waiting in queue
                        linCust.add( new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                                            startOfServe, serviceInterval ) );

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
        catch( Exception e ){
            System.out.println(e);
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
        totalCust += custNum;
    }

    /**
     * Net profit method
     * @param - profit of serving each customer is p dollars
     */
    private double netProfit( double p, int s, double c )
    {
        double netProfit = ( ( p*totalCust ) - ( s*c ) );
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
        double totalProfit = ( p*totalCust ); 
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
        while( ( totalCust > 8*s) ){
            cusTurnedAwayCnt++;
        }
        System.out.println( "OVERLOAD! and No. of customers turned away " + cusTurnedAwayCnt );
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