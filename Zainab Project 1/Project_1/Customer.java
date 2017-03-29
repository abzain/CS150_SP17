
/**
 * Class Customer defines what a Customer is 
 */
public class Customer 
{
    private int customerNumber; //customer identifier 
    //arrivalTime of the customer
    private double arrivalTime;
    //serve time of the customer
    private double serveTime;
    //depart time
    private double departTime;
    //wait time of the customer
    private double waitTime;

    /**
     * Constructor for Customer class
     * @param num the customer's number
     * @param arrival the customer's arrival time
     */

    public Customer(int num, double arrival)
    {
        this.customerNumber = num;
        this.arrivalTime = arrival;
    }

    /**
     * Method toString returns information about the customer
     * @return the information about the customer
     */

    public String toString()
    {
        String s = String.format("Customer " + this.customerNumber + " has an arrival time of %.2f mins, a wait time of %.2f mins, a service time of %.2f mins, and departs at %.2f mins.", arrivalTime, waitTime, serveTime, departTime);
        return s;
    }

    /**
     * Method csvString returns information about the customer in csv format
     * @return the string representing the customer
     */
    public String csvString(){
        if(this.serveTime>0){
            return this.customerNumber + "," + this.arrivalTime + "," + this.waitTime + "," + this.serveTime + "," + this.departTime + "," +"SERVED";
        } else {  return this.customerNumber + "," + this.arrivalTime + "," + this.waitTime + "," + this.serveTime + "," + this.departTime + "," +"OVERFLOW";
        }
    }

    /**
     * Method getarrivalTime returns this customer's arrival time
     * @return this customer's arrival time
     */
    public double getarrivalTime()
    {
        return this.arrivalTime;
    }

    /**
     * Method setarrivalTime sets this customer's arrival time
     * @param time the time to set this customer's arrival time to
     */
    public void setarrivalTime (double time)
    {
        this.arrivalTime = time;
    }

    /**
     * Method getwaitTime returns this customer's waiting time
     * @return this customer's waiting time
     */
    public double getwaitTime()
    {
        return this.waitTime;
    }

    /**
     * Method setwaitTime sets this customer's waiting time
     * @return time the time to set this customer's wait time to
     */
    public void setwaitTime(double time)
    {
        if(time<=0){
            time = 0;
        }
        this.waitTime = time;

    }

    /**
     * Method setserveTime sets this customer's serving time
     * @param time the time to set this customer's serving time to
     */
    public void setserveTime(double time)
    {
        this.serveTime = time;
    }

    /**
     * Method getserveTime returns this customer's serving time
     * @return this customer's serving time
     */
    public double getserveTime()
    {
        return this.serveTime;
    }

    /**
     * Method getdepartTime returns this customer's depart time
     * @return this customer's depart time
     */

    public double getdepartTime()
    {
        return this.departTime;
    }

    /**
     * Method setdepartTime sets this customer's depart time
     * @param time the time to set this customer's depart time to
     */
    public void setdepartTime(double time)
    {
        this.departTime = time;
    }

    /**
     * Method getCustomerNum returns this customer's number
     * @return this customer's number
     */
    public int getCustomerNum()
    {
        return this.customerNumber;
    }

}