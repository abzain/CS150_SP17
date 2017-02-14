import java.util.*;

/**
 * Abstract class IntegerContainer is an abstract class that is an ancestor 
 * of both ArrayList and LinkedList.
 * 
 * @author Zainab Hussein
 * @version 2/7/2017
 */
public abstract class IntegerContainer 
{
    // instance variables - replace the example below with your own
    protected AbstractList<Integer> data;

    /**
     * Default Constructor for objects of class IntegerContainer
     */
    public IntegerContainer()
    {
        // initialise instance variables
    }

     /**
     * Copy Constructor for objects of class IntegerContainer
     */
    public IntegerContainer( IntegerContainer obj )
    {
        // initialise instance variables
        this.data = obj.data;
    }
    
     /**
    * addToFront method - API void add(int index, E element) inserts 
    * specified element at the specified position in this list 
    */
    public void addToFront( Integer input )
    {
       data.add( 0, input );
    }
       
    /**
    * addToBack method - API boolean add(E e) appends specified 
    * element to end of list
    */
    public void addToBack( Integer input )
    {
        data.add( input );
    }
    
    /**
    * addSorted method - inserts element to the correct position
    * in the list that would keep the array sorted
    */
    public void addSorted( Integer input )
    {
        //check no duplicates - boolean !contains(Object 0) : no
        //specified element found
        if( !data.contains(input) ){
            //add element - simple add(E e)
            data.add( input );
            
            //sort(Comparator<? super E>c) = the super is the List interface
            //API void sort(List<T> list) - sort specified list in 
            //ascending order
            Collections.sort( data );
        }
    }
    
    /**
    * insertionSort method - sorts AbstractList using insertion sort (p.354)
    */
    public void insertionSort()
    {
        //for the given size of arraylist
        for( int p = 1; p < data.size(); p++ ){
            for( int j = p; j > 0 ; j-- ){
                if( data.get(j) < data.get(j-1) ){ 
                    int tmp = data.get(j);
                    //set the val of prev to curr
                    data.set( j, data.get(j-1) ); 
                    //set temp val to prev
                    data.set(j-1, tmp ); 
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
        if( !data.contains(input) ){    //specified element doesn't exist
            return -1;  //more for unit testing
        }
        else{   //specified element exists
            Collections.sort( data );
            return data.indexOf( input );
       }
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
        int low = 0;
        int high = data.size() - 1;
        
           while( low <= high ){
            int mid = ( high+low )/2; //half index through list
            
            if( input < data.get(mid) ){
                high = mid - 1; //search focus on bigger half
            }
            else if( input > data.get(mid) ){
                low = mid + 1;  //search focus on smaller half
            }
            else{
                return mid;
            }
            
        }
        return -1;  //specified element non-existent
    }
    
    /**
     * return an integer array whose entries are equal to the abstractlist - 
     * AbstractList converted to array 
     */
    public Integer[] getArray() 
    {
        //create a list of integer array wih size of the abstractlist
        Integer list[] = new Integer[data.size()];
        return list = data.toArray(list);
    }
}

