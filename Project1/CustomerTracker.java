import java.util.*;

/**
 * Class CustomerTracker - keeps track of it's own status 
 * events tracked for each customer - arrived, served, 
 * departed and turned away
 * 
 * @param - custArriveTime, custServeTime, custDepartTime
 * custTurnedAway, stopTime, custWaitTime
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 */
public class CustomerTracker implements Comparable<CustomerTracker>
{
    // instance variables 
    private double custArriveTime;
    private double custServeTime;
    private double custWaitTime;
    private double custDepartTime;
    private double custTurnedAway;
    private double stopTime;
    
    /**
     * Constructor for objects of class Customer
     */
    public CustomerTracker()
    {
        // initialise instance variables
        this( 0,0,0 );
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public CustomerTracker( double at, double st, double rt )
    {
        // initialise instance variables
        this.custArriveTime = at;
        this.stopTime = st;
        this.avgNoCustServPerMin = st;
        
    }
    
    /**
     * track arrive time
     */
    public double getIsArrive()
    {
        return custArriveTime;
    }
    
    /**
     * set arrive time
     */
    public void setIsArrive( double at )
    {
        this.custArriveTime = at;
    }
    
    private double u = Math.random();
    private double avgNoCustServPerMin;
    double serveTime;
    double serviceInterval;
    /**
     * track serve time
     */
    public double getIsServed()
    {
        serviceInterval = -( Math.log( u )/avgNoCustServPerMin );
        serveTime = custArriveTime + serviceInterval;
        return custServeTime = serveTime;
    }
    
    /**
     * set serve time
     */
    public void setIsServed( double rt )
    {
        serviceInterval = -( Math.log( u )/rt );
        serveTime = custArriveTime + serviceInterval;
        this.custServeTime = serveTime;
    }
    
    /**
     * track wait time
     */
     public double getIsWait()
    {
        if( custArriveTime == 0 ){
           return  custWaitTime = 0;
        }
        else{
            return custWaitTime = custServeTime - custArriveTime;
        }
    }
    
    /**
     * set wait time
     */
    public void setIsWait()
    {
        if( custArriveTime == 0 ){
            this.custWaitTime = 0;
        }
        else{
            this.custWaitTime = custServeTime - custArriveTime;
        }
    }
    
    double tmpDepart;
    /**
     * track depart time
     */
    public double getIsDepart()
    {
        tmpDepart = custArriveTime + custWaitTime + serviceInterval;
        return custDepartTime = tmpDepart;
    }
    
    /**
     * set depart time
     */
    public void setIsDepart()
    {
        tmpDepart = custArriveTime + custWaitTime + serviceInterval;
        this.custDepartTime = tmpDepart;
    }
    
    /**
     * track turn away time
     */
    public double getIsTurnedAway()
    {
        if( custArriveTime > stopTime ){
            return custTurnedAway = custArriveTime;
        }
        else{
            return custTurnedAway = 0;
        }
    }
    
    /**
     * set turn away time
     */
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
    public int compareTo( CustomerTracker w1 )
    {
        /** 
         * double being a primitive can't be dereferenced
         * so convert to Double object
         */
        
        Double a = new Double( this.custArriveTime );
        Double b = new Double( w1.custArriveTime );
        Double e = new Double( this.custWaitTime );
        Double f = new Double( w1.custWaitTime );
        Double g = new Double( this.custServeTime );
        Double h = new Double( w1.custServeTime );
        Double i = new Double( this.custDepartTime );
        Double j = new Double( w1.custDepartTime );
        Double k = new Double( this.custTurnedAway );
        Double l = new Double( w1.custTurnedAway );
        
        
        if( a.equals(b) ){
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
        return "(" + " arrive " + custArriveTime + "|" + " wait " + custWaitTime + "|" +
                   " serve " + custServeTime + "|" + " depart " + custDepartTime  + "|" +
                   " overflow " + custTurnedAway + ")";
    }
}