
/**
 * Write a description of class ExperimentController here.
 * 
 * @author Zainab Hussein
 * @version 3-21-2017
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    /**
     * static main class
     */
    public static void main( String[] args )
    {
        /**
         * String type
         */
        BinarySearchTree<String> bst1 = new BinarySearchTree<String>();
        bst1.insert( "A" );
        bst1.insert( "B" );
        bst1.insert( "C" );
        bst1.insert( "D" );
        //find min
        System.out.println( bst1.findMin() );
        
        //find max
        System.out.println( bst1.findMax() );
        
        //check size
        System.out.println( bst1.size() );
        
        //check contains
        System.out.println( bst1.contains( "C" ) );
        
        //remove
        System.out.println( bst1.remove( "A" ) );
        
        //prints
        bst1.printPostOrder();
        //bst1.printInOrder();
        //bst1.printPreOrder();
        
        //check is empty
        bst1.empty();
        System.out.println( bst1.isEmpty() );
        /**
         * Integer type
         */
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
        bst2.insert( 3 );
        bst2.insert( 5 );
        bst2.insert( 9 );
        bst2.insert( 1 );
        
        //find min
        System.out.println( bst2.findMin() );
        
        //find max
        System.out.println( bst2.findMax() );
                
        //check size
        System.out.println( bst2.size() );
        
        //check contains
        System.out.println( bst2.contains( 3 ) );
        
        //remove
        System.out.println( bst2.remove( 5 ) );
        //prints
        bst2.printPostOrder();
        //bst2.printInOrder();
        //bst2.printPreOrder();
        
        //check is empty
        bst1.empty();
        System.out.println( bst2.isEmpty() );
        
    }
}
