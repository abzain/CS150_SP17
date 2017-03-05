
/**
 * Write a description of class Simulation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simulation
{
    // Basic parameters of the simulation
    private int cashiers;
    private int profit;
    private int cashierCost;
    private int avgNoCustArrPerMin;
    private int avgNoCustServPerMin;
    private int operationSet;
    private PriorityQueue<Operations> operationSet; //pendinf events
    
    private double lamda;
    private double u;
    private double c;
    private double p;
    private double r;

    /**
     * Constructor for objects of class Simulation
     */
    public Simulation( int s, int p, int c, int lamda, int r )
    {
        // initialise instance variables
        operationSet = new PriorityQueue<Operations>();
        cashiers = s;
        profit = p;
        cashierCost = c;
        avgNoCustArrPerMin = lamda;
        avgNoCustServPerMin = r;
    }
    
    //Run the simulation
    public void runSim( long stoppingTime )
    {
        //figure 13.9
    }
    
    //Add a call to operationSet at the current time,
    //and schedule one for delta in the future
    /**
     * arrival events added in advance
     */
    private void arriving( int lamda){
        Operations op = new Operations( userNum, arriveTime, Operations.Arrive);
        operationSet.add( op );
        arriveTime = -math.log(U)/lamda;
    }
    
    //depends on arrival time and departure time
    private void serving( int r ){
        serviceTime = -math.log(U)/r;
    }
    
    //dependent on arrival time and cashier-customer ratio
    //calculate rate of overflow
    private boolean turnAway( int s, int custNo, int arrived)
    {
        //queue longer than 8s, turn away customers and keep count
        //960-serveTime >= arriveTime turn away
    }
    
    //dependent on arrival time
    /**
     * depends in status of queue, 
     * if empty, join
     * if full, leave
     * if partially full/empty, join
     */
    private void joinQueue()
    {
        
    }
    
    //depature time
    private void departure()
    {
        //arriveTime+waitTime+serviceTime
    }
    
    private void netProfit()
    {
        //total profit - daily cost of cashiers (s*c)
    }
    
    //avg waiting time
    private void avgWait()
    {
        
    }
    
    //maximum waiting time
    private void maxWait()
    {
        
    }
    
    //rate of overflow
    /**
     * return - number of customers turned away for:
     * no_customers >= s (turnedAway)
     * time==960 && !empty(Queue<LinkedList> instance
     * 
     */
    private int overflow()
    {
        //if number of customers >= s
    }
    
    private static class Operations implements Comparable<Operations>
    /**
     * modify this to be specific to the project spec
     */
    {
        static final int Arrive = 1; //subject to change
        static final int Departure = 2; //there's an equation for this
        static final int Wait = 3; //check draft of discussion
        static final int Serve = 4;
        static final int TurnedAway = 5;
        
        //basic parameters of operation
        private int who;    //the number of the user       
        private int time;   //when event will occur
        private int what;   //type of operation
        
        /**
        * Constructor for objects of class Operations
        */
        public Operations()
        {
            //set starting point
            this.(0, 0, Arrival);   //customer name, time, type of operation
        }
        
        //comparison function used by priority queue
        public Operations(int name, int tm, int type)
        {
            who = name;
            time = tm;
            what = type;
        }
        
        public int compareTo( Operations rhs )
        {
            return time-rhs.time;
        }
        
    }
}
