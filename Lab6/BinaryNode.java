
/**
 * Class BinaryNode - stores a node in a tree
 * BinaryNode class adapted from textbook chapt. 18
 * 
 * @author Zainab Hussein
 * @version 3-15-2017
 */
public class BinaryNode<Any> 
{
    // instance variables - replace the example below with your own
    private BinaryNode<Any> left;
    private BinaryNode<Any> right;
    private Any element;

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
        element = theElement;
        left = lt;
        right = rt;
    }

    public Any getElement()
    {
        return element;
    }

    public void setElement( Any x )
    {
        this.element = x;
    }

    public BinaryNode<Any> getRight()
    {
        return right;
    }

    public void setRight( BinaryNode<Any> t )
    {
        this.right = t;
    }

    public BinaryNode<Any> getLeft()
    {
        return left;
    }

    public void setLeft( BinaryNode<Any> t )
    {
        this.left = t;
    }

    public int size( BinaryNode<Any> t )
    {
        if( t == null ){
            return 0;           //base case
        }
        else{
            return ( 1 + size( t.left ) + size( t.right ) );    // count root and subtrees
        }
    }
    
}
