
public class HealthyMoving implements State{
	/**
	 * Sets the individual reference.
	 * @param individual
	 */
	Individual individual;
	public HealthyMoving(Individual individual) {
		this.individual = individual;
	}
	/**
	 * Unsupported.
	 */
	public void switch_to_healthy_moving()
	{
		throw new UnsupportedOperationException();	
	} 
	/**
	 * Unsupported.
	 */
	public void switch_to_infected_moving()
	{
		throw new UnsupportedOperationException();	
	} 
	public void switch_to_healthy_interacting()
	{
		individual.set_state(individual.get_healthy_interacting());
	}
	public void switch_to_infected_interacting()
	{
		individual.set_state(individual.get_infected_interacting());
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
