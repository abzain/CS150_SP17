
/**
 * Abstract class Person - carries instance variables for first and 
 * last name
 * 
 * Methods - getFirstName() and getLastName()
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public abstract class Person
{
    // instance variables - replace the example below with your own
    protected String firstName;
    protected String lastName;

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName( String myFirstName )
    {
        this.firstName = myFirstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName( String myLastName )
    {
        this.lastName = myLastName;
    }
}
