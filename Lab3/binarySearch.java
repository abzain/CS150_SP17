
/**
 * Basic binary search that uses three-way comparisons
 * @author exactly as written on class textbook fig. 5.11 
 * @version 2/7/2017
 */
public class binarySearch<AnyType>
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class binarySearch
     */
    public binarySearch()
    {
        // initialise instance variables
    }

    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch( AnyType [] a, AnyType x )
    {
        int low = 0;
        int high = a.length-1;
        int mid;
        int NOT_FOUND = -1;
        
        while( low <= high ){
            mid = (low + high)/2;
            if( a[mid].compareTo(x)>0 ){
                low = mid + 1;
            }
            else if( a[mid].compareTo(x)>0 ){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return NOT_FOUND;       //NOT_FOUND = -1
    }
}
