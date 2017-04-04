import java.util.Random;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class OperationSim
{
    //***************************************************************FIELDS******************************************************************//
    private Random random;           //a random source

    private PriorityQueue<CustomerEvent> eventSet; //Pending events

    private CustomerLine Line = new CustomerLine();  //Pending customers--queue

    private ArrayList<Customer> Customers = new ArrayList<Customer>(); //list of customers

    private ArrayList<Customer> servedCustomers = new ArrayList<Customer>(); //list of served customers

    private ArrayList<Customer> overflowCustomers = new ArrayList<Customer>();

    private int numCashiers; //Number of cashiers in the store

    private int availableCashiers;  //Number of available cashiers

    private double serviceRate;       //Length of a service

    private double arrivalRate;     //average interval between customer arrivals

    private int customerNum = 0;        //The next customer as a number

    private double nextarrivalTime = 0;   //next arrival time of curstomer

    private int numCustomers = Customers.size();   //counter for number of customers TOTAL

    /**
     * Constructor for class OperationSim
     * @param cashiers number of cashiers.
     * @param avgServiceLen average length of a service
     * @param customerIntrvl the average time between customer arrivals.
     */

    public OperationSim(int cashiers, double avgServiceLen, double customerInterval)
    {
        this.numCashiers = cashiers;
        eventSet = new PriorityQueue<CustomerEvent>();
        this.availableCashiers = cashiers;
        this.serviceRate = avgServiceLen;
        this.arrivalRate = customerInterval;
        this.random = new Random();

    }

    //**********************************************************Methods******************************************************//

    /**
     * Method fillArrivals fills the EventSet priority queue with all the arrival times before the simlulation
     * @param stoppingTime the time to stop filling events
     */

    public void fillArrivals(int stoppingTime)
    {
        //schedule the first customer entering 
        nextarrivalTime += -Math.log(random.nextFloat())/arrivalRate;
        CustomerEvent firstEvent = new CustomerEvent(customerNum++, nextarrivalTime , CustomerEvent.ENTER);
         //add that customer to the event queue
        eventSet.add(firstEvent);
        //next Customer's arrivalTime (Customer 2)
        nextarrivalTime += -Math.log(random.nextFloat())/arrivalRate;
       
        while(nextarrivalTime<stoppingTime){
            //add in rest of customer arrival events
            CustomerEvent nextArrival = new CustomerEvent(customerNum++, nextarrivalTime, CustomerEvent.ENTER);
            nextarrivalTime += -Math.log(random.nextFloat())/arrivalRate;
            eventSet.add(nextArrival);
        }
    }

    /**
     *Method countServedCustomers counts how many customers in the customers list have non zero service times
     *@return the amount of served customers
     */
    public int countServedCustomers()
    {
        int count = 0;
        //go through list and see which customers have non zero serve times--update count
        for(Customer c: this.Customers){
            if(c.getserveTime()> 0 ){	
                count++;
                //add these customers to their own list
                this.servedCustomers.add(c);
            }
        }
        return count;
    }

    /**
     *Method minWait calculus the min wait time of the served customers
     *@return the min wait time of served customers
     */
    public double minWait()
    {
        //find the minimum value in an arraylist
        double minWait = this.servedCustomers.get(0).getwaitTime();
        for(int i = 1; i < this.servedCustomers.size(); i++){
            if(this.servedCustomers.get(i).getwaitTime()<minWait){
                minWait = this.servedCustomers.get(i).getwaitTime();
            }
        }
        return minWait;
    }

    /**
     *Method maxWait calculates the max wait time of the served customers
     *@return the max wait time of the served customers
     */
    public double maxWait()
    {
        //find the max value in an arraylist
        double maxWait = servedCustomers.get(0).getwaitTime();
        for(int i = 1; i < servedCustomers.size(); i++){
            if(servedCustomers.get(i).getwaitTime()>maxWait){
                maxWait = servedCustomers.get(i).getwaitTime();
            }
        }
        return maxWait;
    }

    /**
     *Method avgWait calculates the average waiting time of served customers
     *@return the average waiting time of served customers
     */
    public double avgWait()
    {
        //find the average value in an arraylist
        double avgWait = 0;
        double sum = servedCustomers.get(0).getwaitTime();
        for(int i = 1; i < servedCustomers.size(); i++){
            sum += servedCustomers.get(i).getwaitTime();
        }
        avgWait = sum/servedCustomers.size();
        return avgWait;
    }

    //Run the simulation
    /**
     * Method runSim simulates the operation until stoppingTime occurs.
     * @param stoppingTime the time to stop the simlulation
     */
    public void runSim(int stoppingTime)
    {
        CustomerEvent e = null;
        double customerserviceLength; //customer's service length
        //Fill the event queue with arrivals
        fillArrivals(stoppingTime);

        while(!eventSet.isEmpty())
        {
            //Remove the head of the priority queue--starts at the first customer
            e = eventSet.remove();
            //ask if the an arrival event time is past stopping time--if yes continue to next leaving event to makes sure everyone who goes into the store before the end of the day gets served
            if(e.what == CustomerEvent.ENTER && e.time >= stoppingTime){continue;}

            //if the cutsomer left, updated available Cashiers, remove from Line
            Customer UpcomingCustomer = null;
            if(e.what == CustomerEvent.LEAVE) //LEAVE
            {
                System.out.printf("Customer %d leaves the store at time %.2f \n",e.customer,e.time);
                availableCashiers++;
                Customers.get(e.customer).setdepartTime(e.time); //set the customer's departure time to be his leaving time

            } else if(e.what == CustomerEvent.ENTER) {  //ENTER
                //define what it means to be a full/not full queue
                if(Line.size() >= 8*numCashiers)
                {
                    Line.setFull();
                } else {
                    Line.setnotFull();
                }
                
                if(!Line.isFull()){ //if the line is not full, he can join the line
                    System.out.printf("Customer " + e.customer + " arrives at the store at time %.2f mins. He joins the line \n",e.time);
                    //create customer object and add to the line/customer list
                    Customer newCustomer = new Customer(e.customer, e.time);
                    //add a customer to the line 
                    Line.add(newCustomer);
                    Customers.add(newCustomer); //add to list
                } else {
                    //If the line is full, the customer does not enter
                    System.out.printf("Customer " + e.customer + " arrives at the store at time %.2f but decides not to enter-OVERFLOW! \n",e.time);
                    //create a new customer and add him to the list--keep track of overdraft 
                    Customer newCustomer = new Customer(e.customer, e.time);
                    newCustomer.setserveTime(0); //no service time 
                    newCustomer.setwaitTime(0); //no wait time
                    newCustomer.setdepartTime(e.time); //no depart time
                    Customers.add(newCustomer);
                    overflowCustomers.add(newCustomer); //also add these customers to their special list
                }
            }

            //Poll from the line if there are available cashiers and if there are customers to poll
            if(Line.size()>0 && availableCashiers>0) 
            {
                UpcomingCustomer = Line.poll();
                availableCashiers--; //the customer will go to the Cashier
                //calculate service time and give print out
                customerserviceLength = -Math.log(random.nextFloat())/serviceRate; 
                System.out.printf("Customer " + UpcomingCustomer.getCustomerNum() + " is now at the cashier. He must be served for %.2f mins. \n",customerserviceLength); //print out

                UpcomingCustomer.setserveTime(customerserviceLength); //Set the customer's service time to to the poisson distribtution

                //the customer's total waiting time in the store is the time it takes for the customer to get to the cashier minus his arrival time
                UpcomingCustomer.setwaitTime(e.time-UpcomingCustomer.getarrivalTime()); 
                
                //create a new leaving event for the customer in question (UpcomingCustomer)
                //the leaving time is e.time+customerserviceLength
                CustomerEvent leave = new CustomerEvent(UpcomingCustomer.getCustomerNum(), e.time+customerserviceLength,CustomerEvent.LEAVE);
                eventSet.add(leave); //add event back to the priority queue 
            } 
        }
    }

    /**
     * method getEventList returns this.EventList
     * @return this.EventList
     */
    public PriorityQueue<CustomerEvent> getEventList()
    {
        return this.eventSet;
    }

    /**
     * method getCustomers returns this.Customers
     * @return this.Customers
     */
    public ArrayList<Customer> getCustomers()
    {
        return this.Customers;
    }

    /**
     * method getservedCustomers returns this.servedCustomers
     * @return this.servedCustomers
     */
    public ArrayList<Customer> getservedCustomers()
    {
        return this.servedCustomers;
    }

    /**
     * method getoverflowCustomers returns this.overflowCustomers
     * @return this.overflowCustomers
     */
    public ArrayList<Customer> getoverflowCustomers()
    {
        return this.overflowCustomers;
    }

    /**
     * Class CustomerEvent implements the Comparable interface to arrange events by time of occurrence.
     */
    private static class CustomerEvent implements Comparable<CustomerEvent>
    {
        static final int ENTER = 1;
        static final int LEAVE = 2;

        public int customer;   //the number of the customer
        public double time;   // when the event will occur
        public int what;   //ENTER OR LEAVE
        /**
         * Constructor for CustomerEvent
         */
        public CustomerEvent()
        {
            this(0, 0, ENTER);
        }

        /**
         * Constructor for CustomerEvent
         * @param customer the customer number
         * @param time the time the event occurs
         * @param event the event classification
         */

        public CustomerEvent(int customer, double time, int event)
        {
            this.customer = customer;
            this.time = time;
            this.what = event;
        }

        @Override
        public int compareTo(CustomerEvent ce)
        {
            if(this.time>ce.time){
                return  1;
            } else if(this.time == ce.time){
                return 0;
            }
            return -1;
        }
    }
}