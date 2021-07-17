
public class HealthyInteracting implements State{
	Individual individual;
	/**
	 * Sets the individual reference.
	 * @param individual
	 */
	public HealthyInteracting(Individual individual) {
		this.individual = individual;
	}
	/**
	 * Switches to healthy moving state.
	 */
	public void switch_to_healthy_moving()
	{
		individual.set_state(individual.get_healthy_moving());
	} 
	/**
	 * Switches to infected moving state.
	 */
	public void switch_to_infected_moving()
	{
		individual.set_state(individual.get_infected_moving());
	} 
	/**
	 * Unsupported.
	 */
	public void switch_to_healthy_interacting()
	{
		throw new UnsupportedOperationException();	
	}
	/**
	 * Unsupported.
	 */
	public void switch_to_infected_interacting()
	{
		throw new UnsupportedOperationException();	
	}
	/**
	 * Unsupported.
	 */
	public void switch_to_hospitalized()
	{
		throw new UnsupportedOperationException();	
	}
	/**
	 * Unsupported.
	 */
	public void switch_to_dead()
	{
		throw new UnsupportedOperationException();	
	}
}
