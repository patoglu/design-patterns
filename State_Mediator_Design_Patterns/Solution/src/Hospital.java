public class Hospital {
	public static double limit;
	public static int current_count = 0;
	/**
	 * Sets the limit of the hospital.
	 * @param the_limit
	 */
	public static void set_limit(double the_limit)
	{
		limit = the_limit;
	}
	/**
	 * Increment the hospitalized count.
	 */
	public static void increment_hospitalized()
	{
		current_count++;
		if(current_count > limit)
		{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Decrement the hospitalized count.
	 */
	public static void decrement_hospitalized()
	{
		current_count--;
		if(current_count < 0)
		{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * Function that checks if the hospital is full or not.
	 * @return boolean value that indicates if the hospital is full or not.
	 */
	public static boolean is_limit_exceeded()
	{
		return current_count >= limit;
	}
	/**
	 * Function that reports the hospital status. Debugging purposes only.
	 */
	public static void hospital_status()
	{
		System.out.println("Hospital Limit: " + limit);
		System.out.println("Current patients: " + current_count);
	}
}
