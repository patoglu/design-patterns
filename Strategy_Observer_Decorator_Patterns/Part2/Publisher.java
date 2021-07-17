public interface Publisher {

    void notify_subscribers(Contents content_type);
    void add_subscriber(Subscriber sub,Contents content_type);
    void delete_subscriber(Subscriber sub);
    
}
