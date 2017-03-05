import java.util.*;

/**
 * Class Simulation - 
 * 
 * @author Zainab Hussein
 * @version 3/2/2017
 */
public class Simulation
{
    // Basic parameters of the simulation
    private double cashiers;
    private double profit;
    private double cashierCost;
    private double avgNoCustArrPerMin;
    private double avgNoCustServPerMin;
    private PriorityQueue<Operations> operationSet; //pending events
    private Random rand;
    private double u;

    //for arriving method
    private int userNum = 0;
    private double arrivalInterval;
    private double serviceTime;
    private double waitTime;
    private double stopTime = 960;

    /**
     * Constructor for objects of class Simulation
     */
    public Simulation( double s, double p, double c, double lamda, double r )
    {
        // initialise instance variables
        operationSet = new PriorityQueue<Operations>();
        cashiers = s;
        profit = p;
        cashierCost = c;
        avgNoCustArrPerMin = lamda;
        avgNoCustServPerMin = r;
        rand = new Random();

        arriving( avgNoCustArrPerMin ); //schedule first arrival

    }
    
    /**
     * Run simulation until stopping time occurs
     * Stopping time is 960 minutes 
     */
    public void runSim( double stopTime )
    {
        Operations op = null;
        double waitTime;

        while( !operationSet.isEmpty() ){
            op = operationSet.remove();

            if( op.time > stopTime ){
                break;
            }

            if( op.what == Operations.TurnedAway ){ //leave
                cashiers++;
                System.out.println( "User " + op.who + "turned away at time " + op.time + " " );
            }
            else{   //keep arriving
                System.out.print( "User " + op.who + "arrived at time " + op.time + " " );

                if( cashiers > 0 ){
                    cashiers--;
                    waitTime = rand.nextPoisson( avgNoCustArrPerMin );
                    System.out.println( "and waits for " + waitTime + "minutes" );

                    op.time += waitTime;
                    op.what = Operations.TurnedAway;
                    operationSet.add( op );
                }
                else{
                    System.out.println( "no staff, cafe closed" );
                }
                arriving( avgNoCustArrPerMin );
            }
        }
    }

    /**
     * return an int using a poisson distribution, and  change the
     * internal state.
     * @param expectedValue the mean of the distribution
     * @return the pseudorandom int
     * 
     * copied from textbook fig. 9.5
     */
    private double nextPoisson( double expectedValue )
    {
        double limit = -expectedValue;
        double product = Math.log( nextDouble() );
        double count;
        
        for( count = 0; product > limit; count++ ){
            product += math.log( nextDouble() );
        }
        return count;
    }
    
     /**
     * Add a serving event to operationSet at the current time
     * depends on arrival time
     */
    private void serving( double r ){
        Operations op = new Operations( userNum, serviceTime, Operations.Serve);
        operationSet.add( op );
        u = Math.random(); 
        serviceTime = -( Math.log( u )/r );

    }
    
    /**
     * Add an arrive event to operationSet at the current time
     * arrival events added in advance
     */
    private void arriving( double lamda){
        Operations op = new Operations( userNum, arriveTime, Operations.Arrive);
        operationSet.add( op );
        u = Math.random(); 
        arrivalInterval = -( Math.log( u )/lamda );
        arriveTime = arriveTime + arrivalInterval;

    }

    /**
     * Add a waiting event to operationSet at the current time
     */
    private void waiting(){
        Operations op = new Operations( userNum, waitTime, Operations.Wait);
        operationSet.add( op );

    }

   

    /**
     * Add a serving event to operationSet at the current time
     * depends on arrival and waiting time
     */
    private void departing(){
        Operations op = new Operations( userNum, departTime, Operations.Departure);
        operationSet.add( op );
        departTime = ( arriveTime + waitTime + serviceTime );

    }

    /**
     * Add a turnAway event to operationSet at the current time
     * turnAway method is dependent on arrival time and
     * cashier-customer ratio
     * 
     * cusNo refers to number of people in original queue
     */
    private boolean turnAway( double s, int custNo, double arriveTime )
    {
        //instantiate customer queue
        Operations op = new Operations( userNum, turnAwayTime, Operations.TurnedAway);
        operationSet.add( op );

        int cusTurnedAwayCnt = 0;
        while( ( custNo > 8*s) || (arriveTime == stopTime) ){
            return true;
            cusTurnedAwayCnt++;
        }
        return false;
    }

    /**
     * Add a joinQueue event to operationSet at the current time
     * depends in status of queue and arrival time
     * if empty, join
     * if full, leave
     * if partially full/empty, join
     */
    private void joinQueue()
    {
        Operations op = new Operations( userNum, joinQueueTime, Operations.JoinQueue);
        operationSet.add( op );
    }

    //     private void netProfit()
    //     {
    //         //total profit - daily cost of cashiers (s*c)
    //         
    //     }
    // 
    //     /**
    //      * avg waiting time
    //      */
    //     private void avgWait()
    //     {
    // 
    //     }
    // 
    //     //maximum waiting time
    //     private void maxWait()
    //     {
    // 
    //     }
    // 
    //     //rate of overflow
    //     /**
    //      * return - number of customers turned away for:
    //      * no_customers >= s (turnedAway)
    //      * time==960 && !empty(Queue<LinkedList> instance
    //      * 
    //      */
    //     private int overflow()
    //     {
    //         //if number of customers >= s
    //     }

    private static class Operations implements Comparable<Operations>
    /**
     * modify this to be specific to the project spec
     */
    {
        static final int Arrive = 1; //subject to change
        static final int Wait = 2; //check draft of discussion
        static final int Serve = 3;
        static final int Departure = 4; //there's an equation for this        
        static final int TurnedAway = 5;
        static final int JoinQueue = 6;

        //basic parameters of operation
        int who;    //the number of the user       
        double time;   //when event will occur
        double what;   //type of operation

        /**
         * Constructor for objects of class Operations
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

        public int compareTo( Operations rhs )
        {
            return time - rhs.time;
        }

    }
}
