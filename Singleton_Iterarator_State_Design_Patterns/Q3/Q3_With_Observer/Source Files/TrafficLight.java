public class TrafficLight {
    State red_state;
    State green_state;
    State yellow_state;
    State state;
    
    /**
     * Default constructor for Traffic Light
     */
    public  TrafficLight()
    {
        red_state = new RedState(this);
        green_state = new GreenState(this);
        yellow_state = new YellowState(this);
        state = red_state;
    }

    /**
     * Method that switches yellow to red.
     */
    public void switch_yellow_to_red() {
        state.switch_yellow_to_red();

    }

    /**
     * Method that switches red to green
     */
    public void switch_red_to_green() {
        state.switch_red_to_green();
    }

   /**
    * Method that switches green to yellow
    */
    public void switch_green_to_yellow() {
        state.switch_green_to_yellow();
    }
    /**
     * Method that sets the state.
     * @param state is the current state.
     */
    void set_state(State state) {
		this.state = state;
    }
    
    /**
     * Method that gets the state.
     * @return current state.
     */
    public State get_state() {
        return state;
    }

    /**
     * Method that gets the yellow state.
     * @return the yellow state.
     */
    public State get_yellow_state() {
        return yellow_state;
    }
    /**
     * 
     * @return the reed state.
     */
    public State get_red_state() {
        return red_state;
    }
    /**
     * 
     * @return the green state.
     */
    public State get_green_state() {
        return green_state;
    }

    
}
