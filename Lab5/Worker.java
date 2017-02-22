
/**
 * Class Worker - extends Person and compare workers using ID's
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class Worker extends Person
{
    // instance variables - replace the example below with your own
    private long id;
    /**
     * Constructor for objects of class Worker
     */
    public Worker()
    {
        // initialise instance variables
        firstName = null;
        lastName = null;
        id = 0;
    }

    public long getId()
    {
        return id;
    }
    
    public void setId( long myId )
    {
        this.id = myId;
    }
}
