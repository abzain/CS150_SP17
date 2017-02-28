
/**
 * Class Worker - extends Person and compare workers using ID's
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
class Worker extends Person implements Comparable<Worker>
{
    // instance variables - replace the example below with your own
    private long id;
    /**
     * Constructor for objects of class Worker
     */
    public Worker( String firstName, String lastName, long id )
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    
    /**
     * compareTo method to make Worker class comparable
     * 
     * @param - id
     * @return ordering of workers by id numbers
     */
    @Override
    public int compareTo( Worker w1 )
    {
        /** 
         * long being a primitive can't be dereferenced
         * so convert to Long object
         */
        
        Long w1_val = new Long( this.id );
        Long w2_val = new Long( w1.id );
        
        return w1_val.compareTo( w2_val );
    }
    
     public long getId()
    {
        return id;
    }
    
    public void setId( long myId )
    {
        this.id = myId;
    }
   
    /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        return "(" + firstName + "," + lastName + "," + id + ")";
    }
}
