
/**
 * Abstract class BinaryTree - abstract class implementing the Tree 
 * interface. Will implement just the print methods here as class
 * is too broad for implementation of other methods in tree interface. 
 * 
 * @author Zainab Hussein
 * @version 3-15-2017
 */

public abstract class BinaryTree<Any> 
{
    // instance variables - replace the example below with your own
    BinaryNode<Any> root; 

    public void printPreOrder()
    {
        printPreOrderRecursive( root );
        System.out.println( " " );
    }

    private void printPreOrderRecursive( BinaryNode<Any> t )
    {
        if( t == null ){
            return;
        }
        //visit root node
        System.out.println( "preorder print :" + t.element + " " ); 
        //recursively traverse left subtree
        printPreOrderRecursive( t.left );
        //recursively traverse right subtree
        printPreOrderRecursive( t.right );
    }

    public void printPostOrder() 
    {
        printPostOrderRecursive( root );
        System.out.println( " " );
    }

    public void printPostOrderRecursive( BinaryNode<Any> t )
    {
        if( t == null ){
            return;
        }

        //recursively traverse left subtree
        printPostOrderRecursive( t.left );
        //recursively traverse right subtree
        printPostOrderRecursive( t.right );
        //visit root node
        System.out.println( "postorder print :" + t.element + " " ); 
    }

    public void printInOrder() 
    {
        printInOrderRecursive( root );
        System.out.println( " " );
    }

    public void printInOrderRecursive( BinaryNode<Any> t )
    {
        if( t == null ){
            return;
        }

        //recursively traverse left subtree
        printInOrderRecursive( t.left );
        //visit root node
        System.out.println( "inorder print :" + t.element + " " ); 
        //recursively traverse right subtree
        printInOrderRecursive( t.right );
    }

    /**
     * insert data to correct location on heap
     */  
    public abstract void insert( Any input );

    //     /**
    //      * remove root of the min heap and returns 
    //      * root's value
    //      */
    //     public abstract Any removeMin();
}
