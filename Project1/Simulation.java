import java.util.*;
import java.io.*;

/**
 * Class Simulation - 
 * 
 * @author Zainab Hussein
 * @version 3/2/2017
 */
public class Simulation
{
    // Basic parameters of the simulation
    private int cashiers;
    private double profit;
    private double cashierCost;
    private double avgNoCustArrPerMin;
    private double avgNoCustServPerMin;
    private PriorityQueue<Operations> operationSet; //pending events
    private Random rand;
    private double u;

    private int userNum = 0;
    private double arrivalInterval;
    private double arriveTime;
    private double serviceTime;
    private double waitTime;
    private double joinQueueTime;
    private double departTime;
    private double turnAwayTime;
    private double stopTime = 960;

    //Queue - customers currently waiting in cafe so after arrive event
    //ArrayList - all customers
    ArrayList<Customer> arrCust = new ArrayList<Customer>();
    //LinkedList - for implementing queue
    Queue<Customer> linCust = new LinkedList<Customer>();

    //create customers to ve used in simulation
    Customer A = new Customer( arriveTime, stopTime );
    Customer B = new Customer( arriveTime, stopTime );
    Customer C = new Customer( arriveTime, stopTime );
    Customer D = new Customer( arriveTime, stopTime );
    Customer E = new Customer( arriveTime, stopTime );
    Customer F = new Customer( arriveTime, stopTime );
    Customer G = new Customer( arriveTime, stopTime );
    Customer H = new Customer( arriveTime, stopTime );
    Customer I = new Customer( arriveTime, stopTime );
    Customer J = new Customer( arriveTime, stopTime );

    /**
     * Constructor for objects of class Simulation
     */
    public Simulation( int s, double p, double c, double lamda, double r )
    {
        // initialise instance variables
        operationSet = new PriorityQueue<Operations>();
        cashiers = s;
        profit = p;
        cashierCost = c;
        avgNoCustArrPerMin = lamda;
        avgNoCustServPerMin = r;
        rand = new Random();

        runSim();

    }

//     public static void main( String[] args )
//     {
//         Simulation sim = new Simulation( 5, 16.5, 2.0, 1.0, 2.0 );
//         "5", "16.5", "2.0", "1.0", "2.0"
//         //write out
//         File outFile = new File ("dataout.txt");
//         
//         //catch exception
//         try{
//             FileWriter fWriter = new FileWriter ( outFile.getAbsoluteFile() );
//             PrintWriter pWriter = new PrintWriter ( fWriter );
//             
//             //sim.runSim( 960 );  runs for a long time
//             
//             //checking 10 different seeds per number of items
//             pWriter.println( " " );
//             pWriter.println( sim.arriving( 1.0 ) + "," );
//             pWriter.println( sim.joinQueue() + "," );
//             pWriter.println( sim.waiting() + "," );
//             pWriter.println( sim.serving( 2.0 ) + "," );
//             pWriter.println( sim.departing( 1.0, 2.0 ) + "," );
//             pWriter.println( sim.turnAway( 1.0, 5 ) + "," );
//                     
//           
//             pWriter.close();
//         }
//         
//         catch(Exception e){
//              System.out.println(e);
//         }
//     }

