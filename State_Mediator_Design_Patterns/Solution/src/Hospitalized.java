
public class Hospitalized implements State{
	Individual individual;
	/**
	 * Sets the individual reference.
	 * @param individual
	 */
	public Hospitalized(Individual individual) {
		this.individual = individual;
	}
	/*
	 * Unsupported.
	 */
	public void switch_to_healthy_moving()
	{
		throw new UnsupportedOperationException();	
	} 
	/*
	 * Unsupported.
	 */
	public void switch_to_infected_moving()
	{
		throw new UnsupportedOperationException();	
	} 
	/*
	 * Unsupported.
	 */
	public void switch_to_healthy_interacting()
	{
		throw new UnsupportedOperationException();	
	}
	/*
	 * Unsupported.
	 */
	public void switch_to_infected_interacting()
	{
		throw new UnsupportedOperationException();	
	}
	/*
	 * Unsupported.
	 */
	public void switch_to_hospitalized()
	{
		throw new UnsupportedOperationException();	
	}
	/**
	 * Switch to dead state.
	 */
	public void switch_to_dead()
	{
		individual.set_state(individual.get_dead());
	}
}
