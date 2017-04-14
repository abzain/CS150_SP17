//RedBlackTreePhoneBase class 
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
 */
public class RedBlackTreePhoneBase implements PhoneBase
{     
    private RedBlackTreeAgain<Long> phoneNumTree;
    /**
     * Constructor for objects of class RedBlackTreePhoneBase
     */
    public RedBlackTreePhoneBase()
    {
        phoneNumTree = new RedBlackTreeAgain<Long>();
    }
 
    /**
     * Implementation of abstract method adds a phone number 
     * @param  n    phone number to be added
     * @return      true if added without duplicate, false otherwise
     */
    public boolean add( long n )
    {
        //add phone number to rbt
        phoneNumTree.insert( n );
        return true;
    }
      
     /**
     * Implementation of abstract method select the kth smallest phone number 
     * @param  k    index of a given stored phone number
     * @return      the kth smallest phone number 
     */
    public long select( int k )
    {
        //set the right of header node to current node
        return phoneNumTree.select( k );
    }
    
    /**
     * Print the contents of the tree
     */
    public void printTree()
    {
        phoneNumTree.printTree();
    }
}
