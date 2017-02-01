import java.util.*;
public class RandomExplore {
  public static void main(String[] args) {
    RandomExplore r =new RandomExplore();
    r.run();
  }
 
  public void run()
  {
    long seed = 88087987;
    //long seed = System.nanoTime();
    Random random = new Random(seed);
    //long startTime = System.currentTimeMillis();
    long startTime = System.nanoTime();
    for(int x = 0; x < 3; x++)  //number of random numbers printed out
    { 
      System.out.println(100 * random.nextDouble());
    }
    long stopTime = System.nanoTime();
    //long stopTime = System.currentTimeMillis();
    /**
     * mixing different time scales still executes, only the execute 
     * time is either exagerated up or down
     */
    System.out.println("Execute time: " + (stopTime - startTime));
  }
}