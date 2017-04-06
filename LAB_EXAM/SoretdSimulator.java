
/**
 * Simulation class for SoretdLinkedList class
 * 
 * @author Zainab Hussein
 * @version 4-4-2017
 */
public class SoretdSimulator
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class SoretdSimulator
     */
    public SoretdSimulator(){}

    public static void main(String[] args)
    {
        SoretdLinkedList<String> list = new SoretdLinkedList <String>();
        list.add("p");
        list.add("a");
        list.add("p");
        list.add("h");
        list.add("e");
        
        list.toString();
    }
}
