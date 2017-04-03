import java.util.Stack;
/**
 * Class Heap - implements a heap atop a 
 * binary tree versus using an array
 * 
 * @author Zainab Hussein
 * @version 3-28-2017
 */
public class Heap<Any extends Comparable<Any>> extends BinaryTree<Any>
{
    // instance variables - replace the example below with your own
    BinaryNode<Any> tmp;
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
        int treeSize = root.size();
        Stack<Boolean> s = getDirections( treeSize + 1 );
        System.out.println( " " );
        System.out.println( "Non-recursive :"+ treeSize );
        insert( input, root, s );
    }

    /**
     * recursive insertion into heap
     */
    private BinaryNode<Any> insert( Any input, BinaryNode<Any> t, Stack<Boolean> s )
    {
        if( t == null ){
            t = new BinaryNode<Any>( input, null, null );    //base case
            System.out.println( "Recursive root :"+ t.element );
        }
        else{
            //find available node to insert 
            if( s.pop() == true ) {
                t.left = insert( input, t.left, s );
                System.out.println( "Recursive left :"+ t.left.element );
            }
            else{
                t.right = insert( input, t.right, s );
                System.out.println( "Recursive right :"+ t.right.element );
            }
        }
        //filter up min value by comparing with parent
        System.out.println( "Recursive end :"+ t.element );                                     
        percolateUp(t);
        return t;
    }

    private Stack<Boolean> getDirections(int n)
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

    /**
     * percolate up the min value by comparing and 
     * swapping with parent node
     */
    private void percolateUp( BinaryNode<Any> t )
    {
        while( t != null ){
            if( t.left == null ){
                return;
            }
            else{
                if( t.element.compareTo( t.left.element ) < 0 ){
                    return;
                }
                else if( t.element.compareTo( t.left.element ) > 0 ){
                    tmp = t;
                    t = t.left;
                    t.left = tmp;
                }
                else{
                    return; 
                }
            }
        }
    }

    /**
     * remove root of the min heap and returns 
     * root's value
     */
    public Any removeMin()
    {
        if( root == null ){
            return null;
        }
        int heapSize = root.size();
        Stack<Boolean> l = getDirections( heapSize );
        minRemove( root, l );
        System.out.println( " " );
        System.out.println( "Deleted min :" + root.element );
        return root.element;
    }
    
    /**
     * recursive remove min method
     */
    private Any minRemove( BinaryNode<Any> t, Stack<Boolean> l )
    {
        if( t == null ){
            return null;
        }
        sinkDown( t, l );
        return t.element;
    }
    
    /**
     * sink down the min value by comparing and 
     * swapping with parent node
     */
    public void sinkDown( BinaryNode<Any> t, Stack<Boolean> k )
    {
        while( t != null ){
            boolean dir = k.pop();
            BinaryNode<Any> lastNode;
            // last element becomes new root
            if( dir == true ){
                lastNode = t.left;
            }
            else{
                lastNode = t.right;
            }
            t = lastNode;
            // compare with children to find min val 
            // to become new root
            if( t.left == null ){
                return;
            }
            else{
                if( t.element.compareTo( t.left.element ) < 0 ){
                    return;
                }
                else if( t.element.compareTo( t.left.element ) > 0 ){
                    tmp = t;
                    t = t.left;
                    t.left = tmp;
                }
                else{
                    return; 
                }
            }
           
        }
    }
}
