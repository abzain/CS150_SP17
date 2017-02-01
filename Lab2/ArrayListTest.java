//import java.util.ArrayList;
import java.util.*;
public class ArrayListTest {
  public static void main(String[] args) {
    ArrayListTest r =new ArrayListTest();
    r.run();
  }
 
  public void run()
  {
//     ArrayList<String> array = new ArrayList<String> ();
//            array.add("one");
//            array.add("three");
//            array.add("two");
//            array.add("Kajimemasith");

// ArrayList<Boolean> array = new ArrayList<Boolean> ();
//            array.add(true);
//            array.add(true);
//            array.add(false);
//            array.add(false);

// ArrayList<Double> array = new ArrayList<Double> ();
//            array.add(32.0);
//            array.add(5.0);
//            array.add(66.3);
//            array.add(58.36);
           
ArrayList<Integer> array = new ArrayList<Integer> ();
           array.add(56);
           array.add(99);
           array.add(58);
           array.add(33);
           for(int i = 0; i < array.size(); i++) {
             System.out.println(array.get(i));
           }
  }
}