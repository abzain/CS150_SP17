//RedBlackTreePhoneBase class with a private RedblackNode class
//
//CONSTRUCTION - with no arguments
//
//*****************PUBLIC OPERATIONS***********************
//boolean add( x )      --> insert x
//long select( k )      --> selects item at index k
// void printTree( )      --> Print all items
//*********************************************************

/**
 * Implementing PhoneBase interface using a RedBlackTree
 * @author Mark Allen Weiss - private class and select method
 */
public class RedBlackTreePhoneBase implements PhoneBase
{  
    private RedBlackNode header;
    private RedBlackNode nullNode;

    private static final int BLACK = 1;    // BLACK must be 1
    private static final int RED   = 0;

    // Used in insert routine and its helpers
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    
    /**
     * Constructor for objects of class RedBlackTreePhoneBase
     */
    public RedBlackTreePhoneBase()
    {
        nullNode = new RedBlackNode( null );
        nullNode.left = nullNode.right = nullNode;
        header      = new RedBlackNode( null );
        header.left = header.right = nullNode;
    }

    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( Long item, RedBlackNode t )
    {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.element );    
    }
    
    /**
     * Implementation of abstract method adds a phone number 
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n )
    {
        //add phone number to rbt
        insert( (Long)n );
        return true;
    }
    
     /**
     * Insert into the tree.
     * @param item the item to insert.
     * @throws DuplicateItemException if item is already present.
     */
    private void insert( Long item )
    {
        current = parent = grand = header;
        nullNode.element = item;

        while( compare( item, current ) != 0 )
        {
            great = grand; grand = parent; parent = current;
            current = compare( item, current ) < 0 ?
                         current.left : current.right;

            // Check if two red children; fix if so
            if( current.left.color == RED && current.right.color == RED ){
                 handleReorient( item );
            }
        }

        // Insertion fails if already present
        if( current != nullNode ){
            throw new IllegalArgumentException( item.toString( ) );
            //throw new DuplicateItemException( item.toString( ) ); //WHY ISN'T THIS EXCEPTION FOUND?
        }
        current = new RedBlackNode( item, nullNode, nullNode );

        // Attach to parent
        if( compare( item, parent ) < 0 ){
            parent.left = current;
        }
        else{
            parent.right = current;
        }
        handleReorient( item );
    }
    
    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient( long item )
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
    private RedBlackNode rotate( long item, RedBlackNode parent )
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
    private static RedBlackNode rotateWithLeftChild( RedBlackNode k2 )
    {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     */
    private static RedBlackNode rotateWithRightChild( RedBlackNode k1 )
    {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    
     /**
     * Implementation of abstract method select the kth smallest phone number 
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k )
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
    private RedBlackNode findKth( int k, RedBlackNode t )
    {
        if( t == null ){            //ensure the RBT isn't empty
            throw new IllegalArgumentException();
        }
        int leftsize = ( t.left != null )?
                        ((RedBlackNodeWithSize) t.left).size : 0;

        if( k <= leftsize ){        //k equals or is less than size of left subtree
            return findKth( k, t.left );
        }
        if( k == leftsize + 1 ){    //k equals size of left subtree+1
            return t;
        }
        return findKth( k - leftsize - 1, t.right );
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
    private void printTree( RedBlackNode t )
    {
        if( t != nullNode )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
    
    private static class RedBlackNode
    {
        Long                  element;    // The data in the node
        RedBlackNode          left;       // Left child
        RedBlackNode          right;      // Right child
        int                   color;      // Color
        
        // Constructors
        RedBlackNode( Long theElement )
        {
            this( theElement, null, null );
        }

        RedBlackNode( Long theElement, RedBlackNode lt, RedBlackNode rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTreePhoneBase.BLACK;
        }
    }
    
    private static class RedBlackNodeWithSize extends RedBlackNode
    {
        private int size;  //to keep count of tree size
        RedBlackNodeWithSize( Long x )
        {
            super(x);
            this.size = 0;
        }
    }
}
