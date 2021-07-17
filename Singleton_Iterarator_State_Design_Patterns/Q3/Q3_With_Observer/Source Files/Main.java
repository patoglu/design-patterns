public class Main{

	public static void main(String[] args) {
	
		
		System.out.println("Start with red state.");
		TrafficLight traffic_light = new TrafficLight();
		HiTech system = new HiTech();

		System.out.println("[Switch red to green.]");
        traffic_light.switch_red_to_green();
		system.addSubscriber(traffic_light.get_green_state());
        System.out.println("[Switch green to yellow]");
        traffic_light.switch_green_to_yellow(); 
        System.out.println("[Switch back to red from yellow]");
        traffic_light.switch_yellow_to_red(); 
        System.out.println("[Switch red to green.");
        traffic_light.switch_red_to_green();
        System.out.println("Systems are detecting traffic load right now. Change Detected will be true.");
        system.changeDetected(true);
        traffic_light.switch_green_to_yellow();
        
        
        
	}
}