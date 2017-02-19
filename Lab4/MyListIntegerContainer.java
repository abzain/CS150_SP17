import java.util.*;

/**
 * Class MyListIntegerContainer inherits add methods from generic
 * MyLinkedList class, creates search methods and uses implemented
 * LinkedList
 * 
 * @author Zainab Hussein
 * @version 2/18/2017
 */
public class MyListIntegerContainer<Any>
{
    // instance variables - replace the example below with your own
    private MyLinkedList<Any> lin_list;
    private MyLinkedListIterator<Any> lin_itr;

    /**
     * Constructor for objects of class MyListIntegerContainer
     */
    public MyListIntegerContainer()
    {
        // initialise instance variables
        lin_list = new MyLinkedList<Any>();
        lin_itr = new MyLinkedListIterator<Any>();
    }

    /**
     * addToBack method
     */
    public void addToBack( Any input )
    {
        lin_list.addEnd( input );
    }
    
    /**
     * addToFront method
     */
    public void addToFront( Any input )
    {
        lin_list.addFirst( input );
    }
    
     /**
     * implement contains( input ) method to check if input is not
     * found in the search methods above. 
     * 
     * use equals( input ) API method
     */
    public boolean includes( Any input )
    {
        for( Any var : lin_list ){//check that the array var includes input
            if( var.equals(input) ){
                return true;
            }
        }
        return false;    
    }
    
    /**
     * search -  val (w/ iterator)
     * assumption - array unsorted (so simply use either
     * of the add methods above)
     * return -  index if found, -1 if notFound
     */
    public int itrSearch( Any input )
    {
        //lin_list.addFirst( input );
        Iterator<Any> itr = lin_list.iterator();
        int cnt = 0;
        if( this.includes(input) == true ){    //input exists
            while( itr.hasNext() && itr.next() != input ){//count upto input
                System.out.println( itr.next() );
                cnt++;  //input not reached, keep counting
            }
            return cnt; //itr.next==input
        }
        else{
            return -1;  //input not found
        }
    }
    
    /**
     * search -  val (w/o iterator)
     * assumption - array unsorted (so simply use add methods above)
     * return -  index if found, -1 if notFound
     */
    public int noItrSearch( Any input )
    {
        int cnt = 0;
        if( this.includes(input) == true ){   //input exists
            for( Any val : lin_list){
                System.out.println( val );
                cnt++;  //input not reached, keep counting
            }
            return cnt;
        }else{
            return -1;  //input not found
        }
    }
    
    /**
     * get value
     * return index
     */
    public Any giveVal( int index )
    {
        return lin_list.getValue( index );
    }
}
