
/**
 * Class Customer - keepstrack of it's own status 
 * events tracked for each customer - arrived, served, 
 * departed and turned away
 * 
 * @author Zainab Hussein
 * @version 3-2-2017
 */
public class CustomerEvents
{
    // instance variables - replace the example below with your own
    PriorityQueue<E> q = new PriorityQueue<E>();
    //E must be comparable or user provides a comparator
    
    //Queue - customers currently waiting in cafe
    //ArrayList - all customers
    //LinkedList - for implementing queue
    //Array - cashiers
    /**
     * Priority is for:
     * if customer is being served, priority on departure time
     * if customer has not arrived, priority on arrival time
     */
    /**
     * Constructor for objects of class Customer
     */
    public CustomerEvents()
    {
        // initialise instance variables
        
    }
    
    //arrived
    public void isArrive()
    {
        
    }
    
    //isServed method
    public void isServed()
    {
        
    }
    
    //departed 
    public void isDepart()
    {
        
    }
    
    //turned away
    public void isTurnedAway()
    {
        
    }
}
