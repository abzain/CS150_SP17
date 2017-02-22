import java.util.*;

/**
 * Abstract class SortedList - contains sort, add and print methods
 * to be inherited by Worker and Contact classes
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public abstract class SortedList<Any>
{
    // instance variables - replace the example below with your own
    ArrayList<Any> container = new ArrayList<Any>();
    /**
     * addElement method - adds single element to the internal
     * container
     */
    public void addElement( Any input )
    {
        //assuming a generic arrayList container
        container.add( input );
    }
    
    /**
     * quickSort method - sort data using quicksort method
     */
    public static <Any extends Comparable<? super Any>>
    void quickSort( Any[] array )
    {
        //Any [] array;
        if( array == null || array.length == 0 ){
            return;
        }
        quickSortRecursive( 0, array.length-1 );
    }
    
    /**
     * recursive quickSort method
     * 
     * NOTE - I have set array size to 10
     */
    private static <Any extends Comparable<? super Any>>
    void quickSortRecursive( int indexLow, int indexHigh )
    {
        int size = 10;
        Any [] array = ( Any [] ) new Comparable[ size ];
        int left = indexLow;
        int right = indexHigh;
        
        //choose pivot as middle index number
        Any pivot = array[ indexLow + (indexHigh - indexLow )/2 ];
        
        //divide into  arrays
        while( left <= right ){
            //find elements in left side greater than pivot value
            while( array[left].compareTo( pivot ) < 0 ){
                left++;
            }
            //find elements in right side less than pivot value
            while( array[right].compareTo( pivot ) > 0 ){
                right++;
            }
            //swap both numbers
            if( left <= right ){
                swap( left, right );
                //move index to next position on both sides
                left++;
                right--;
            }
        }
        
        //recursively call quickSort
        if( indexLow < right ){
            quickSortRecursive( indexLow, right );
        }
        
        if( left < indexHigh ){
            quickSortRecursive( left, indexHigh );
        }
    }
    
    /**
     * swap method
     * 
     * NOTE - I have set array size to 10
     */
    private static <Any extends Comparable<? super Any>>
    void swap( int left, int right ){
        int size = 10;
        Any [] array = ( Any [] ) new Comparable[ size ];
        //save element in lowest left index to temp
        Any temp = array[left]; 
        //save right index value in left index element
        array[left] = array[right];  
        //save old left index value to right index element
        array[right] = temp;            
    }
    
    /**
     * mergeSort method - sort data using mergeSort method
     */
    public static <Any extends Comparable<? super Any>>
    void mergeSort( Any [] array )
    {
        // generic array
        Any [] tempArray = ( Any [] ) new Comparable[ array.length ];
        
        //call recursive mergerSort on entire array
        mergeSortRecursive( 0, array.length-1 );
    }
    
    /**
     * recursive mergeSort method
     */
    private static <Any extends Comparable<? super Any>>
    void mergeSortRecursive( int indexLow, int indexHigh )
    {
        if( indexLow < indexHigh ){
            int indexMid = ( indexLow + indexHigh )/2;
            
            // sort left side of array
            mergeSortRecursive( indexLow, indexMid );
            
            // sort right side of array
            mergeSortRecursive( indexMid + 1, indexHigh );
            
            // merge left and right sides
            merge( indexLow, indexMid, indexHigh );
        }
    }
    
    /**
     * merge method
     * NOTE - I have set array size to 10
     */
    private static <Any extends Comparable<? super Any>>
    void merge( int indexLow, int indexMid, int indexHigh )
    {
        int size = 10;
        Any [] array = ( Any [] ) new Comparable[ size ];
        Any [] tempArray = ( Any [] ) new Comparable[ array.length ];
        
        for( int i = indexLow; i < indexHigh; i++ ){
            //copy first sublist to a new list
            tempArray[i] = array[i];
        }
        
        int left = indexLow;
        int mid = indexMid + 1;
        int right = indexHigh;
        
        while( left <= indexMid && mid <= indexHigh ){
            //if first element in left sublist is smaller than the first
            // element in the right sublist
            if( tempArray[left].compareTo( tempArray[mid] ) <= 0 ){
                //iteratively take smaller element in left sublist and place 
                //in order in the final array
                array[right] = tempArray[left];
                left++;
            }
            //if the first element in the right sublist is smaller than the
            // first element in the left sublist
            else{
                //iteratively take smaller element in left sublist and place 
                //in order in the final array
                array[right] = tempArray[mid];
                mid++;
            }
            right++;
        }
        
        while( left <= indexMid ){
            array[right] = tempArray[left];
            right++;
            left++;
        }
    }
    
    /**
     * printData method - abstract method
     * 
     * declared without an implementation (without braces, and 
     * followed by a semicolon)
     */
    abstract Any printData();
}
