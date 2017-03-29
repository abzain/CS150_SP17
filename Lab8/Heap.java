import java.util.Stack;
/**
 * Class Heap - implements a heap atop a 
 * binary tree versus using an array
 * 
 * @author Zainab Hussein
 * @version 3-28-2017
 */
public class Heap<Any> extends BinaryTree<Any>
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Heap
     */
    public Heap()
    {
        // initialise instance variables
        root = null;
    }

    /**
     * insert data to correct location on heap
     */ 
    public void insert( Any input )
    {
        if( root == null ){
            root = new BinaryNode<Any>( input, null, null );
        }
        insert( input, root );
    }

    /**
     * recursive insertion into heap
     */
    private void insert( Any input, BinaryNode<Any> t )
    {
        if( t == null ){
            t = new BinaryNode<Any>( input, null, null );    //base case
        }
        else{
            if( t.getDirections( 1 ) == true && t.left == null ){
                //go left
                t.left = new BinaryNode<Any>( input, null, null );
            }
            if( t.getDirections( 1 ) == false && t.right == null ){
                //go right
                t.right = new BinaryNode<Any>( input, null, null );
            }
        }
    }

    // 
    //     /**
    //      * remove root of the min heap and returns 
    //      * root's value
    //      */
    //     public Any removeMin()
    //     {
    // 
    //     }
}
