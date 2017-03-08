import java.util.*;

/**
 * Class Customer - keeps track of it's own status 
 * events tracked for each customer - arrived, served, 
 * departed and turned away
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 */
public class Customer
{
    // instance variables - replace the example below with your own
    //PriorityQueue<E> q = new PriorityQueue<E>();
    //E must be comparable or user provides a comparator
    
    //Queue - customers currently waiting in cafe so after arrive event
    //ArrayList - all customers
    ArrayList<Customer> arrCust = new ArrayList<Customer>();
    //LinkedList - for implementing queue
    Queue<Customer> linCust = new LinkedList<Customer>();
    //Instanciate simulation class containing event times
    //Simulation sim = new Simulation();
    /**
     * Priority is for:
     * if customer is being served, priority on departure time
     * if customer has not arrived, priority on arrival time
     */
    
    double custArriveTime;
    double custJoinQueueTime;
    double custWaitTime;
    double custServeTime;
    double custDepartTime;
    double custTurnedAway;
    int custNo = 0;
    
    Customer next;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        this(0,0,0,0,0);
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer( double at, double jt, double st, double dt, double tt )
    {
        // initialise instance variables
        this.custArriveTime = at;
        this.custJoinQueueTime = jt;
        this.custServeTime = st;
        this.custDepartTime = dt;
        this.custTurnedAway = tt;
        
        next = new Customer( at, jt, st, dt, tt );
    }
    
    public double getIsArrive()
    {
        arrCust.add( next );
        return custArriveTime;
    }
    
    public void setIsArrive( double at )
    {
        this.custArriveTime = at;
    }
    
    public double getIsJoinQueue()
    {
        return custJoinQueueTime = custArriveTime;
    }
    
    public void setIsJoinQueue( double jt )
    {
        this.custJoinQueueTime = jt;
    }
    
     public double getIsWait()
    {
        //add waiting customers in queue
        for( Customer items : arrCust ){
            linCust.add( items );
        }
        return custWaitTime = (custDepartTime - custServeTime - custArriveTime);
    }
    
    public double getIsServed()
    {
        return custServeTime;
    }
    
    public void setIsServed( double st )
    {
        this.custServeTime = st;
    }
    
    public double getIsDepart()
    {
        linCust.remove( next );
        return custDepartTime;
    }
    
    public void setIsDepart( double dt )
    {
        this.custDepartTime = dt;
    }
    
    public double getIsTurnedAway()
    {
        //remove from arraylist if turned away
        arrCust.clear(); //??
        return custTurnedAway;
    }
    
    public void setIsTurnedAway( double tt )
    {
        this.custTurnedAway = tt;
    }
    
    public int noCustInQueue()
    {
        //number of customers in queue at any time
        return custNo = linCust.size();
    }
}
