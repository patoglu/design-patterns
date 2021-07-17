public class Constants {
	public static double Po; //Population
	public static double R; //Constant Spreading Factor [0.5, 1.0]
	public static double Z; //Mortality Rate [0.1, 0.9]
	public static double B;//Ventilators.
	/**
	 * Method that sets random constants
	 */
	public static void set_random_constants()
	{
		R = Math.random() * (1.0 - 0.5) + 0.5;
		Z =  Math.random() * (1.0 - 0.9) + 0.1;
	}

	/**
	 * Method that sets the population
	 */
	public static void set_po(double the_po)
	{
		Po = the_po;
		B = Po / 100;
	}
	/**
	 * Method that sets the r variable
	 */
	public static void set_r(double r)
	{
		R = r;
	}
	/**
	 * Method that sets the z variable
	 */
	public static void set_z(double the_po)
	{
		Po = the_po;
		B = Po / 100;
	}
	/**
	 * Method that prints the constants
	 */
	public static void print_constants()
	{
		System.out.println("Population: " + Po);
		System.out.println("R[0.5-1.0]: " + R);
		System.out.println("Z[0.1-0.9]: " + Z);
		System.out.println("B: " + B);
		
	}
	
}
