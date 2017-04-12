import java.util.*;
import java.io.*;

/**
 * Class Simulator runs a simulation of the cafe
 * 
 * @author Zainab Hussein with modification from Cameron Zurmul
 * @version 3-2-2017
 * 
 */
public class Simulator
{
    // instance variables 
    private PriorityQueue<Event> eventSet;  //Pending events
    private double u = Math.random();   //random double between 0 and 1
    private int availableCashiers;      //number of available cashiers
    private int totalCahiers;           //number of all cashiers
    private double profit;              //total profit
    private double cashierCost;         //cost per cashier
    private double avgNoCustArrPerMin;  //average number of customers arriving per minute
    private double avgNoCustServPerMin; //average number of customers served per minute
     
    //double stopTime = 960;  
    //Queue<CustomerTracker> linCust = new LinkedList<CustomerTracker>();   
    
    CustomerQueue line = new CustomerQueue();   //customers waiting in line
    ArrayList<CustomerTracker> arrCust = new ArrayList<CustomerTracker>();  //list of all customers
    ArrayList<CustomerTracker> custServed = new ArrayList<CustomerTracker>();  //list of served customers
    ArrayList<CustomerTracker> custTurnedAway = new ArrayList<CustomerTracker>();  //list of turned away customers
    //int totalCust = 0;
    //double startOfServe;
    //int custInCafe = 0;
    private int custNum = arrCust.size();
    private double nextArriveTime = 0;
    //private double arriveTime;
    /**
     * static main method
     */
    public static void main( String[] args )
    {
        Simulator s;

        for( int cashiers = 0; cashiers < 10; cashiers++ ){
            s = new Simulator( cashiers, 2, 300, 1.5, 0.3 );
            s.runSim();
        }

        //         for( double lamda = 0; lamda < 2; lamda = lamda + 0.5 ){
        //             for( int cashiers = 0; cashiers < 10; cashiers++ ){
        //                 s = new Simulator( cashiers, 2, 300, lamda, 0.3 );
        //                 s.runSim();
        //             }
        //         }

        //         s = new Simulator( 10, 2, 300, 0.5, .3 );
        //         s.runSim();
    }

    /**
     * Constructor for objects of class Simulator
     * @param
     */
    public Simulator( int s, double p, double c, double lamda, double r )
    {
        // initialise instance variables
        // initialise instance variables
        eventSet            = new PriorityQueue<Event>();
        this.availableCashiers   = s;
        this.totalCashiers       = s;
        this.profit              = p;
        this.cashierCost         = c;
        this.avgNoCustArrPerMin  = lamda;
        this.avgNoCustServPerMin = r;

        //schedule first arrival
        nextArrival( avgNoCustArrPerMin );
    }

   //********************* WORK ON THIS TOMORROW***********************************
    /**
     * Run the simulation once printing to terminal
     * @param availableCashiers number of cashiers in simulation
     * @param profit money made per customer
     * @param cashierCost money paid to each cashier
     * @param avgNoCustArrPerMin customer arrival rate per minute
     * @param avgNoCustServPerMin customer served per minute
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
    
    //*******************************WORK ON THIS TOMORROW******************************************
    
    /**
     * Method nextArrival adds arrivals to eventSet priority queue 
     * and scheduling future arrivals
     * @param stoptime the end time of simulation
     */
    private void nextArrival( double stopTime )
    {
        while( nextArriveTime < stopTime ){
            Event ev = new Event( custNum++, nextArriveTime, Event.ARRIVE );
            //calculate random arrive times
            arriveTime = -( Math.log( u )/avgNoCustArrPerMin );
            nextArriveTime += arriveTime;
            eventSet.add( ev ); //add rest of arrival events to event queue
        }
    }
    
    /**
     *Method minWait calculus the min wait time of the served customers
     *@return the min wait time of served customers
     */
    public double minWait()
    {
        //find the minimum value in an arraylist
        double minWait = this.custServed.get(0).getIsWait();
        for(int i = 1; i < this.custServed.size(); i++){
            if(this.custServed.get(i).getIsWait()<minWait){
                minWait = this.custServed.get(i).getIsWait();
            }
        }
        return minWait;
    }

    /**
     *Method maxWait calculates the max wait time of the served customers
     *@return the max wait time of the served customers
     */
    public double maxWait()
    {
        //find the max value in an arraylist
        double maxWait = custServed.get(0).getIsWait();
        for(int i = 1; i < custServed.size(); i++){
            if(custServed.get(i).getIsWait()>maxWait){
                maxWait = custServed.get(i).getIsWait();
            }
        }
        return maxWait;
    }

    /**
     *Method avgWait calculates the average waiting time of served customers
     *@return the average waiting time of served customers
     */
    public double avgWait()
    {
        //find the average value in an arraylist
        double avgWait = 0;
        double sum = custServed.get(0).getIsWait();
        for(int i = 1; i < custServed.size(); i++){
            sum += custServed.get(i).getIsWait();
        }
        avgWait = sum/custServed.size();
        return avgWait;
    }
    
     /**
     *Method countServedCustomers counts how many customers in the customers list have non zero service times
     *@return the amount of served customers
     */
    public int countServedCustomers()
    {
        int count = 0;
        //go through list and see which customers have non zero serve times--update count
        for(CustomerTracker c: this.arrCust){
            if(c.getIsServe()> 0 ){	
                count++;
                //add these customers to their own list
                this.servedCustomers.add(c);
            }
        }
        return count;
    }

    /**
     * method getEventList returns this.eventSet
     * @return this.eventSet
     */
    public PriorityQueue<Event> getEventList()
    {
        return this.eventSet;
    }

    /**
     * method getCustomers returns this.arrCust
     * @return this.arrCust
     */
    public ArrayList<CustomerTracker> getCustomers()
    {
        return this.arrCust;
    }

    /**
     * method getservedCustomers returns this.custServed
     * @return this.custServed
     */
    public ArrayList<CustomerTracker> getservedCustomers()
    {
        return this.custServed;
    }

    /**
     * method getoverflowCustomers returns this.custTurnedAway
     * @return this.custTurnedAway
     */
    public ArrayList<CustomerTracker> getoverflowCustomers()
    {
        return this.custTurnedAway;
    }
    
    /**
     * The event class implements the Comparable interface to arrange 
     * events by time of occurence 
     * (Nested in CafeSimulator)
     */ 
    private static class Event implements Comparable<Event>
    {
        static final int ARRIVE = 1; 
        static final int DEPART = 2;      
        int who;        //the number of the user       
        double time;    //when event will occur
        int what;       //type of operation ARRIVE or DEPART
    
        /**
         * Constructor for Event
         */
        public Event()
        {
            //call second constructor
            this( 0, 0, ARRIVE );   //customer id, time, type of event
        }

        /**
         * Constructor for Event
         * @param name the customer number
         * @param tm the time of the event
         * @param type the  type of event occuring
         */
        public Event(int name, double tm, int type)
        {
            this.who = name;
            this.time = tm;
            this.what = type;
        }

        @Override
        public int compareTo( Event rhs )
        {
            //primitive to reference type double
            Double evTime = this.time;
            Double inputTime = rhs.time;

            return evTime.compareTo( inputTime );
        }
    }  
}
