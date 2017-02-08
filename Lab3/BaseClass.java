public class BaseClass {
   protected int somedata = 0;
   /**
   * Default constructor.
   */
   public BaseClass() {
      somedata = 1;
   }
   /**
   * Copy constructor.
   */
   public BaseClass(BaseClass obj) {
      this.somedata = obj.somedata;
   }
   public boolean equals(BaseClass obj) {
      if (this.somedata == obj.somedata) {
         return true;
      } else {
         return false;
      }
   }
   public String toString() {
      String str = new String ("");
      str += somedata;  //str = somedata + str
      return str;
   }
   public void inheritableMethod1 () {
   }
   public void inheritableMethod1 (Double val) {
      Double local_val = val;
   }
   public Double inheritableMethod1 (String val) {
      return 0.0;
   }
}
