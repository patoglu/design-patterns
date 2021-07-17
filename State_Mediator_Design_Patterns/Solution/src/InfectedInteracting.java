
public class InfectedInteracting implements State{

	Individual individual;
	/**
	 * Sets the individual reference.
	 * @param individual
	 */
	public InfectedInteracting(Individual individual) {
		this.individual = individual;
	}
	/**
	 * Unsupported.
	 */
	@Override
	public void switch_to_healthy_moving() {
		throw new UnsupportedOperationException();	

	}
	/**
	 * Function that switches to infected moving state.
	 */
	@Override
	public void switch_to_infected_moving() {
		individual.set_state(individual.get_infected_moving());
	}

	/**
	 * Unsupported.
	 */
	@Override
	public void switch_to_healthy_interacting() {
		throw new UnsupportedOperationException();	
	}

	/**
	 * Unsupported.
	 */
	@Override
	public void switch_to_infected_interacting() {
		throw new UnsupportedOperationException();	
		
	}

	/**
	 * Unsupported.
	 */
	@Override
	public void switch_to_hospitalized() {
		throw new UnsupportedOperationException();	
		
	}

	/**
	 * Unsupported.
	 */
	@Override
	public void switch_to_dead() {
		throw new UnsupportedOperationException();	
	}

}
