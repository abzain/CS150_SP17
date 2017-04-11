
/**
 * Write a description of class DDfcee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MySelectionSort {
 
    public static int[] doSelectionSort(int[] arr){
       for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
       }
        return arr;
    }
     
    public static void main(String a[]){    
        int[] arr1 = {10,34,2,56,7,67,88,42};
        int[] arr2 = doSelectionSort(arr1);
    }
}
