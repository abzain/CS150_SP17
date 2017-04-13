
/**
 * Interface class containing two methods to be implemented three different ways
 */
public interface PhoneBase
{
    /**
     * Abstract method adds a phone number of type long to a given data structure
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n );
    
    /**
     * Abstract method select the kth smallest phone number from the stored numbers
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k );
}
