import java.util.*;

/**
 * Class Calculator accepts user input of two numbers
 * and the operation, either addition or subtraction
 * to be implemented. 
 * 
 * The interaction and system prints happen at the terminal
 * 
 * @author Zainab Hussein
 * @version 1/24/2017
 */
public class Calculator
{
    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
        // initialise instance variables
    }

    /**
     * static class-method
     */
    public static void main( String[] args )
    {
        Calculator calc = new Calculator();
        calc.calculate();
    }
    
    /**
     * calculate method
     */
    public void calculate() 
    {
        Scanner scan = new Scanner( System.in ); //throws IO exception
        //calculator variables
        float first_number;
        String operation = null;
        float second_number;
        
        //catch exception
        try{
            //read file from user input
            System.out.println( "number of calculations: 3" );
            
            //first no.
            System.out.println( "First Number? " );
            first_number = Float.valueOf( scan.next() );
            System.out.println( "First Number: " + first_number );
            
            //operation
            System.out.println( "plus or minus?" );
            operation = String.format( scan.next() );
            System.out.println( "Operation: " + operation );
            
            //second number
            System.out.println( "Second Number? " );
            second_number = Float.valueOf( scan.next() );
            System.out.println( "Second Number: " + second_number );
            
            //result
            if( operation.equals("plus") ){
                System.out.println( first_number +  "+" + second_number + "=" + 
                (first_number + second_number) );
            }
            else if( operation.equals("minus") ){
                System.out.println( first_number + "-" + second_number + "=" +
                (first_number - second_number) );
            }
            else{
                System.out.println( "undefined operator" );
            }
            
        }
        catch( Exception e ){
            System.out.println( "Exception occured " + e );
        }
        
    }
}
