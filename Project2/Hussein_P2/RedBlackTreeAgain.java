//package weiss.nonstandard;
import java.util.*;
// RedBlackTreeAgain class
//
// CONSTRUCTION: with no parameters
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print all items
// ******************ERRORS********************************
// Exceptions are thrown by insert if warranted and remove.

/**
 * Implements a red-black tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class RedBlackTreeAgain<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public RedBlackTreeAgain( )
    {
        nullNode = new RedBlackNode<AnyType>( null );
        nullNode.left = nullNode.right = nullNode;
        header      = new RedBlackNode<AnyType>( null );
        header.left = header.right = nullNode;
    }

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( AnyType item, RedBlackNode<AnyType> t )
    {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );    
    }

    /**
     * Insert into the tree.
     * @param item the item to insert.
     * @throws DuplicateItemException if item is already present.
     */
    public void insert( AnyType item )
    {
        current = parent = grand = header;
        nullNode.element = item;

        while( compare( item, current ) != 0 )
        {
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ?
                current.left : current.right;
            //all ancestors of new node increase size by 1            
            grand.size += 1;
            great.size += 1;
            parent.size += 1;
            current.size += 1;

            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED )
                handleReorient( item );
        }

        // Insertion fails if already present
        if( current != nullNode )
            throw new IllegalArgumentException( item.toString( ) );
        current = new RedBlackNode<AnyType>( item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parent ) < 0 )
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }

    /**
     * Remove from the tree.
     * @param x the item to remove.
     * @throws UnsupportedOperationException if called.
     */
    public void remove( AnyType x )
    {
        throw new UnsupportedOperationException( );
    }

    /**
     * Find the smallest item  the tree.
     * @return the smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.left != nullNode )
            itr = itr.left;

        return itr.element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            return null;

        RedBlackNode<AnyType> itr = header.right;

        while( itr.right != nullNode )
            itr = itr.right;

        return itr.element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find( AnyType x )
    {
        nullNode.element = x;
        current = header.right;

        for( ; ; )
        {
            if( x.compareTo( current.element ) < 0 )
                current = current.left;
            else if( x.compareTo( current.element ) > 0 ) 
                current = current.right;
            else if( current != nullNode )
                return current.element;
            else
                return null;
        }
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        header.right = nullNode;
    }

    /**
     * Print all items.
     */
    public void printTree( )
    {
        printTree( header.right );
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( RedBlackNode<AnyType> t )
    {
        if( t != nullNode )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return header.right == nullNode;
    }

    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient( AnyType item )
    {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if( parent.color == RED )   // Have to rotate
        {
            grand.color = RED;
            if( ( compare( item, grand ) < 0 ) !=
            ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            current.color = BLACK;
        }
        header.right.color = BLACK; // Make root black
    }

    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode<AnyType> rotate( AnyType item, RedBlackNode<AnyType> parent )
    {
        if( compare( item, parent ) < 0 )
            return parent.left = compare( item, parent.left ) < 0 ?
                rotateWithLeftChild( parent.left )  :  // LL
            rotateWithRightChild( parent.left ) ;  // LR
        else
            return parent.right = compare( item, parent.right ) < 0 ?
                rotateWithLeftChild( parent.right ) :  // RL
            rotateWithRightChild( parent.right );  // RR
    }

    /**
     * Rotate binary tree node with left child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithLeftChild( RedBlackNode<AnyType> k2 )
    {
        RedBlackNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        //new size of k2
        k2.size =  k2.left.size +  k2.right.size + 1;
        //new size of k1.right
        k1.right.size =  k1.right.left.size +  k2.size + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    private static <AnyType> RedBlackNode<AnyType> rotateWithRightChild( RedBlackNode<AnyType> k1 )
    {
        RedBlackNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        //new size of k1
        k1.size = k1.left.size +  k1.right.size + 1;
        //new size of k2.left
        k2.left.size =  k2.left.right.size + k1.size + 1;
        return k2;
    }

    /**
     * Implementation of abstract method select the kth smallest phone number 
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public AnyType select( int k )
    {
        //set the right of header node to current node
        current = header.right;
        return findKth( k, current ).element;
    }

    /**
     * Internal method to find kth smallest item in a subtree
     * @param k the desired rank(1 is the smallest item)
     * @return the node containing the kth smallest item in the subtree
     * @throws IllegalArgumentException if k is less than 1 or more
     * than the size of the subtree
     */
    private RedBlackNode<AnyType> findKth( int k, RedBlackNode<AnyType> t )
    {
//         if( t == null ){    //ensure the RBT isn't empty
//             throw new IllegalArgumentException();
//         }
//         else{
//             int leftsize = ( t.left != null )? t.left.size : 0;
//             //System.out.println( "size of left subtree: " + leftsize );
//              if( k == leftsize + 1 ){    //k equals size of left subtree+1
//                 System.out.println( "Why you lyin?" );
//                 return t;
//                 
//             }
//             
//             else if( k <= leftsize ){        //k equals or is less than size of left subtree
//                 return findKth( k, t.left );
//             }
//             else{
//                 System.out.println( "Why you trippin?" );
//                 return findKth( k - leftsize - 1, t.right );
//             }
//         }
        int leftsize;
        System.out.println( "k" + k );
        ///////////////////////////////////////////////////////////////
        if( t == null ){    //ensure the RBT isn't empty
            return t;
            //throw new IllegalArgumentException();
        }
       
        else {
           leftsize = ( t.left != null )? t.left.size : 0; 
           System.out.println( "leftsize" + leftsize );
            if( k <= leftsize ){
                System.out.println( "why infinite loop?" );
                return findKth( k, t.left);
            }
            //else if( t.left.size < k ){
              //  return findKth( k-t.left.size, t.right);
           // }
            else if( k == leftsize+1 ){
                return t;
            }
        }
        return findKth( k-leftsize, t.right);
        }
        
    

    private static class RedBlackNode<AnyType>
    {
        // Constructors
        RedBlackNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        RedBlackNode( AnyType theElement, RedBlackNode<AnyType> lt, RedBlackNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTreeAgain.BLACK;
            size     = 0;
        }

        AnyType               element;    // The data in the node
        RedBlackNode<AnyType> left;       // Left child
        RedBlackNode<AnyType> right;      // Right child
        int                   color;      // Color
        int                   size;
    }

    private RedBlackNode<AnyType> header;
    private RedBlackNode<AnyType> nullNode;

    private static final int BLACK = 1;    // BLACK must be 1
    private static final int RED   = 0;

    // Used in insert routine and its helpers
    private RedBlackNode<AnyType> current;
    private RedBlackNode<AnyType> parent;
    private RedBlackNode<AnyType> grand;
    private RedBlackNode<AnyType> great;

    // Test program
    public static void main( String [ ] args )
    {
        RedBlackTreeAgain<Integer> t = new RedBlackTreeAgain<Integer>( );
        final int NUMS = 400000;
        final int GAP  =  35461;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );
        //System.out.println( "size of tree" + t.select(6) );
        //t.printTree();
        if( t.findMin( ) != 1 || t.findMax( ) != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 1; i < NUMS; i++ )
            if( t.find( i ) != i )
                System.out.println( "Find error1!" );
    }
}