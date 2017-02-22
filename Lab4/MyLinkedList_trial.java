//import java.Object.*;
/**
 * Write a description of class MyLinkedList_trial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyLinkedList_trial<Any>
{
    // instance variables - replace the example below with your own
    private Node<Any> head;
    private Node<Any> tail;
    private Node<Any> temp;

    /**
     * Constructor for objects of class MyLinkedList_trial
     */
    public MyLinkedList_trial()
    {
        // initialise instance variables
        head = null;
        tail = null;
        temp = null;
    }

    /**
     * getArray method
     */
    public Any[] getArray( Any[] any ) 
    {
        int size;
        Node<Any> i = head;
        Any[] data_store = new Any[ size ];
        while(  i != tail ){
            data_store = head.data; 
            i = head.next;
        }
        return data_store;
    }   
    
//         public <Any> Any[] toArray(Any[] a) {    //EXAMPLE CODE FROM STACK OVERFLOW
//         int size;
//         if (a.length < size){
//             a = (Any[])java.lang.reflect.Array.newInstance(
//             a.getClass().getComponentType(), size);
//                         }
//         int i = 0;
//         Object[] result = a;
//         
//         Node<Any> x = head;
//         for (; x != null; x = x.next){
//             result[i++] = x.item;
//         }
//         
//         if (a.length > size){
//             a[size] = null;
//         }
//         return a;
//     }
}
