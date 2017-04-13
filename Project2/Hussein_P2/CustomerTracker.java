

/**
 * Class CustomerTracker - keeps track arrival, serve, wait and 
 * departure time of a customer
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 */
public class CustomerTracker 
{
    // instance variables 
    private double custArriveTime;
    private double custServeTime;
    private double custWaitTime;
    private double custDepartTime;
    private int custId;
    private long phoneNo;
    
    /**
     * Constructor for objects of class Customer
     * calls second constructor
     */
    public CustomerTracker()
    {
        // initialise instance variables
        this( 0,0 );
    }
    
    /**
     * Constructor for objects of class Customer
     * @param custId the customer number
     * @param custArriveTime the customers's arrival time
     */
    public CustomerTracker( double at, int id )
    {
        // initialise instance variables
        this.custArriveTime = at;
        this.custId = id;
        
    }
    
     /**
     * Method getCustId tracks customer 
     * number based on their arrival time
     * @param - custId
     * @return the customer's number
     */
    public int getCustId()
    {
        return custId;
    }
    
    /**
     * Method getIsArrive tracks arrive time
     * @param - custArriveTime
     * @return the customer's arrival time
     */
    public double getIsArrive()
    {
        return custArriveTime;
    }
    
    /**
     * Method setIsArrive sets arrive time
     * @param at the time arrival is set to
     */
    public void setIsArrive( double at )
    {
        this.custArriveTime = at;
    }
    
     /**
     * Method getIsServe tracks arrive time
     * @param - custServeTime
     * @return the customer's time of service
     */
    public double getIsServe()
    {
        return custServeTime;
    }
    
    /**
     * Method setIsServe sets arrive time
     * @param st the time service is set to
     */
    public void setIsServe( double st )
    {
        this.custServeTime = st;
    }
    
     /**
     * Method getIsWait tracks arrive time
     * @param - custWaitTime
     * @return the customer's wait time
     */
    public double getIsWait()
    {
        return custWaitTime;
    }
    
    /**
     * Method setIsWait sets wait time
     * @param wt the time wait is set to
     */
    public void setIsWait( double wt )
    {
        this.custWaitTime = wt;
    }
    
     /**
     * Method getIsDepart tracks depature time
     * @param - custDepartTime
     * @return the customer's departure time
     */
    public double getIsDepart()
    {
        return custDepartTime;
    }
    
    /**
     * Method getIsDepart sets depart time
     * @param dt the time departure is set to
     */
    public void setIsDepart( double dt )
    {
        this.custDepartTime = dt;
    }
    
     /**
     * Method getPhoneNo returns customer's phone number
     * @param - phoneNo
     * @return the customer's phone number
     */
    public long getPhoneNo()
    {
        return phoneNo;
    }
    
     /**
     * Method setPhoneNo sets customer's phone number
     * @param phone the long phone number is set to
     */
    public void setPhoneNo( long phone )
    {
        this.phoneNo = phone;
    }
    
    /**
     * Method toString contains customer info
     * @return string representation of customer
     */
    public String toString()
    {
        String custDetails = String.format( "Customer " + this.custId + " arrives at %.1f mins, waits for %.1f mins, is served for %.1f mins, and departs at %.1f mins,", custArriveTime, custWaitTime, custServeTime, custDepartTime );
        return custDetails;
    }
    
    /**
     * Method toString contains customer info
     * @return string representation of customer
     */
    public String phoneToString()
    {
        String custDetails = String.format( "Customer " + this.custId + " has a phone number of: " + this.phoneNo );
        return custDetails;
    }
}