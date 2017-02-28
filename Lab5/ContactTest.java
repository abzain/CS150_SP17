import java.lang.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContactTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContactTest
{
    /**
     * Default constructor for test class ContactTest
     */
    public ContactTest()
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
     * test getFirstName
     */
    @Test
    public void testGetFirstName()
    {
        Contact test1 = new Contact( "Zainab", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        String firstName;
        
        //declare and check
        firstName = "Zainab";
        //System.out.println( test1.getFirstName() );
        assertEquals( test1.getFirstName(), firstName );
        
        Contact test2 = new Contact( "Nillah", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        firstName = "Nillah";
        assertEquals( test2.getFirstName(), firstName );
        
        Contact test3 = new Contact( "Yusuf", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        firstName = "Yusuf";
        
        assertEquals( test3.getFirstName(), firstName );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
    /**
     * test getLastName
     */
    @Test
    public void testGetLastName()
    {
        Contact test1 = new Contact( "Zainab", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        String lastName;
        
        //declare and check
        lastName = "Hussein";
        assertEquals( test1.getLastName(), lastName );
        
        Contact test2 = new Contact( "Zainab", "Mursal","484-356-2586", "freedom@itsAboutTime.com"  );
        lastName = "Mursal";
        assertEquals( test2.getLastName(), lastName ); 
        
        Contact test3 = new Contact( "Zainab", "Fadamullah","484-356-2586", "freedom@itsAboutTime.com"  ); 
        lastName = "Fadamullah";
        
        assertEquals( test3.getLastName(), lastName );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
    /**
     * test getPhoneNo
     */
    @Test
    public void testGetPhoneNo()
    {
        Contact test1 = new Contact( "Zainab", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        String phoneNo;
        
        //declare and check
        phoneNo = "484-356-2586";
        assertEquals( test1.getPhoneNo(), phoneNo );
        
        Contact test2 = new Contact( "Zainab", "Hussein","253-365-4789", "freedom@itsAboutTime.com"  );
        phoneNo = "253-365-4789";
        assertEquals( test2.getPhoneNo(), phoneNo ); 
        
        Contact test3 = new Contact( "Zainab", "Hussein","987-635-3245", "freedom@itsAboutTime.com"  );
        phoneNo = "987-635-3245";
        assertEquals( test3.getPhoneNo(), phoneNo );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
    /**
     * test getEmail
     */
    @Test
    public void testGetEmail()
    {
        Contact test1 = new Contact( "Zainab", "Hussein","484-356-2586", "freedom@itsAboutTime.com"  );
        String email;
        
        //declare and check
        email = "freedom@itsAboutTime.com";
        assertEquals( test1.getEmail(), email );
        
        Contact test2 = new Contact( "Zainab", "Hussein","484-356-2586", "kajimemasith@ken.com"  );
        email = "kajimemasith@ken.com";
        assertEquals( test2.getEmail(), email ); 
        
        Contact test3 = new Contact( "Zainab", "Hussein","484-356-2586", "teletubby@gmail.com"  );
        email = "teletubby@gmail.com";
        assertEquals( test3.getEmail(), email );
        
        //print all
        System.out.println( test1.toString() );
        System.out.println( test2.toString() );
        System.out.println( test3.toString() );
        System.out.println( "  " );
    }
    
}
