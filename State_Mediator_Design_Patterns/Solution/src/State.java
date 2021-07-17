
public interface State {
	/**
	 * States
	 * Healthy_Moving
	 * Infected_Moving,
	 * Healthy_Interacting,
	 * Infected_Interacting
	 * Hospitalized,
	 * Dead
	 */
	public void switch_to_healthy_moving(); 
	public void switch_to_infected_moving(); 
	public void switch_to_healthy_interacting();
	public void switch_to_infected_interacting();
	public void switch_to_hospitalized();
	public void switch_to_dead();
	
}
