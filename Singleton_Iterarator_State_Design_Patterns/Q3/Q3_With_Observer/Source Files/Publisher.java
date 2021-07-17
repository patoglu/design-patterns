public interface Publisher {
	void changeDetected(boolean flag);
	void addSubscriber(State subscriber);
}
