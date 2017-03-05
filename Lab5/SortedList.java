import java.util.*;

/**
 * Abstract class SortedList - contains sort, add and print methods
 * to be inherited by Worker and Contact classes
 * 
 * @author Zainab Hussein
 * @version 2/21/2017
 */
public abstract class SortedList<Any extends Comparable<? super Any>>
//notation <Any ....> ensures that type Any will be comparable so I can
//use the compareTo()
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
    public void quickSort()
    {
        //call recursive quicksort on entire container
        quickSortRecursive( 0, container.size()-1 );
    }
    
    /**
     * recursive quickSort method
     * 
     */
    private void quickSortRecursive( int indexLow, int indexHigh )
    {
        int left = indexLow;
        int right = indexHigh;
        int mid = (indexLow + indexHigh)/2;
        Any low = container.get(left);
        Any high = container.get(right);
        Any middle = container.get(mid);
        /**
         * choose pivot as mid of three using 
         * on low, mid and high index elements
         */
        //compare low and mid index values
        if( middle.compareTo( low ) < 0 ){
            swap( left, mid );
        }
        //compare high and low index values
        if( high.compareTo( low ) < 0 ){
            swap( left, right );
        }
        //compare high and mid index values
        if( high.compareTo( middle ) < 0 ){
            swap( mid, right );
        }
        
        Any pivot = middle;
        
        //divide into  arrays
        while( left <= right ){
            //find elements in left side greater than pivot value
            while( container.get(left).compareTo( pivot ) < 0 ){
                left++;
            }
            //find elements in right side less than pivot value
            while( container.get(right).compareTo( pivot ) > 0 ){
                right--;
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
     */
    private void swap( int left, int right ){
        //save element in lowest left index to temp
        Any temp = container.get(left);
        //save right index value in left index element
        container.set( left, container.get(right) );
        //save old left index value to right index element
        container.set( right, temp );
    }
    
    
    /**
     * mergeSort method - sort data using mergeSort method
     */
    public void mergeSort()
    {
        //call recursive mergerSort on entire container
        mergeSortRecursive( 0, container.size()-1 );    //ERROR
    }
    
    /**
     * recursive mergeSort method
     */
    private void mergeSortRecursive( int indexLow, int indexHigh )
    {
        int small = indexLow;
        int big = indexHigh;
        int indexMid = ( indexLow + indexHigh )/2;
        if( small < big ){
            // sort left side of array
            mergeSortRecursive( small, indexMid );   //ERROR
            
            // sort right side of array
            mergeSortRecursive( indexMid + 1, big );
            
            // merge left and right sides
            merge( small, indexMid+1, big ); //ERROR
        }
    }
    
    /**
     * merge method
     */
    private void merge( int indexLow, int indexMid, int indexHigh )
    {
        System.out.println(container.size());
        ArrayList<Any> temp = new ArrayList<Any>();
        for ( int i = 0 ; i < container.size() ; i++ ) {
            temp.add(null);
        }
        int left = indexLow;
        int mid = indexMid + 1;
        int right = indexHigh;
//         
//         for( int i = left; i <= right; i++ ){
//             //copy first sublist to a new list
//             temp.set( i, container.get(i) ); //ERROR
//         }
//         
//         while( left <= indexMid && mid <= indexHigh ){
//             //if first element in left sublist is smaller than the first
//             // element in the right sublist
//             if( temp.get(left).compareTo( temp.get(mid) ) <= 0 ){
//                 //iteratively take smaller element in left sublist and place 
//                 //in order in the final array
//                 container.set( right, temp.get(left) );
//                 left++;
//             }
//             //if the first element in the right sublist is smaller than the
//             // first element in the left sublist
//             else{
//                 //iteratively take smaller element in left sublist and place 
//                 //in order in the final array
//                 container.set( right, temp.get(mid) );
//                 mid++;
//             }
//             right++;
//         }
//         
//         while( left <= indexMid ){
//             container.set( right, temp.get(left) );
//             right++;
//             left++;
//         }
         int leftPos = indexMid - 1;
         int numElements = indexHigh-indexLow+1;
        while( indexLow <= leftPos && indexMid <= indexHigh ){
            if( container.get(leftPos).compareTo( container.get(indexHigh)) <= 0){
                temp.set(left++, container.get(indexLow++) ); 
                System.out.println("container.get(indexHig));
                System.out.println(container.get(indexLow));
                System.out.println(indexLow));
            }
            else{
                temp.set(left++, container.get(indexMid++) );   //ERROR
            }
        }
        
        while( indexLow <= leftPos ){ //copy rest of first half
            temp.set(left++, container.get(indexLow++) );
        }
        
        while( indexMid <= indexHigh ){ //copy rest of right half
            temp.set(left++, container.get(indexMid++) );
        }
        
        //copy temp arraylist back
        for( int i = 0; i < numElements; i++ ){
            System.out.println("container size: " + container.size());
            System.out.println("temp size:" + temp.size());
            container.set( indexHigh, temp.get(indexHigh) );
        }
    }
    
    /**
     * printData method - abstract method
     * 
     * declared without an implementation (without braces, and 
     * followed by a semicolon)
     */
    abstract void printData();
    
    
}
