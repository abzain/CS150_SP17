 import java.util.Queue;
 import java.util.LinkedList;
     /**
     * Class CustomerLine represents the queue of Customers
     */
   public class CustomerLine {
        private Queue<Customer> line; //queue
        private boolean full; //boolean to ask if the queue is full
        /**
         * Constructor for CustomerLine
         */
        public CustomerLine() 
         {
             this.line = new LinkedList<Customer>();
        
        }
        
        /**
         * Method poll returns the head of the queue
         * @return the head of the qeueu 
         */
        public Customer poll()
        {
            return line.poll();
        }
       
        /**
         * Method add adds a customer to the queue
         * @param c the customer to add
         */
        public void add(Customer c)
        {
           this.line.add(c);
        }
        
        /**
         * Method setFull sets the queue full
         */
        public void setFull()
        {
            this.full = true;
            }
        
             
        /**
         * Method setnotFull sets the queue to not full
         */
        public void setnotFull()
        {
            this.full = false;
            }
        
        
        /**
         * Method size returns the size of the queue 
         * @return the queue's size
         */
        public int size()
        {
            return line.size();
        }
        
        /**
         * Method isFull returns wether the queue is full or not
         * @return this.full
         */
        public boolean isFull()
        {
            return this.full;
            }
     }