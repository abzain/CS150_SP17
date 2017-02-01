

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FunnyArrayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FunnyArrayTest
{
    //test small array
    @Test
    public void TestCreatePositive3()
    {
        FunnyArray f = new FunnyArray(3);
        int[] a = {0,1,2};
        assertArrayEquals(f.getArray(),a);
    }
    
    //test larger array
    @Test
    public void TestCreatePositive10()
    {
        FunnyArray f = new FunnyArray(10);
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(f.getArray(),a);
    }
    
    //test negative size array
    @Test
    public void TestCreateNegative()
    {
        FunnyArray f = new FunnyArray(-2);
        int[] a = {0};
        assertArrayEquals(f.getArray(),a);
    }
    //test reverse for small array
    @Test
    public void TestReverse3()
    {
        FunnyArray f = new FunnyArray(3);
        int[] a = {2,1,0};
        assertArrayEquals(f.getReverseArray(),a);
    }
    
    //test reverse for larget array
    @Test
    public void TestReverse10()
    {
        FunnyArray f = new FunnyArray(10);
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        assertArrayEquals(f.getReverseArray(),a);
    }
    
    //test reverse for array of size 1
    @Test
    public void TestReverse1()
    {
        FunnyArray f = new FunnyArray(-2);
        int[] a = {0};
        assertArrayEquals(f.getReverseArray(),a);
    }
        
    
    
    
    
    
    
}
