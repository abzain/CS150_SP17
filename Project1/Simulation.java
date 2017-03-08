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
    private double arriveTime;
    private double serviceTime;
    private double waitTime;
    private double joinQueueTime;
    private double departTime;
    private double turnAwayTime;
    private double stopTime = 960;

    Customer inst = new Customer( arriveTime, joinQueueTime, serviceTime, departTime, turnAwayTime );
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
    
    public static void main( String[] args )
    {
        Simulation sim = new Simulation( 5.0, 6.3, 1.0, 2.0, 1.0 );
        System.out.println( sim.arriving(5.0) );
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
                    waitTime = nextPoisson( rand.nextDouble() );
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
        double product = Math.log( rand.nextDouble() );
        double count;

        for( count = 0; product > limit; count++ ){
            product += Math.log( rand.nextDouble() );
        }
        return count;
    }

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
     * Add a waiting event to operationSet at the current time
     */
    private double waiting(){
        Operations op = new Operations( userNum, waitTime, Operations.Wait);
        operationSet.add( op );

        return waitTime = nextPoisson( rand.nextDouble() );
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
     * Add a serving event to operationSet at the current time
     * depends on arrival and waiting time
     */
    private double departing(){
        Operations op = new Operations( userNum, departTime, Operations.Departure);
        operationSet.add( op );

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
    private int turnAway()
    {
        //instantiate customer queue
        Operations op = new Operations( userNum, turnAwayTime, Operations.TurnedAway);
        operationSet.add( op );

        int custNo = inst.noCustInQueue();
        int cusTurnedAwayCnt = 0;

        while( ( custNo > 8*cashiers) || (arriveTime == stopTime) ){
            cusTurnedAwayCnt++;
            inst.getIsTurnedAway();
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
