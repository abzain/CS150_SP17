public class ChildClass1 extends BaseClass {
   public int someotherdata1 = 0;
   public ChildClass1() {
      // Be sure the parent is initialized.
      super();
      someotherdata1 = 1;
   }
   public ChildClass1(ChildClass1 obj) {
      // Be sure the parent is initialized.
      super(obj);
      this.someotherdata1 = obj.someotherdata1;
   }
   public boolean equals(ChildClass1 obj) {
      //alternatively written as 
      //if( super.equals(obj) && this.someotherdata1 == obj.someotherdata1 ){
      if (this.somedata == obj.somedata &&  
      this.someotherdata1 == obj.someotherdata1 ) {
         return true;
      } else {
         return false;
      }
   }
   public String toString() {
      String str = new String ("");
      str += somedata;
      str += ":";
      str += someotherdata1;
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