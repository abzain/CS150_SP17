import java.util.*;

/**
 * Class Customer - keeps track of it's own status 
 * events tracked for each customer - arrived, served, 
 * departed and turned away
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 */
public class Customer implements Comparable<Customer>
{
    // instance variables 
    private double custArriveTime;
    private double custJoinQueueTime;
    private double custWaitTime;
    private double custServeTime;
    private double custDepartTime;
    private double custTurnedAway;
    private double stopTime;
    
    double waitInterval = 1.5;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        this( 0,0 );
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer( double at, double st )
    {
        // initialise instance variables
        this.custArriveTime = at;
        this.stopTime = st;

        
    }
    
    public double getIsArrive()
    {
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
    
    public void setIsJoinQueue()
    {
        this.custJoinQueueTime = custArriveTime;
    }
    
    //depends on arrival time, so say for now a constant added to arriveTime
     public double getIsWait()
    {
        return custWaitTime = (custArriveTime + waitInterval);
    }
     
    public void setIsWait()
    {
        this.custWaitTime = (custArriveTime + waitInterval);
    }
    
    public double getIsServed()
    {
        custWaitTime = (custArriveTime + waitInterval);
        return custServeTime = (custArriveTime + custWaitTime );
    }
    
    public void setIsServed()
    {
        custWaitTime = (custArriveTime + waitInterval);
        this.custServeTime = (custArriveTime + custWaitTime );
    }
    
    public double getIsDepart()
    {
        custWaitTime = (custArriveTime + waitInterval);
        custServeTime = (custArriveTime + custWaitTime );
        return custDepartTime = (custArriveTime + custWaitTime + custServeTime);
    }
    
    public void setIsDepart()
    {
        custWaitTime = (custArriveTime + waitInterval);
        custServeTime = (custArriveTime + custWaitTime );
        this.custDepartTime = (custArriveTime + custWaitTime + custServeTime);
    }
    
    public double getIsTurnedAway()
    {
        if( custArriveTime > stopTime ){
            return custTurnedAway = custArriveTime;
        }
        else{
            return custTurnedAway = 0;
        }
    }
    
    public void setIsTurnedAway( double at, double st )
    {
        if( at > st ){
            this.custTurnedAway = at;
        }
        else{ 
            this.custTurnedAway = 0;
        }
    }
    
    /**
     * compareTo method to make Customer class comparable
     * 
     * @param - id
     * @return ordering of customers by arriveTime, joinQueueTime,
     * waitTime, serveTime, departTime and turnAwayTime
     * 
     * Priority is for:
     * if customer is being served, priority on departure time
     * if customer has not arrived, priority on arrival time
     */
    @Override
    public int compareTo( Customer w1 )
    {
        /** 
         * double being a primitive can't be dereferenced
         * so convert to Double object
         */
        
        Double a = new Double( this.custArriveTime );
        Double b = new Double( w1.custArriveTime );
        Double c = new Double( this.custJoinQueueTime );
        Double d = new Double( w1.custJoinQueueTime );
        Double e = new Double( this.custWaitTime );
        Double f = new Double( w1.custWaitTime );
        Double g = new Double( this.custServeTime );
        Double h = new Double( w1.custServeTime );
        Double i = new Double( this.custDepartTime );
        Double j = new Double( w1.custDepartTime );
        Double k = new Double( this.custTurnedAway );
        Double l = new Double( w1.custTurnedAway );
        
        
        if( a.equals(b) ){
            if( c.equals(d) ){
                if( e.equals(f) ){
                    if( g.equals(h) ){
                        if( i.equals(j) ){
                            return k.compareTo(l);
                        }
                        else{
                            return i.compareTo(j);
                        }
                    }
                    else{
                        return g.compareTo(h);
                    }
                }
                else{
                    return e.compareTo(f);
                }
            }
            else{
                return c.compareTo(d);
            }
        }
        else{
            return a.compareTo(b);
        }
    }
    
    /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        return "(" + custArriveTime + "," + custJoinQueueTime + "," + custWaitTime + 
                   + custServeTime + custDepartTime + custTurnedAway + ")";
    }
}

