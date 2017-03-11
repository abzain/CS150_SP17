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
    private int cashiers = 0;
    private int totCustNum = 0;
    private double serveDuration;
    
    /**
     * Constructor for objects of class Customer
     */
    public CustomerTracker()
    {
        // initialise instance variables
        this( 0,0,0,0,0 );
    }
    
    /**
     * Constructor for objects of class Customer
     */
    public CustomerTracker( double at, int s, int custNo, double ss, double si )
    {
        // initialise instance variables
        this.custArriveTime = at;
        this.cashiers = s;
        this.totCustNum = custNo;
        this.custServeTime = ss;
        this.serveDuration = si;
        
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
    
    /**
     * track serve time
     */
    public double getStartServed()
    {
        return custServeTime;
    }
    
    /**
     * set serve time
     */
    public void setStartServed( double ss )
    {
        this.custServeTime = ss;
    }
    
    /**
     * track wait time
     */
     public double getIsWait()
    {
        return custWaitTime = custDepartTime - custServeTime - custArriveTime;
    }
    
    /**
     * set wait time
     */
    public void setIsWait()
    {
        this.custWaitTime = custDepartTime - custServeTime - custArriveTime;
    }
    
    /**
     * track depart time
     */
    public double getIsDepart()
    {
        if( cashiers > 0 && totCustNum == 0 ){
            return custDepartTime = serveDuration + custArriveTime;
        }
        else{
            return custDepartTime = serveDuration + custArriveTime + custServeTime;
        }
    }
    
    /**
     * set depart time
     */
    public void setIsDepart( int s, int custNo, double si )
    {
        if( s > 0 && custNo == 0 ){
            this.custDepartTime = si + custArriveTime;
        }
        else{
            this.custDepartTime = si + custArriveTime + custServeTime;
        }
    }
    
    /**
     * track turn away time
     */
    public double getIsTurnedAway()
    {
        while( totCustNum > 8*cashiers ){
            return custTurnedAway = custArriveTime;
        }
        return custTurnedAway = 0;
    }
    
    /**
     * set turn away time
     */
    public void setIsTurnedAway( int s, int custNo, double at )
    {
        while( custNo > 8*s ){
            this.custTurnedAway = at;
        }
        this.custTurnedAway = 0;
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