    /**
     * Run simulation until stopping time occurs
     * Stopping time is 960 minutes 
     */
    public void runSim()
    {
        Operations op = null;
        while( !operationSet.isEmpty() ){
            op = operationSet.remove();

            //if time is passed stopTime, stop simulation
            if( op.time > stopTime ){
                break;
            }

            //handle case of turn away
            if( op.what == Operations.TurnedAway ){ //leave
                int cta = turnAway( avgNoCustArrPerMin, cashiers );
                turnAwayTime = arriving( avgNoCustArrPerMin );
                op.time += turnAwayTime;
                op.who = op.who + op.who;

                System.out.println( "Customer " + op.who + "turned away at time " + op.time + " " );
                System.out.println( "No. cusomers turned away " + cta );
            }
            else{   //keep arriving
                //customers arrive and placed in arraylist
                if( op.what == Operations.Arrive ){ //arrive
                    arriveTime = arriving( avgNoCustArrPerMin );
                    op.time += arriveTime;
                    op.who = op.who + op.who;
                    
                    arrCust.add( A );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( B );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( C );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( D );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( E );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( F );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( G );
                    System.out.println( "User " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( H );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( I );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    arriveTime = arriving( avgNoCustArrPerMin );
                    arrCust.add( J );
                    System.out.println( "Customer " + op.who + "arrived at time " + op.time + " " );
                    
                    op.time += arriveTime;
                    op.who = op.who + op.who;
                }
                
                //System.out.println( op.what == Operations.JoinQueue );
                //customer joins queue - enqueue
                else if( op.what == Operations.JoinQueue ){
                    joinQueueTime = joinQueue();
                    op.time += joinQueueTime;

                    for( Customer items : arrCust ){
                        linCust.add( items );
                        System.out.println( "User " +op.who + "joining queue" + op.time + " " );
                    }
                }

                //customer waits in queue
                if( op.what == Operations.Wait ){
                    waitTime = waiting( avgNoCustArrPerMin, avgNoCustServPerMin );
                    op.time += waitTime;

                    for( Customer item : linCust ){
                        System.out.println( "User " +op.who + "joining queue" + op.time + " " );
                    }
                }

                //customer is served - remove from queue and decrease no.cashiers by one
                if( op.what == Operations.Serve ){
                    serviceTime = serving( avgNoCustServPerMin );
                    op.time += serviceTime;

                    linCust.remove();
                    cashiers--;
                }

                //customer departs - increase no.cahiers by 1
                if( op.what == Operations.Departure ){
                    departTime += departing( avgNoCustArrPerMin, avgNoCustServPerMin );
                    op.time = departTime;

                    cashiers++;
                }
            }
        }
    }
// 
//     /**
//      * return an int using a poisson distribution, and  change the
//      * internal state.
//      * @param expectedValue the mean of the distribution
//      * @return the pseudorandom int
//      * 
//      * copied from textbook fig. 9.5
//      */
//     private double nextPoisson( double expectedValue )
//     {
//         double limit = -expectedValue;
//         double product = Math.log( rand.nextDouble() );
//         double count;
// 
//         for( count = 0; product > limit; count++ ){
//             product += Math.log( rand.nextDouble() );
//         }
//         return count;
//     }

    /**
     * Add an arrive event to operationSet at the current time
     * arrival events added in advance
     */
    private double arriving( double lamda){
        Operations op = new Operations( userNum, arriveTime, Operations.Arrive);
        operationSet.add( op );
        u = Math.random(); 
        arrivalInterval = -( Math.log( u )/lamda );

        return arriveTime = arriveTime + arrivalInterval;
    }

    /**
     * Add a joinQueue event to operationSet at the current time
     * depends in status of queue and arrival time
     * if empty, join
     * if full, leave
     * if partially full/empty, join
     */
    private double joinQueue()
    {
        Operations op = new Operations( userNum, joinQueueTime, Operations.JoinQueue);
        operationSet.add( op );

        return joinQueueTime = arriveTime;
    }

    /**
     * Add a serving event to operationSet at the current time
     * depends on arrival time
     */
    private double serving( double r ){
        Operations op = new Operations( userNum, serviceTime, Operations.Serve);
        operationSet.add( op );
        u = Math.random(); 

        return serviceTime = -( Math.log( u )/r );
    }
    
    /**
     * Add a waiting event to operationSet at the current time
     */
    private double waiting( double lamda, double r ){
        Operations op = new Operations( userNum, waitTime, Operations.Wait);
        operationSet.add( op );
        
        arriveTime = arriving( lamda ); //arriveTime
        serviceTime = serving( r );   //serviceTime
        
        return waitTime = (serviceTime - arriveTime);
    }

    /**
     * Add a serving event to operationSet at the current time
     * depends on arrival and waiting time
     */
    private double departing( double lamda, double r ){
        Operations op = new Operations( userNum, departTime, Operations.Departure);
        operationSet.add( op );

        arriveTime = arriving( lamda ); //arriveTime
        waitTime = waiting( lamda, r );  //waitTime
        serviceTime = serving( r );   //serviceTime

        return departTime = ( arriveTime + waitTime + serviceTime );
    }

    /**
     * Add a turnAway event to operationSet at the current time
     * turnAway method is dependent on arrival time and
     * cashier-customer ratio
     * 
     * shows overflow as well
     * cusNo refers to number of people in original queue
     */
    private int turnAway( double lamda, int s )
    {
        //instantiate customer queue
        Operations op = new Operations( userNum, turnAwayTime, Operations.TurnedAway);
        operationSet.add( op );

        int custNo = arrCust.size();
        int cusTurnedAwayCnt = 0;
        double at = arriving( lamda );

        while( ( custNo > 8*s) || (at == stopTime) ){
            cusTurnedAwayCnt++;
        }
        return cusTurnedAwayCnt;
    }

    private double netProfit()
    {
        //total profit - daily cost of cashiers (s*c)
        return ( profit - (cashiers*cashierCost) );
    }

    //     /**
    //      * avg waiting time
    //      */
    //     private double avgWait()
    //     {
    //         
    //     }

    //     //maximum waiting time
    //     private void maxWait()
    //     {
    // 
    //     }
    // 

    private static class Operations implements Comparable<Operations>
    /**
     * modify this to be specific to the project spec
     */
    {
        static final double Arrive = 1; //subject to change
        static final double JoinQueue = 2;
        static final double Wait = 3; //check draft of discussion
        static final double Serve = 4;
        static final double Departure = 5; //there's an equation for this        
        static final double TurnedAway = 6;

        //basic parameters of operation
        int who;    //the number of the user       
        double time;   //when event will occur
        double what;   //type of operation

        /**
         * Constructor for objects of class Operations
         * calls second constructor
         */
        public Operations()
        {
            //set starting point
            this( 0, 0, Arrive );   //customer name, time, type of operation
        }

        //comparison function used by priority queue
        public Operations(int name, double tm, double type)
        {
            who = name;
            time = tm;
            what = type;
        }

        public double getTime()
        {
            return time;
        }

        public void setTime( double tm )
        {
            this.time = tm;
        }

        public int compareTo( Operations rhs )
        {
            //primitive to reference type double
            Double opTime = this.time;
            Double myTime = rhs.time;

            return opTime.compareTo(myTime);
        }

    }
}
