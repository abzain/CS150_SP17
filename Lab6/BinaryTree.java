
/**
 * Abstract class BinaryTree - abstract class implementing the Tree 
 * interface. Will implement just the print methods here as class
 * is too broad for implementation of other methods in tree interface. 
 * 
 * @author Zainab Hussein
 * @version 3-15-2017
 */

public abstract class BinaryTree<Any> implements Tree<Any>
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
        System.out.println( "preorder :" + root.getElement() + " " ); 
        //recursively traverse left subtree
        printPreOrderRecursive( root.getLeft() );
        //recursively traverse right subtree
        printPreOrderRecursive( root.getRight() );
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
        printPostOrderRecursive( root.getLeft() );
        //recursively traverse right subtree
        printPostOrderRecursive( root.getRight() );
        //visit root node
        System.out.println( "preorder :" + root.getElement() + " " ); 
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
        printPostOrderRecursive( root.getLeft() );
        //visit root node
        System.out.println( "preorder :" + root.getElement() + " " ); 
        //recursively traverse right subtree
        printPostOrderRecursive( root.getRight() );
    }
    
    public void empty()
    {
        root = null;
    }
    
    public boolean isEmpty()
    {
        if( root == null ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int size()
    {
        return root.size( root );
    }
}
