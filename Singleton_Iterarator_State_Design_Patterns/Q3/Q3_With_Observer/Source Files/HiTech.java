import java.util.ArrayList;

public class HiTech implements Publisher {
	State light;
    HiTech(){

       
    }
    @Override
    public void changeDetected(boolean flag) {
       light.update(flag);
    }
	@Override
	public void addSubscriber(State subscriber) {
		light = subscriber;
		
	}


}