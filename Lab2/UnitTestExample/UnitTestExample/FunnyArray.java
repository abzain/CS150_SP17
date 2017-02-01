public class FunnyArray
{
    // instance variable
    private int[] x;

    /**
     * Constructor for objects of class FunnyArray. Creates an array of size n with numbers in order. If n is not postive sets it to 1.
     */
    public FunnyArray(int n)
    {
        //ensuring that n is postive
        if(n<1)
        {
            n=1;
            System.out.println("Invalid array size. Setting array size to 1");
        }
        //creating array and initializing to zero
        x = new int[n];
        for(int i=0;i<n;i++)
            x[i]=i;
    }
    //return original array
    public int[] getArray()
    {
        // put your code here
        System.out.println( "original array :" + x ); //will see after adding main class
        return x;
        
    }
    //return array in reverse
    public int[] getReverseArray()
    {
        // put your code here
        int[] y = new int[x.length];
        for(int i=0;i<x.length;i++)
            y[i]=x[x.length-i-1];
        
        System.out.println( "reverse array :" + y );  //wwill see after adding main class
        return y;
        
    }

}
