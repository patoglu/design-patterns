public class Main {
   public static void main(String[] args) {
	   /**
	    * THIS WILL NOT COMPILE. JAVA WON'T LET US TO CLONE SINGLETON OBJECT IF ANY INTERFACE NOT DEFINED.
	    * THE ERROR WILL BE LIKE:
	    * 
	    * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		  The method clone() from the type Object is not visible at Main.main(Main.java:5)
		 */
      Singleton object = Singleton.get_instance();
      object.clone();
   }
}