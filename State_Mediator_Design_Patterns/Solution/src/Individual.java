import java.awt.Color;
import java.awt.Graphics;

public class Individual {
	State healthy_moving;
	State infected_moving;
	State healthy_interacting;
	State infected_interacting;
	State hospitalized;
	State dead;
	State state;
	
	protected Mediator mediator;
	public int x,y; //coordinates.
	public int vx; //speed of x axis.
	public int vy; //speed of y axis.
	public int distance; //social distance.
	public double interaction_duration;
	double M; //mask status.
	int social_interaction_timer = 0; //social interaction timer.
	int just_interacted = 0;
	int infected_timer = 0;
	int hospitalized_time = 0;
	/**
	 * Individual constructor for creating individuals.
	 * @param mediator is a mediator reference.
	 * @param is_healthy if the person is infected or not.
	 */
	public Individual(Mediator mediator, boolean is_healthy)
	{
			this.create_states();
			if(!is_healthy)
				this.state = infected_moving;
			
			else
			{
				this.state = healthy_moving;
			}
			
			this.mediator = mediator;
			this.create_random_coordinates();
			this.create_random_speed();
			this.create_mask_status();
			this.create_social_distance();
			this.create_social_interaction_duration();
			
	}
	
	
	/*
	 * Send coordinates to mediator. So mediator can compare them.
	 */
  public void send_coordinates()
    {
        mediator.intersection(this);
    }
    
	
  /**
   * Creates random coordinates for an individual.
   */
	private void create_random_coordinates()
	{
		x = (int) (Math.random() * 995 + 0); //create random number for x coordinate.
		y = (int) (Math.random() * 595 + 0); //create random number for y coordinate.
	}
	/*
	 * create random speed for an individual, speed is between 5 and -5
	 */
	private void create_random_speed()
	{
		vx = (int) (Math.random() * (10 + 1) + -5); //create random number for x axis speed.
		vy = (int) (Math.random() * (10 + 1) + -5); //create random number for y axis speed.
		if(vx == 0) 
		{
			vx++;
		}
		if(vy == 0)
		{
			vy++;
		}
	}
	/**
	 * Create mask status randomly.
	 */
	private void create_mask_status()
	{
		int random_num = (int) (Math.random() * 10 + 0);
		if(random_num >= 5)
		{
			M = 0.2;
		}
		M = 0.8;
	}
	/**
	 * Create social distance randomly.
	 */
	private void create_social_distance()
	{
		distance = (int) (Math.random() * 10 + 0)  + 3;
	}
	/**
	 * Create social interaction duration randomly. 
	 */
	private void create_social_interaction_duration()
	{
		interaction_duration = (int) (Math.random() * 1000 + 5000);
	}
	
	/* 														STATE                             							*/
	/**
	 * @return the healthy_moving
	 */
	public State get_healthy_moving() {
		return healthy_moving;
	}
	/**
	 * @return the infected_moving
	 */
	public State get_infected_moving() {
		return infected_moving;
	}
	/**
	 * @return the healthy_interacting
	 */
	public State get_healthy_interacting() {
		return healthy_interacting;
	}
	/**
	 * @return the infected_interacting
	 */
	public State get_infected_interacting() {
		return infected_interacting;
	}

	/**
	 * @return the hospitalized
	 */
	public State get_hospitalized() {
		return hospitalized;
	}


	/**
	 * @return the dead
	 */
	public State get_dead() {
		return dead;
	}
	
	/**
	 * @param state the state to set
	 */
	public void set_state(State state) {
		this.state = state;
	}
	
	
	
	/**
	 * Function that returns the current state of string.
	 * @return String as state.
	 */
	public String get_state_as_string()
	{
		if(this.state == healthy_moving)
		{
			return "Healthy Moving";
		}
		else if(this.state == infected_moving)
		{
			return "Infected Moving";
		}
		else if(this.state == healthy_interacting)
		{
			return "Healthy Interacting";
		}
		else if(this.state == infected_interacting)
		{
			return "Infected Interacting";
		}
		else if(this.state == hospitalized)
		{
			return "Hospitalized";
		}
		else if(this.state == dead)
		{
			return "Dead";
		}
		return "null";
	}
	
