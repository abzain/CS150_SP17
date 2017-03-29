import java.util.Stack;
/**
 * Class BinaryNode - stores a node in a tree, 
 * with access to right and left node from a node
 * 
 * @author Zainab Hussein
 * @version 3-28-2017
 */
public class BinaryNode<Any> 
{
    // instance variables - replace the example below with your own
    public BinaryNode<Any> left;
    public BinaryNode<Any> right;
    public Any element;

    /**
     * Constructor for objects of class BinaryNode
     */
    public BinaryNode()
    {
        //call second constructor
        this(null, null, null);
    }

    /**
     * Copy of constructor for objects of class 
     * BinaryNode
     */
    public BinaryNode( Any theElement, BinaryNode<Any>
    lt, BinaryNode<Any> rt )
    {
        this.element = theElement;
        this.left = lt;
        this.right = rt;
    }
    
    public Stack<Boolean> getDirections(int n)
    {
        Stack<Boolean> goLeft = new Stack<Boolean>();
        while(n>=2)
        {
            if(n%2==0){
                goLeft.push(true);
            }
            else{
                goLeft.push(false);
            }
            n=n/2;   
        }
        return goLeft;
    }
}
