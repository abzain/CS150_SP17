import java.util.*;

/**
 * Class WorkerList - extends abstract class SortedList and implements 
 * abstract method printData. 
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public class WorkerList extends SortedList<Worker>
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class WorkerList
     */
    public WorkerList()
    {
        // initialise instance variables
    }

    @Override
    public void printData()
    {
       for( int i=0; i<container.size(); i++ ){
            System.out.println( "firstname: " + container.get(i).getFirstName()); 
            System.out.println( "lastname: " + container.get(i).getLastName() );
            System.out.println( "id: " + container.get(i).getId() );
            System.out.println( "  ");
            
        }
    }
    
    /**
     * return an integer array whose entries are equal to the arraylist - 
     * ArrayList converted to array 
     */
    public Worker[] getArray() 
    {
        //create a list of integer array wih size of the arraylist
        Worker list[] = new Worker[container.size()];
        return list = container.toArray(list);
    }
     
     /**
     * overide toString method to return string representation of 
     * parameters
     */
    @Override
    public String toString()
    {
        for( int i=0; i<container.size(); i++ ){
            return "(" + container.get(i).getFirstName() + "," 
                       + container.get(i).getLastName() + "," 
                       + container.get(i).getId() + "," 
                       + " " + ")";
        }
        return "Nada";
    }
    
    /**
     * return the value at the given index
     */
    public Worker getValue( int index ) 
    {
        //create a list of integer array wih size of the abstractlist
        return container.get( index );
    }
}
