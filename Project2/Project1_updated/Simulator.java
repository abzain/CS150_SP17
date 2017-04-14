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
    private int totalCashiers;           //number of all cashiers
    private double profit;              //total profit
    private double cashierCost;         //cost per cashier
    private double avgNoCustArrPerMin;  //average number of customers arriving per minute
    private double avgNoCustServPerMin; //average number of customers served per minute
     
    private CustomerQueue Line = new CustomerQueue();   //customers waiting in line
    private ArrayList<CustomerTracker> arrCust = new ArrayList<CustomerTracker>();  //list of all customers
    private ArrayList<CustomerTracker> custServed = new ArrayList<CustomerTracker>();  //list of served customers
    private ArrayList<CustomerTracker> custTurnedAway = new ArrayList<CustomerTracker>();  //list of turned away customer

    private int custNum = arrCust.size();   //number of customers
    private double nextArriveTime = 0;

    /**
     * static main method
     */
    public static void main( String[] args )
    {
        Simulator s;

        for( int cashiers = 0; cashiers < 10; cashiers++ ){
            s = new Simulator( cashiers, 2, 300, 1.5, 0.3 );
            //s.runSim();
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

    /**
     * Run the simulation once printing to terminal
     * @param availableCashiers number of cashiers in simulation
     * @param profit money made per customer
     * @param cashierCost money paid to each cashier
     * @param avgNoCustArrPerMin customer arrival rate per minute
     * @param avgNoCustServPerMin customer served per minute
     * 
     * RUN SIMULATION FROM CAMERON ZURMUL (added for final report of project 1)
     */
    public void runSim( int stopTime )
    {
        // write to output file
        File outFile = new File ("dataout.txt");

        //catch exception
        try{
            FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() ); 
            PrintWriter pWriter = new PrintWriter ( fWriter );
    
            Event e = null;
            double customerserviceLength; //customer's service length
            //Fill the event queue with arrivals
            nextArrival(stopTime);
    
            while(!eventSet.isEmpty())
            {
                //Remove the head of the priority queue--starts at the first customer
                e = eventSet.remove();
                //ask if the an arrival event time is past stopping time--if yes continue to next leaving event to makes sure everyone who goes into the store before the end of the day gets served
                if(e.what == Event.ARRIVE && e.time >= stopTime){
                    continue;
                }
    
                //if the cutsomer left, updated available Cashiers, remove from Line
                CustomerTracker UpcomingCustomer = null;
                if(e.what == Event.DEPART) //DEPART
                {
                    System.out.printf("Customer %d leaves the store at time %.2f \n",e.who,e.time);
                    availableCashiers++;
                    arrCust.get(e.who).setIsDepart(e.time); //set the customer's departure time to be his leaving time
    
                } else if(e.what == Event.ARRIVE) {  //ARRIVE
                    //define what it means to be a full/not full queue
                    if(Line.size() >= 8*totalCashiers)
                    {
                        Line.setFull();
                    } else {
                        Line.setnotFull();
                    }
                    
                    if(!Line.isFull()){ //if the line is not full, he can join the line
                        System.out.printf("Customer " + e.who + " arrives at the store at time %.2f mins. He joins the line \n",e.time);
                        //create customer object and add to the line/customer list
                        CustomerTracker newCustomerTracker = new CustomerTracker(e.time, e.who);
                        //add a customer to the line 
                        Line.add(newCustomerTracker);
                        arrCust.add(newCustomerTracker); //add to list
                    } else {
                        //If the line is full, the customer does not enter
                        System.out.printf("Customer " + e.who + " arrives at the store at time %.2f but decides not to enter-OVERFLOW! \n",e.time);
                        //create a new customer and add him to the list--keep track of overdraft 
                        CustomerTracker newCustomerTracker = new CustomerTracker(e.time, e.who);
                        newCustomerTracker.setIsServe(0); //no service time 
                        newCustomerTracker.setIsWait(0); //no wait time
                        newCustomerTracker.setIsDepart(e.time); //no depart time
                        arrCust.add(newCustomerTracker);
                        custTurnedAway.add(newCustomerTracker); //also add these customers to their special list
                    }
                }
    
                //Poll from the line if there are available cashiers and if there are customers to poll
                if(Line.size()>0 && availableCashiers>0) 
                {
                    UpcomingCustomer = Line.poll();
                    availableCashiers--; //the customer will go to the Cashier
                    //calculate service time and give print out
                    customerserviceLength = -Math.log( u )/avgNoCustServPerMin; 
                    System.out.printf("Customer " + UpcomingCustomer.getCustId() + " is now at the cashier. He must be served for %.2f mins. \n",customerserviceLength); //print out
    
                    UpcomingCustomer.setIsServe(customerserviceLength); //Set the customer's service time to to the poisson distribtution
    
                    //the customer's total waiting time in the store is the time it takes for the customer to get to the cashier minus his arrival time
                    UpcomingCustomer.setIsWait(e.time-UpcomingCustomer.getIsArrive()); 
                    
                    //create a new leaving event for the customer in question (UpcomingCustomer)
                    //the leaving time is e.time+customerserviceLength
                    Event leave = new Event(UpcomingCustomer.getCustId(), e.time+customerserviceLength,Event.DEPART);
                    eventSet.add(leave); //add event back to the priority queue 
                }   
            }
        }
        catch( Exception e ){
            System.out.println(e);
        }
    }
    
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
            double arriveTime = -( Math.log( u )/avgNoCustArrPerMin );
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
                this.custServed.add(c);
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
