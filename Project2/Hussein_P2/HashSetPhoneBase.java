import java.util.HashSet;
//HashSetPhoneBase class
//
//CONSTRUCTION - with no arguments
//
//*****************PUBLIC OPERATIONS***********************
//boolean add( x )      --> insert x
//long select( k )      --> selects item at index k
//String toString()     --> represent as string
//*********************************************************

/**
 * Implementing PhoneBase interface using a Hashset
 */
public class HashSetPhoneBase implements PhoneBase
{
    // instance variables - replace the example below with your own
    private HashSet<Long> hashSetPhoneNum;
    private Long[] phoneNumArray;
    private int length;
    /**
     * Constructor for objects of class HashSetPhoneBase
     */
    public HashSetPhoneBase()
    {
        // initialise instance variables
        hashSetPhoneNum = new HashSet<Long>();
    }

    /**
     * Implementation of abstract method adds a phone number 
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n )
    {
        //add the element to the hashset
        return hashSetPhoneNum.add( n );
    }
    
    /**
     * Implementation of abstract method select the kth smallest phone number
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k )
    {
        //convert from hashset to array
        phoneNumArray = hashSetPhoneNum.toArray( new Long[hashSetPhoneNum.size()]);     //no suitable method expects Object, finds long array
        //quickselect to select
        quickSelect( phoneNumArray );
        return phoneNumArray[k-1];
    }
    
    /**
    * Internal selection method that makes recursive calls.
    * Uses median-of-three partitioning and a cutoff.
    * Places the kth smallest item in a[k-1].
    * @param phoneNumArray an array of Comparable items.
    */
    private void quickSelect( Long [ ] phoneNumArray )
    {
        if (phoneNumArray == null || phoneNumArray.length == 0) {
            return;
        }
        //this.array = inputArr;
        length = phoneNumArray.length;
        quickSort( phoneNumArray, 0, length - 1);
    }
    
    /**
     * Recursive Internal quickselect method
     * @param lowerIndex the lowest array index
     * @param higherIndex the highest array index
     */
    private void quickSort(Long [ ] phoneNumArray, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Long pivot = phoneNumArray[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /*
             * In each iteration, we will identify a number from left side which
             * is greater than the pivot value, and also we will identify a number
             * from right side which is less than the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (phoneNumArray[i] < pivot) {
                i++;
            }
            while (phoneNumArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j){
            quickSort(phoneNumArray, lowerIndex, j);
        }
        if (i < higherIndex){
            quickSort(phoneNumArray, i, higherIndex);
        }
    }
    
    /**
     * Swap method for the recursive quickselect method
     * @param i a left index of array
     * @param j a right index of array
     */
    private void exchangeNumbers(int i, int j) {
        Long temp = phoneNumArray[i];
        phoneNumArray[i] = phoneNumArray[j];
        phoneNumArray[j] = temp;
    }    
    
    /**
     * Method to represent hashset as string
     */
    public String toString()
    {
        String s = new String();
        for ( int i = 0; i<phoneNumArray.length; i++ ){
            s = String.format("Array of phone numbers in hashset: " + phoneNumArray[i] );
        }
        return s;
    }
}

