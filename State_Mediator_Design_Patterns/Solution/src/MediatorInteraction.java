import java.awt.Rectangle;
import java.util.ArrayList;

public class MediatorInteraction implements Mediator{
	ArrayList<Individual> individiuals = new ArrayList<Individual>();
	@Override
	/**
	 * Adds an individual
	 */
	public void add_individual(Individual individual) {
		individiuals.add(individual);	
	}


	/**
	 * Checks the all possible intersections.
	 */
	@Override
	public void intersection(Individual individual) {
		for(Individual i : this.individiuals){
			if(i!=individual)
			{
				intersection(i, individual);
			}
			
		}
	}
	/**
	 * 
	 * @param person as an individual.
	 * @param status status of an individual.
	 * @return boolean value that indicates if the condition true or false.
	 */
	private boolean condition(Individual person, String status)
	{
		if(person.get_state_as_string() == status)
		{
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param first_person first individual.
	 * @param second_person second individual.
	 * @return return the maximum conversation time.
	 */
	private double conversation_time(Individual first_person, Individual second_person)
	{
		return Math.max(first_person.interaction_duration, second_person.interaction_duration);
	}
	/**
	 * 
	 * @param max_conv_time maximum conversation time
	 * @param first_person_mask if the person is wearing mask or not.
	 * @param second_person_mask if the person is wearing mask or not.
	 * @param min_distance minimum distance between two individuals.
	 * @return the probability of infection risk. 
	 */
	private double calculate_infection_prob(double max_conv_time, Individual first_person_mask, Individual second_person_mask, int min_distance)
	{
		
		return Math.min(Constants.R * (1 + (max_conv_time / 1000) / 10) * first_person_mask.M * second_person_mask.M * (1 - min_distance / 10), 1);
	}
	/**
	 * 
	 * @param first_person as first individual.
	 * @param second_person as second individual.
	 */
	private void intersection(Individual first_person, Individual second_person) 
	{
		int d = Math.min(first_person.distance, second_person.distance);
		Rectangle first_p_area = new Rectangle(first_person.x, first_person.y, d, d);
		Rectangle second_p_area = new Rectangle(second_person.x, second_person.y, d, d);
		if(first_p_area.intersects(second_p_area))
		{
			double random_prob = Math.random() * (1.0 - 0.0) + 0.0;
			if(condition(first_person, "Healthy Moving") && condition(second_person, "Healthy Moving"))
			{
				
				if(first_person.just_interacted <=0 && second_person.just_interacted <=0)
				{
					first_person.switch_to_healthy_interacting();
					second_person.switch_to_healthy_interacting();
				}
				else
				{
					first_person.just_interacted -= 8;
					second_person.just_interacted -= 8;
				}
				
	
			
				
			}
			else if(condition(first_person, "Healthy Moving") && condition(second_person, "Infected Moving"))
			{
				first_person.switch_to_healthy_interacting();
				second_person.switch_to_infected_interacting();
				
			}
			else if(condition(first_person, "Infected Moving") && condition(second_person, "Healthy Moving"))
			{
			
				first_person.switch_to_infected_interacting();
				second_person.switch_to_healthy_interacting();
				
			}/*
			else if(condition(first_person, "Infected Moving") && condition(second_person, "Infected Moving"))
			{
				
				first_person.switch_to_infected_interacting();
				second_person.switch_to_infected_interacting();
			
			}*/
			else if(condition(first_person, "Healthy Interacting") && condition(second_person, "Healthy Interacting"))
			{
				if(first_person.social_interaction_timer >= conversation_time(first_person, second_person))
				{
					first_person.switch_to_healthy_moving();
					second_person.switch_to_healthy_moving();
					first_person.just_interacted = 96;
					second_person.just_interacted = 96;
					first_person.social_interaction_timer = 0;
					second_person.social_interaction_timer = 0;
				}
				else
				{
					first_person.social_interaction_timer+=8;
					second_person.social_interaction_timer+=8;
				}
			}
			else if(condition(first_person, "Healthy Interacting") && condition(second_person, "Infected Interacting"))
			{
				if(first_person.social_interaction_timer >= conversation_time(first_person, second_person))
				{
					double infected_prob = calculate_infection_prob(conversation_time(first_person, second_person), first_person, second_person, d);
					if(infected_prob > random_prob)
					{
						first_person.switch_to_infected_moving();
						second_person.switch_to_infected_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
					else
					{
						first_person.switch_to_healthy_moving();
						second_person.switch_to_infected_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
					
				
				}
				else
				{
					first_person.social_interaction_timer+=8;
					second_person.social_interaction_timer+=8;
				}
			}
			else if(condition(first_person, "Infected Interacting") && condition(second_person, "Healthy Interacting"))
			{
				if(first_person.social_interaction_timer >= conversation_time(first_person, second_person))
				{
					double infected_prob = calculate_infection_prob(conversation_time(first_person, second_person), first_person, second_person, d);
					if(infected_prob > random_prob)
					{
						first_person.switch_to_infected_moving();
						second_person.switch_to_infected_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
					else
					{
						first_person.switch_to_infected_moving();
						second_person.switch_to_healthy_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
					
				
				}
				else
				{
					first_person.social_interaction_timer+=8;
					second_person.social_interaction_timer+=8;
				}
			}
			/*else if(condition(first_person, "Infected Interacting") && condition(second_person, "Healthy Interacting"))
			{
				if(first_person.social_interaction_timer >= conversation_time(first_person, second_person))
				{
					double infected_prob = calculate_infection_prob(conversation_time(first_person, second_person), first_person, second_person, d);
					if(infected_prob > random_prob)
					{
						first_person.switch_to_infected_moving();
						second_person.switch_to_infected_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
					else
					{
						first_person.switch_to_infected_moving();
						second_person.switch_to_healthy_moving();
						first_person.social_interaction_timer = 0;
						second_person.social_interaction_timer = 0;
					}
				
				}
				else
				{
					first_person.social_interaction_timer+=8;
					second_person.social_interaction_timer+=8;
				}
			}*/
		}
	}
	@Override
	/**
	 * Iterates all list and getting coordinates.
	 */
	public void interactions()
	{
		for(int i = 0 ; i < this.individiuals.size() ; ++i)
		{
			this.individiuals.get(i).send_coordinates();
		}
	}
	/**
	 * Debugging purposes.
	 */
	@Override
	public String toString()
	{
		int healthy_count = 0;
		int hospitalized_count = 0;
		int infected_count = 0;
		int dead_count = 0;
		Constants.print_constants();
		Hospital.hospital_status();
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i < individiuals.size() ; ++i)
		{
			if(individiuals.get(i).get_state_as_string() == "Healthy Moving" || individiuals.get(i).get_state_as_string() == "Healthy Interacting")
			{
				healthy_count++;
			}
			if(individiuals.get(i).get_state_as_string() == "Hospitalized")
			{
				hospitalized_count++;
			}
			if(individiuals.get(i).get_state_as_string() == "Infected Moving" || individiuals.get(i).get_state_as_string() == "Infected Interacting")
			{
				infected_count++;
			}
			if(individiuals.get(i).get_state_as_string() == "Dead")
			{
				dead_count++;
			}
			result.append(i +". individual: " + individiuals.get(i));
			result.append("\n");
		}
		System.out.println("Healthy count: " + healthy_count);
		System.out.println("Hospitalized count: " + hospitalized_count);
		System.out.println("Infected count: " + infected_count);
		System.out.println("Dead count: " + dead_count);
		
		return result.toString();
	}
	

	@Override
	public ArrayList<Individual> get_individuals() {
		return individiuals;
	}



	


	



	
}
