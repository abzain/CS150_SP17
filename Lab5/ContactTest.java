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
        Contact test = new Contact();
        String firstName;
        
        //declare and check
        firstName = "Zainab";
        test.setFirstName( "Zainab" );
        assertEquals( test.getFirstName(), firstName );
        
        firstName = "Nillah";
        test.setFirstName( "Nillah" );
        assertEquals( test.getFirstName(), firstName );
        
        firstName = "Yusuf";
        test.setFirstName( "Yusuf" );
        assertEquals( test.getFirstName(), firstName );
    }
    
    /**
     * test getLastName
     */
    @Test
    public void testGetLastName()
    {
        Contact test = new Contact();
        String lastName;
        
        //declare and check
        lastName = "Hussein";
        test.setLastName( "Hussein" );
        assertEquals( test.getLastName(), lastName );
        
        lastName = "Mursal";
        test.setLastName( "Mursal" );
        assertEquals( test.getLastName(), lastName ); 
        
        lastName = "Fadamullah";
        test.setLastName( "Fadamullah" );
        assertEquals( test.getLastName(), lastName );
    }
    
    /**
     * test getPhoneNo
     */
    @Test
    public void testGetPhoneNo()
    {
        Contact test = new Contact();
        String phoneNo;
        
        //declare and check
        phoneNo = "484-356-2586";
        test.setPhoneNo( "484-356-2586" );
        assertEquals( test.getPhoneNo(), phoneNo );
        
        phoneNo = "253-365-4789";
        test.setPhoneNo( "253-365-4789" );
        assertEquals( test.getPhoneNo(), phoneNo ); 
        
        phoneNo = "987-635-3245";
        test.setPhoneNo( "987-635-3245" );
        assertEquals( test.getPhoneNo(), phoneNo );
    }
    
    /**
     * test getEmail
     */
    @Test
    public void testGetEmail()
    {
        Contact test = new Contact();
        String email;
        
        //declare and check
        email = "freedom@itsAboutTime.com";
        test.setEmail( "freedom@itsAboutTime.com" );
        assertEquals( test.getEmail(), email );
        
        email = "kajimemasith@ken.com";
        test.setEmail( "kajimemasith@ken.com" );
        assertEquals( test.getEmail(), email ); 
        
        email = "teletubby@gmail.com";
        test.setEmail( "teletubby@gmail.com" );
        assertEquals( test.getEmail(), email );
    }
    
}
