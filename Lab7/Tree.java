
/**
 * Interface Tree - declaring all generic methods found 
 * all trees, which will have to be implemented. 
 * 
 * @author Zainab Hussein
 * @version 3-15-2017
 */

public interface Tree<Any>
{
    /**
     * return - true if inserted without duplicates,
     * false otherwise
     */  
    public boolean insert( Any input );
    
    /**
     * return - true if tree contains key (input),
     * false otherwise
     */
    boolean contains( Any input );
    
    /**
     * return - total number of items in tree
     */
    public int size();
    
    /**
     * return - true if removes specified input from
     * tree if present, false otherwise
     * Also implements removal of the min item 
     * from subtree
     */
    public boolean remove( Any input );
    
    /**
     * return - largest item from tree
     */
    public Any findMax();
    
    /**
     * return - smallest item from tree
     */
    public Any findMin();
    
    /**
     * prints tree using preorder transversal
     */
    public void printPreOrder();
    
    /**
     * prints tree using postorder transversal
     */
    public void printPostOrder();
    
    /**
     * prints tree using inorder transversal
     */
    public void printInOrder();
    
    /**
     * removes all items from the tree
     */
    public void empty();
    
    /**
     * return - true if there are no items
     * in the tree, false otherwise
     */
    public boolean isEmpty();
}
