
/**
 * Write a description of interface Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Tree<Any>
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    int sampleMethod(int y);
    
    boolean insert( Any input );
    
    boolean contains( Any input );
    
    int size();
    
    boolean remove( Any input );
    
    Any findMax();
    
    Any findMin();
    
    void printPreOrder();
    
    void printPostOrder();
    
    void printInOrder();
    
   void empty();
   
   boolean isEmpty();
}
