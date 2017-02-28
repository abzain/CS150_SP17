import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContactListTest.
 *
 * @author  Zainab Hussein
 * @version 2/21/2017
 */
public class ContactListTest
{
    /**
     * Default constructor for test class ContactListTest
     */
    public ContactListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        
    }
    
    /**
     * test addElement
     */
    @Test
    public void testAddElement()
    {
        ContactList test = new ContactList( );
        
        //add contact objects
        Contact c1 = new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                                  "245-356-5874" );
        Contact c2 = new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                                  "586-356-5874" );
        Contact c3 = new Contact( "Simmone", "Amina", "amina@gmail.com", 
                                  "865-356-5874" );
        Contact c4 = new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                                  "725-356-5874" );
        Contact c5 = new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                                  "305-356-5874" );
        
        //add them to container arraylst
        test.addElement( c1 );
        test.addElement( c2 );
        test.addElement( c3 );
        test.addElement( c4 );
        test.addElement( c5 );
        //control case
        ArrayList<Contact> alist = new ArrayList<Contact>();
        alist.add( c1 );
        alist.add( c2 );
        alist.add( c3 );
        alist.add( c4 );
        alist.add( c5 );
        
        System.out.println( c1.toString() );
       
        //show data in container
        assertEquals( test.getValue(1).toString(), alist.get(1).toString() );
    }
    
    /**
     * test quickSort
     */
        @Test
    public void testQuickSort()
    {
        ContactList test = new ContactList( );
        
        //add contact objects
        Contact a = new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                                  "245-356-5874" );
        Contact b = new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                                  "586-356-5874" );
        Contact c = new Contact( "Simmone", "Amina", "amina@gmail.com", 
                                  "865-356-5874" );
        Contact d = new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                                  "725-356-5874" );
        Contact e = new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                                  "305-356-5874" );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //quickSort data
        //sort based on comparable last name then first name
        test.quickSort();

        //show data in container
        assertEquals( test.getValue(0).getLastName(), "Amina" );
        assertEquals( test.getValue(1).getLastName(), "Boyo" );
        assertEquals( test.getValue(2).getLastName(), "Fracam" );
        assertEquals( test.getValue(3).getLastName(), "Kariuki" );
        assertEquals( test.getValue(4).getLastName(), "Winslow" );
    }
    
    /**
     * test mergeSort
     */
    @Test
    public void testMergeSort()
    {
        ContactList test = new ContactList( );
        
        //add contact objects
        Contact a = new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                                  "245-356-5874" );
        Contact b = new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                                  "586-356-5874" );
        Contact c = new Contact( "Simmone", "Amina", "amina@gmail.com", 
                                  "865-356-5874" );
        Contact d = new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                                  "725-356-5874" );
        Contact e = new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                                  "305-356-5874" );
        
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //mergesort data
        //sort based on comparable last name then first name
        test.mergeSort();
       
        //show data in container
        assertEquals( test.getValue(0).getLastName(), "Amina" );
        assertEquals( test.getValue(1).getLastName(), "Boyo" );
        assertEquals( test.getValue(2).getLastName(), "Fracam" );
        assertEquals( test.getValue(3).getLastName(), "Kariuki" );
        assertEquals( test.getValue(4).getLastName(), "Winslow" );
    }
    
    /**
     * test printData
     */
        @Test
    public void testPrintData()
    {
         ContactList test = new ContactList( );
        
        //add contact objects
        Contact a = new Contact( "Zain", "Boyo", "kijiji@yahoo.com", 
                                  "245-356-5874" );
        Contact b = new Contact( "Amaar", "Fracam", "Kibich@hotmail.com", 
                                  "586-356-5874" );
        Contact c = new Contact( "Simmone", "Amina", "amina@gmail.com", 
                                  "865-356-5874" );
        Contact d = new Contact( "Nathan", "Kariuki", "kariuki@gmail.com", 
                                  "725-356-5874" );
        Contact e = new Contact( "Julian", "Winslow", "crybaby@gmail.com", 
                                  "305-356-5874" );
 
        //add them to container arraylst
        test.addElement( e );
        test.addElement( b );
        test.addElement( a );
        test.addElement( d );
        test.addElement( c );
        
        //printData
        test.printData();
    }
}
