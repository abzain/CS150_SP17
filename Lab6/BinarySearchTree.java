
/**
 * Class BinarySearchTree - 
 * 
 * @author Zainab Hussein
 * @version 3-17-2017
 */
public class BinarySearchTree<Any> extends BinaryTree<Any> //implements Comparable<BinarySearchTree<Any>>
{

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        // initialise instance variables
        root = null;
    }
    
    /**
     * Copy constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree( Any rootItem )
    {
        // initialise instance variables
        root = new BinarySearchTree<Any>( rootItem, null, null );
    }
    
    @Override
    public int compareTo( BinarySearchTree<Any> b )
    {
        BinaryNode<Any> val1 = this.root;
        BinaryNode<Any> val2 = b.root;
        
        return val1.compareTo(val2);
    }
    
    /**
     * return - true if inserted without duplicates,
     * false otherwise
     */  
    public boolean insert( Any input )
    {
        if( root == null ){
            new BinaryNode<Any>( input, null, null );    //base case
        }
        int compareResult = input.compareTo( root.getElement() );
        if( compareResult < 0 ){
            root.getLeft() = insert( input );
        }
        else if( compareResult > 0 ){
            root.getRight() = insert( input );
        }
        //ignore insertion when duplicate, compareResult==0
        return true;
    }
    
    /**
     * return - true if tree contains key (input),
     * false otherwise
     */
    public boolean contains( Any input )
    {
        
    }
    
    /**
     * return - true if removes specified input from
     * tree if present, false otherwise
     * Also implements removal of the min item 
     * from subtree
     */
    public boolean remove( Any input )
    {
        
    }
    
    /**
     * return - largest item from tree
     */
    public Any findMax()
    {
        
    }
    
    /**
     * return - smallest item from tree
     */
    public Any findMin()
    {
        
    }
    
}
