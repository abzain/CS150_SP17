
/**
 * Class Contact - extends Person and compares contacts alphabetically
 * by last name, then first name
 * 
 * Methods - get and set methods for given fields   
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class Contact extends Person 
{
    // instance variables - replace the example below with your own
    private String phoneNo;
    private String email;
    
    /**
     * Constructor for objects of class Contact
     */
    public Contact()
    {
        // initialise instance variables
        firstName = null;
        lastName = null;
        phoneNo = null;
        email = null;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }
    
    public void setPhoneNo( String myPhoneNo )
    {
        this.phoneNo = myPhoneNo;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail( String myEmail )
    {
        this.email = myEmail;
    }
}
