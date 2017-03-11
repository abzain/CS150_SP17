import java.util.*;
import java.io.*;

/**
 * Class testSim - runs a simulation of the cafe
 * 
 * Construction: 5 parameters: availableCashiers, profit, 
 * cashierCost, avgNoCustArrPerMin, and avgNoCustServPerMin
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 * 
 */
public class testSim
{
    // instance variables - replace the example below with your own
    /**
     * static main method
     */
    public static void main( String[] args )
    {
        testSim s;

        for( int cashiers = 0; cashiers < 10; cashiers++ ){
            s = new testSim( cashiers, 2, 300, 1.5, 0.3 );
            s.runSim();
        }

        //         for( double lamda = 0; lamda < 2; lamda = lamda + 0.5 ){
        //             for( int cashiers = 0; cashiers < 10; cashiers++ ){
        //                 s = new testSim( cashiers, 2, 300, lamda, 0.3 );
        //                 s.runSim();
        //             }
        //         }

        //         s = new testSim( 10, 2, 300, 0.5, .3 );
        //         s.runSim();
    }

    /**
     * Constructor for objects of class testSim
     */
    public testSim( int s, double p, double c, double lamda, double r )
    {
        // initialise instance variables
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
    Queue<CustomerTracker> linCust = new LinkedList<CustomerTracker>();
    ArrayList<CustomerTracker> arrCust = new ArrayList<CustomerTracker>();
    int totalCust = 0;
    double startOfServe;
    int custInCafe = 0;
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
            double waitTime = 0;
            double serviceTime;
            double cafeTime;
            double departureTime = 0;
            double totWaitTime = 0;
            double avgWait = 0;
            double maxWait = 0;
            int j = 0;
            double serviceInterval = -( Math.log( u )/avgNoCustServPerMin );

            while( !eventSet.isEmpty() ){
                e = eventSet.remove();

                CustomerTracker b = new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                        startOfServe, serviceInterval);
                CustomerTracker c = new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                        startOfServe, serviceInterval);
                CustomerTracker d = new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                        startOfServe, serviceInterval);
                CustomerTracker k = new CustomerTracker(nextArriveTime, availableCashiers, totalCust,
                        startOfServe, serviceInterval);
                arrCust.add( b ); //everyone
                arrCust.add( c ); //everyone
                arrCust.add( d ); //everyone
                arrCust.add( k ); //everyone

                if( e.time > stopTime ){    //if time is passed stopTime, stop simulation
                    break;
                }

                custInCafe = arrCust.size();
                if( e.what == Event.ARRIVE ){
                    double enter = e.time;
                    if( custInCafe == 1 && availableCashiers > 0 ){   //queue empty                   
                        departureTime = serviceInterval;
                        startOfServe = nextArriveTime;
                        availableCashiers--;

                    }
                    else {
                        if( custInCafe == 1 && availableCashiers == 0 ){
                            linCust.add( arrCust.get(0) );   //add to queue
                        }
                        else if( custInCafe > 1 && availableCashiers > 0 ){   //customers in queue   
                            linCust.poll(); //retrieve and remove the head
                            startOfServe = e.time;
                            departureTime = serviceInterval + startOfServe;
                            availableCashiers--;

                        }
                        else if( custInCafe > 1 && availableCashiers == 0  ){   //store exceess customers in queue
                            linCust.add( arrCust.get(j) ); //with every nextArrivalTime
                        }
                        else{ //no customers at all, should not enter this state
                            break;
                        }
                    }

                    e = new Event( custNum++, departureTime, Event.DEPART );
                    eventSet.add( e );

                    //period between arrival and departure
                    cafeTime = ( departureTime - enter );
                    startOfServe = startOfServe;
                    waitTime = startOfServe - nextArriveTime;

                    e.time += cafeTime;
                    e.what = Event.DEPART;
                    eventSet.add( e );

                    System.out.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                        + departureTime + " is serviced for " + serviceInterval + " minutes " );
                    System.out.println( " at startServeTime of " + startOfServe + " and waited for " + waitTime + " ");
                    System.out.println( " " );

                    //print for output file
                    pWriter.println( "Customer " + e.who + " arrives at time " + enter + " departs at time "
                        + departureTime + " is serviced for " + serviceInterval + " minutes ");
                    pWriter.println( " at start serve time of " + startOfServe + " and waited for " + waitTime + " " );    
                    pWriter.println( " " );    

                    // total wait time
                    totWaitTime += waitTime;
                    avgWait = ( totWaitTime/totalCust );
                    //avgWait maxWait calculation
                    ArrayList<Double> waitTimeList = new ArrayList<Double>();  //arraylist of all waitTime
                    for( int i = 0; i < arrCust.size(); i++ )
                    {
                        waitTimeList.add( arrCust.get(i).getIsWait() );
                    }
                    maxWait =  Collections.max( waitTimeList );
                    nextArrival( avgNoCustArrPerMin );
                    j++;
                }   
                else{   //DEPART EVENT
                    //update available cashiers
                    availableCashiers++; 
                    j++;
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
            pWriter.println( "TurnedAway customers " + turnAway( availableCashiers ) );

            //avg wait time
            System.out.println( "Average waitTime " + avgWait + "|" );
            pWriter.println( "Average  waitTime" + avgWait );

            //max wait time
            System.out.println( "Max waitTime " + maxWait + "|" );
            pWriter.println( "Max waitTime " + maxWait );

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
        System.out.println( "TurnedAway customers " + cusTurnedAwayCnt );
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
