public class Main 
{ 
  public static void main(String[] args) throws CloneNotSupportedException  
  { 
	  
	  /**
	   * Now we prevented cloning with the help of throwing and exception.
	   * 
	   * You will see error like:
	   * 
	   * Exception in thread "main" java.lang.CloneNotSupportedException
		at Singleton.clone(Singleton.java:10)
		at Main.main(Main.java:6)
	   */
	  Singleton object_alpha = Singleton.instance; 
	  Singleton object_beta = (Singleton) object_alpha.clone(); 
	  System.out.println("The hashcodes won't be equal:");
	  System.out.println(object_alpha.hashCode() + " - "  + object_beta.hashCode());

  } 
} 