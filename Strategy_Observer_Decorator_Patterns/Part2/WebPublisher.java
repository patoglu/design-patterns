
import java.util.Map;
import java.util.ArrayList;


public class WebPublisher implements Publisher {

    private Map<Subscriber,Contents> subs;
    @Override
    public void add_subscriber(Subscriber sub,Contents content_type) {

    }

    @Override
    public void delete_subscriber(Subscriber sub) {

    }

    @Override
    public void notify_subscribers(Contents content_type) {

    }

    public void echange_content(Contents content_type,Object content){

    }
}
