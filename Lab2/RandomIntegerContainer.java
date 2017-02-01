import java.util.*;

/**
 * RandomIntegerContainer class creates an arraylist of integers
 * to compare the complexity of adding to end or front of list, and
 * ordering. 
 * 
 * @author Zainab Hussein
 * @version 1/31/2017
 */
public class RandomIntegerContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> arr_list;

    /**
     * Constructor for objects of class RandomIntegerContainer
     */
    public RandomIntegerContainer()
    {
        // initialise instance variables
        arr_list = new ArrayList<Integer>();

    }

    /**
    * addToFront method - API void add(int index, E element) inserts 
    * specified element at the specified position in this list 
    */
    public void addToFront( Integer input )
    {
       arr_list.add( 0, input );
    }
       
    /**
    * addToBack method - API boolean add(E e) appends specified 
    * element to end of list
    */
    public void addToBack( Integer input )
    {
        arr_list.add( input );
    }
    
    /**
    * addSorted method - inserts element to the correct position
    * in the list that would keep the array sorted
    */
    public void addSorted( Integer input )
    {
        //check no duplicates - boolean !contains(Object 0) : no
        //specified element found
        if( !arr_list.contains(input) ){
            //add element - simple add(E e)
            arr_list.add( input );
            
            //sort(Comparator<? super E>c) = the super is the List interface
            //API void sort(List<T> list) - sort specified list in 
            //ascending order
            Collections.sort( arr_list );
        }
    }
    
    /**
    * insertionSort method - sorts ArrayList using insertion sort (p.354)
    */
    public void insertionSort()
    {
        //for the given size of arraylist
        for( int p = 1; p < arr_list.size(); p++ ){
            int tmp = arr_list.get(p);
            int i = p;
            
            for( ;(i > 0) && arr_list.get(i-1) > tmp; i-- ){
                arr_list.set( i, tmp );
            }
        }
    }
   
    /**
     * return an integer array whose entries are equal to the arraylist
     */
    public ArrayList<Integer> getArray() 
    {
        return  arr_list;
    }
    
    /**
     * get method to test add methods in unitTest
     */
    public Integer getValue( int index )
    {
        return this.arr_list.get( index );
    }
}
