import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater( new Runnable() {
		      @Override
		      public void run() {
		    	  Constants.set_random_constants();
		    	  Constants.set_po(100);
		    	  Constants.print_constants();
		    	  Hospital.set_limit(Constants.B);
		    	  GUI gui = new GUI();
		      }
		    } );
        
 
	}

}