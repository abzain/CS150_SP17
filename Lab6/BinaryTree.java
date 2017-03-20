
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
    private BinaryNode<Any> root; 


    public void printPreOder()
    {
        if( root != null ){
            //visit root node
            System.out.println( root.getElement() + " " ); 
            //recursively traverse left subtree
            root.getLeft();
            //recursively traverse right subtree
            root.getRight();
        }
        else{
            System.out.println( "Binary tree empty" ); 
        }
    }
    

    public void printPostOrder()
    {
        if( root != null ){
            //recursively traverse left subtree
            root.getLeft();
            //recursively traverse right subtree
            root.getRight();
            //visit root node
            System.out.println( root.getElement() + " " ); 
        }
        else{
            System.out.println( "Binary tree empty" ); 
        }
    }
    
    public void printInOrder()
    {
        if( root != null ){
            //recursively traverse left subtree
            root.getLeft();
            //visit root node
            System.out.println( root.getElement() + " " ); 
            //recursively traverse right subtree
            root.getRight();
        }
        else{
            System.out.println( "Binary tree empty" ); 
        }
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
