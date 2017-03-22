
/**
 * Class BinarySearchTree 
 * 
 * @author Zainab Hussein
 * @version 3-17-2017
 */
public class BinarySearchTree<Any extends Comparable<Any>> extends BinaryTree<Any> 
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
     * return - true if inserted without duplicates,
     * false otherwise
     */  
    public boolean insert( Any input )
    {
        root = new BinaryNode<Any>( input, null, null );
        return insert( input, root );
    }    
    
     /**
     * recursive insertion
     */  
    public boolean insert( Any input, BinaryNode<Any> t )
    {
        if( t == null ){
            t = new BinaryNode<Any>( input, null, null );    //base case
            return true;
        }
        int compareResult = input.compareTo( t.getElement() );
        if( compareResult < 0 ){
            if( t.getLeft() == null ){
                t.setLeft( new BinaryNode<Any>( input, null, null ) );  
                return true;
            }
            else{
                insert( input, t.getLeft() );
            }
        }
        else if( compareResult > 0 ){
            if( t.getRight() == null ){
                t.setRight( new BinaryNode<Any>( input, null, null ) );  
                return true;
            }
            else{
                insert( input, t.getRight() );
            }
        }
        //ignore insertion when duplicate, compareResult==0
        return false;
    }
    
    /**
     * return - true if tree contains key (input),
     * false otherwise
     */
    public boolean contains( Any input )
    {
        return contains( input, root );
    }
    
    /**
     * recursive contains
     */
    private boolean contains( Any input, BinaryNode<Any> t )
    {
        if( t == null ){ 
            return false; 
        }
        int compareResult = input.compareTo( t.getElement() );
        if( compareResult < 0 ){
            if( t.getLeft() == null ){
                return false;
            }
            else{
                contains( input, t.getLeft() );
            } 
        }
        else if( compareResult > 0 ){
            if( t.getRight() == null ){
                return false;
            }
            else{
                contains( input, t.getRight() );
            } 
        }
        else{
            return true;
        }
        return true;
    }
    
    /**
     * return - true if removes specified input from
     * tree if present, false otherwise
     * Also implements removal of the min item 
     * from subtree
     */
    public boolean remove( Any input )
    {
        return remove( input, root );
    }
    
    /**
     * recursive remove method
     */
    private boolean remove( Any input, BinaryNode<Any> t )
    {
        if( t == null ){
            return false;
        }
        int compareResult = input.compareTo( t.getElement() );
        if( compareResult < 0 ){
            remove( input, t.getLeft() );
        }
        else if( compareResult > 0 ){
            remove( input, t.getRight() );
        }
        else if( t.getLeft() != null && t.getRight() != null ){
            //2 children
            t.setElement( findMin( t.getRight() ) );
            remove( t.getElement(), t.getRight() );
        }
        else{
            //t.getLeft==null or t.getRight==null or both
            t = ( t.getLeft() != null )? t.getLeft() : t.getRight();
        }
        return true;
    }
    
    /**
     * return - largest item from tree
     */
    public Any findMax()
    {
        return findMax( root );
    }
    
    /**
     * recursive find min
     */
    private Any findMax( BinaryNode<Any> t )
    {
        if( t == null ){
            return t.getElement();
        }
        else if( t.getRight() == null ){
            return t.getElement();
        }
        else{
            return findMax( t.getRight() );
        }
    }
    
    /**
     * return - smallest item from tree
     */
    public Any findMin()
    {
        return findMin( root );
    }
    
    /**
     * recursive find min
     */
    private Any findMin( BinaryNode<Any> t )
    {
        if( t == null ){
            return t.getElement();
        }
        else if( t.getLeft() == null ){
            return t.getElement();
        }
        else{
            return findMin( t.getLeft() );
        }
    }
}
