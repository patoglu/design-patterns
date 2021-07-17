class Singleton extends Ancestor 
{ 
  public static Singleton instance = new Singleton(); 
  
  private Singleton(){}
  
  @Override
  protected Object clone() throws CloneNotSupportedException  
  { 
	  return instance;
  } 
} 