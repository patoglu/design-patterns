
public class InfectedMoving implements State{
	Individual individual;
	/**
	 * Sets the individual reference.
	 * @param individual
	 */
	public InfectedMoving(Individual individual) {
		this.individual = individual;
	}
	/**
	 * Unsupported
	 */
	@Override
	public void switch_to_healthy_moving() {
		throw new UnsupportedOperationException();	
		
	}
	/**
	 * Unsupported
	 */
	@Override
	public void switch_to_infected_moving() {
		throw new UnsupportedOperationException();	
		
	}
	/**
	 * Unsupported
	 */
	@Override
	public void switch_to_healthy_interacting() {
		throw new UnsupportedOperationException();	
		
	}
	/**
	 * Function that changes to infected interacting state.
	 */
	@Override
	public void switch_to_infected_interacting() {
		individual.set_state(individual.get_infected_interacting());
		
	}
	/**
	 * Function that changes to hospitalized state.
	 */
	@Override
	public void switch_to_hospitalized() {
		individual.set_state(individual.get_hospitalized());
	}
	/**
	 * Unsupported
	 */
	@Override
	public void switch_to_dead() {
		throw new UnsupportedOperationException();	
		
	}

}
