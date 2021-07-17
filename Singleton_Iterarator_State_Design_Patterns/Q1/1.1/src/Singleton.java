public class Singleton {


   private static Singleton object = new Singleton();


   private Singleton(){}


   public static Singleton get_instance(){
      return object;
   }
}