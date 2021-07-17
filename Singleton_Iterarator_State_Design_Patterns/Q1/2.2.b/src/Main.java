public class Main 
{ 
  public static void main(String[] args) throws CloneNotSupportedException  
  { 
	  
	  /**
	   * Now what we're returning the same instance. This will refer to  the same object.
	   */
	  Singleton object_alpha = Singleton.instance; 
	  Singleton object_beta = (Singleton) object_alpha.clone(); 
	  System.out.println("The hashcodes will be equal:");
	  System.out.println(object_alpha.hashCode() + " - "  + object_beta.hashCode());

  } 
} 