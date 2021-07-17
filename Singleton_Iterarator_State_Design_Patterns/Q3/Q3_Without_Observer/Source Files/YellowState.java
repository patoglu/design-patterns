public class YellowState implements State{


    TrafficLight traffic_light;
    /**
     * 
     * @param traffic_light represents state.
     */
	public YellowState(TrafficLight traffic_light) {
		this.traffic_light = traffic_light;
    }
	/**
	 * Function that simulates yellow to red state.
	 */
    @Override
    public void switch_yellow_to_red() {
        System.out.println("_____________________________________");
        System.out.println("This tooks 3 seconds...");
        System.out.println("Switching yellow to red state.");
        System.out.println("_____________________________________");
        traffic_light.set_state(traffic_light.get_red_state());

    }
    /**
	 * Function that simulates red to green state..
	 */
    @Override
    public void switch_red_to_green() {
        System.out.println("_____________________________________");
        System.out.println("You can't switch red to green while in yellow state.");
        System.out.println("_____________________________________");

    }
    /**
     * Function that simulates green to yellow state.
     */
    @Override
    public void switch_green_to_yellow() {
        System.out.println("_____________________________________");
        System.out.println("You can't switch green to yellow while in yellow state.");
        System.out.println("_____________________________________");

    }
    
    
}
