public class Main 
{ 
  public static void main(String[] args) throws CloneNotSupportedException  
  { 
	  Singleton object_alpha = Singleton.instance; 
	  Singleton object_beta = (Singleton) object_alpha.clone(); 
	  System.out.println("The hashcodes won't be equal:");
	  System.out.println(object_alpha.hashCode() + " - "  + object_beta.hashCode());

  } 
} 