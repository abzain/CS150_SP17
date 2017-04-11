
/**
 * Class Contact - extends Person and compares contacts alphabetically
 * by last name, then first name
 * 
 * Methods - get and set methods for given fields   
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class Contact extends Person implements Comparable<Contact>
{
    // instance variables - replace the example below with your own
    private int phoneNo;
    private String email;
    
    /**
     * Constructor for objects of class Contact
     */
    public Contact( String firstName, String lastName, 
                    String phoneNo, String email )
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    
    /**
     * compareTo method to make Contact class comparable
     * 
     * @param - lastName, firstName
     * @return ordering of contacts by last and first name
     */
    @Override
    public int compareTo( Contact c1 )
    {
        if( this.lastName.equals( c1.lastName ) ){
             return this.firstName.compareTo( c1.firstName );
        }
        else{
            return this.lastName.compareTo( c1.lastName );
        }
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
    
     /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        return "(" + firstName + "," + lastName + "," + phoneNo + "," 
                    + email + ")";
    }
}
