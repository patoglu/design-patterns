
public class GreenState implements State{

    TrafficLight traffic_light;
 
    /**
     * 
     * @param traffic_light represents state.
     */
	public GreenState(TrafficLight traffic_light) {
		this.traffic_light = traffic_light;
    }
	/**
	 * Function that simulates yellow to red state.
	 */
    @Override
    public void switch_yellow_to_red() {
        System.out.println("_____________________________________");
        System.out.println("You can't switch yellow to red while in green state.");
        System.out.println("_____________________________________");

    }

    @Override
    /**
	 * Function that simulates red to green state..
	 */
    public void switch_red_to_green() {
        System.out.println("_____________________________________");
        System.out.println("You can't switch red to green while in green state.");
        System.out.println("_____________________________________");

    }

    @Override
    /**
     * Function that simulates green to yellow state.
     */
    public void switch_green_to_yellow() {
        System.out.println("_____________________________________");
        System.out.println("This tooks 60 seconds...");
        System.out.println("Switching green to yellow state.");
        System.out.println("_____________________________________");
        traffic_light.set_state(traffic_light.get_yellow_state());
    }
    
    
}
