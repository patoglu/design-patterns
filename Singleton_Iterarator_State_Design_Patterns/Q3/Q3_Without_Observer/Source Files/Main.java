public class Main{

	public static void main(String[] args) {
		System.out.println("Start with red state.");
		TrafficLight traffic_light = new TrafficLight();
		System.out.println("[Switch red to green. It's a valid rule in our FSA.]");
        traffic_light.switch_red_to_green();
        System.out.println("[Switch green to yellow. It's a valid rule in our FSA..]");
        traffic_light.switch_green_to_yellow();
        System.out.println("[Switch green to yellow while in yellow state. This should print an error message.]");
        traffic_light.switch_green_to_yellow();	 
        System.out.println("[Switch red to green while in yellow state. This should print an error message.]");
        traffic_light.switch_red_to_green();  
        System.out.println("[Switch back to red from yellow, this is a valid operation for our FSA.]");
        traffic_light.switch_yellow_to_red(); 
        System.out.println("[Switch red to green, this is a valid operation in our FSA.]");
        traffic_light.switch_red_to_green();    
	}
}