	/**
	 * Paint method for single individual.
	 * @param g Graphics object.
	 */
	public void paint(Graphics g) {
		
		
		if(this.state == healthy_moving)
		{
			g.setColor(Color.WHITE);
			g.fillOval(x,y,5,5);
			this.update_location();
		}
		else if(this.state == infected_moving)
		{
			
			g.setColor(Color.RED);
			infected_timer += 8;
			
			if(infected_timer >= 25000 && Hospital.is_limit_exceeded() == false)
			{
				
				this.state = hospitalized;
				Hospital.increment_hospitalized();
				infected_timer = 0;
			}
			else if(infected_timer >= 100 * (1-Constants.Z) * 1000)
			{
								this.state = dead;
			}
			else if(infected_timer >= 25000 && Hospital.is_limit_exceeded() == true)
			{
				
				g.fillOval(x,y,5,5);
				this.update_location();
			}
			
			
			else if(infected_timer < 25000)
			{
				
				g.fillOval(x,y,5,5);
				this.update_location();
			}
			
			
		}
		else if(this.state == healthy_interacting)
		{
			g.setColor(Color.GREEN);
			g.fillOval(x,y,5,5);
		}
		else if(this.state == infected_interacting)
		{
			infected_timer += 8;
			g.setColor(Color.ORANGE);
			g.fillOval(x,y,5,5);
			
		}
		else if(this.state == hospitalized)
		{
			if(hospitalized_time > 10000)
			{
				this.state = healthy_moving;
				hospitalized_time = 0;
				Hospital.decrement_hospitalized();
			}
			hospitalized_time+=8;
		}
		else if(this.state == dead)
		{
			
		}
		prevent_overflow();
		
		
	}
	/**
	 * Helper function that updates the location.
	 */
	private void update_location()
	{
		x += vx;
		y += vy;
	}
	/**
	 * Helper function that prevents the overflow.
	 */
	private void prevent_overflow()
	{
		if(x < 0 | x >= 995)
		{
			vx *= -1;
		}
		if(y < 0 | y >= 595)
		{
			vy *= -1;
		}
	}
	/**
	 * Methods of state operations.
	 */
	public void switch_to_healthy_moving()
	{
		state.switch_to_healthy_moving();
	}
	/**
	 * Methods of state operations.
	 */
	public void switch_to_infected_moving()
	{
		state.switch_to_infected_moving();
	} 
	/**
	 * Methods of state operations.
	 */
	public void switch_to_healthy_interacting()
	{
		state.switch_to_healthy_interacting();	
	}
	/**
	 * Methods of state operations.
	 */
	public void switch_to_infected_interacting()
	{
		state.switch_to_infected_interacting();	
	}
	/**
	 * Methods of state operations.
	 */
	public void switch_to_hospitalized()
	{
		state.switch_to_hospitalized();	
	}
	/**
	 * Methods of state operations.
	 */
	public void switch_to_dead()
	{
		state.switch_to_dead();	
	}
	/**
	 * Methods of state operations.
	 */
	/**
	 * Helper function for creating all of the states.
	 */
	 private void create_states()
    {
    	healthy_moving = new HealthyMoving(this);
		infected_moving = new InfectedMoving(this);
		healthy_interacting = new HealthyInteracting(this);
		infected_interacting = new InfectedInteracting(this);
		hospitalized = new Hospitalized(this);
		dead = new Dead();
    }
	/**
	 * Overrided toString method. (For debugging purposes.) 
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("[ X, Y ] = " + "[ " + x + " " + y + " ], ");
		result.append("[ Vx, Vy ] = " + "[ " + vx + " " + vy + " ], ");
		result.append("distance = " + this.distance);
		result.append("interaction_duration = " + this.interaction_duration);
		result.append("M = " + this.M);
		if(this.state == healthy_moving)
		{
			result.append("Healthy Moving, ");
		}
		else if(this.state == infected_moving)
		{
			result.append("Infected Moving, ");
		}
		else if(this.state == healthy_interacting)
		{
			result.append("Health Moving, ");
		}
		else if(this.state == infected_interacting)
		{
			result.append("Infected interacting, ");
		}
		else if(this.state == hospitalized)
		{
			result.append("Hospitalized, ");
		}
		else if(this.state == dead)
		{
			result.append("Dead, ");
		}
		
		return result.toString();
		
	}
	
	
	
}
