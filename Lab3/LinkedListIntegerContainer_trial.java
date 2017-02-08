import java.util.*;
/**
 * Implementing this way results in a null pointer exception
 */

/**
 * Class LinkedListIntegerContainer IS-A IntegerContainer, so inherits methods
 * and parameters from this baseclass.
 * 
 * @author Zainab Hussein
 * @version 2/7/2017
 */
public class LinkedListIntegerContainer_trial //extends IntegerContainer
{
    // instance variables - replace the example below with your own
    public LinkedList<Integer> lin;
    /**
     * Default Constructor for objects of class LinkedListIntegerContainer
     */
    public LinkedListIntegerContainer_trial()
    {
        // initialise instance variables
        super();
    }

    /**
     * Copy Constructor for objects of class LinkedListIntegerContainer
     */
    public LinkedListIntegerContainer_trial( LinkedListIntegerContainer obj )
    {
        // initialise instance variables
        super( obj );
        this.lin = obj.lin;
    }
    
      /**
    * addToFront method - API void add(int index, E element) inserts 
    * specified element at the specified position in this list 
    */
    public void addToFront( Integer input )
    {
       data.add( 0, input );
       lin.add( 0, input );
    }
       
    /**
    * addToBack method - API boolean add(E e) appends specified 
    * element to end of list
    */
    public void addToBack( Integer input )
    {
        data.add( input );
        lin.add( input );
    }
    
    /**
    * addSorted method - inserts element to the correct position
    * in the list that would keep the array sorted
    */
    public void addSorted( Integer input )
    {
        //check no duplicates - boolean !contains(Object 0) : no
        //specified element found
        if( !data.contains(input) && !lin.contains(input) ){
            //add element - simple add(E e)
            data.add( input );
            lin.add( input );
            //sort(Comparator<? super E>c) = the super is the List interface
            //API void sort(List<T> list) - sort specified list in 
            //ascending order
            Collections.sort( data );
            Collections.sort( lin );
        }
    }
    
    /**
    * insertionSort method - sorts AbstractList using insertion sort (p.354)
    */
    public void insertionSort()
    {
        //for the given size of arraylist
        for( int p = 1; (p < data.size() && p < lin.size()); p++ ){
            for( int j = p; j > 0 ; j-- ){
                if( data.get(j) < data.get(j-1) && lin.get(j) < lin.get(j-1)){ 
                    int tmp = data.get(j); 
                    tmp = lin.get(j);
                    //set the val of prev to curr
                    data.set( j, data.get(j-1) ); 
                    lin.set( j, lin.get(j-1) );
                    //set temp val to prev
                    data.set(j-1, tmp ); 
                    lin.set(j-1, tmp );
                }
            }
        }
    }
    
    /**
     * linear search method - search list for specific number (assuming 
     * abstract list is sorted. So call sort method on data and then find element)
     * 
     * return element index
     */
    public int linearSearch( Integer input )
    {
        Collections.sort( data );
        Collections.sort( lin );
        return lin.indexOf( input );
        
        
    }
    
    /**
     * binary search method - search list for specific number (assuming 
     * abstract list is sorted. So call sort method on data and then find element)
     * 
     * return element index
     * 
     * Algorithm - 3-way comparison of low, high and mid. 
     * (adapted from fig.5.11 on textbook)
     */
    public int binarySearch( Integer input )
    {
        Collections.sort( data );
        Collections.sort( lin);
        int low = 0;
        int high = data.size() - 1;
        high = lin.size() - 1;
           while( low <= high ){
            int mid = ( high-low )/2;
            if( input == mid ){
                return mid;
            }
            
            if( input < data.get(data.size()/2) && input < lin.get(lin.size()/2)){
                high = mid - 1; //search focus on bigger half
            }
            else{
                low = mid + 1;  //search focus on smaller half
            }
        }
        return -1;
    }
    
    /**
     * return an integer array whose entries are equal to the abstractlist - 
     * AbstractList converted to array 
     */
    public Integer[] getArray() 
    {
        //create a list of integer array wih size of the abstractlist
        Integer[] list = new Integer[data.size()];
        list = new Integer[lin.size()];
        return list = lin.toArray(list);
    }
}

