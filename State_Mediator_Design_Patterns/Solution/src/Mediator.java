import java.util.ArrayList;

public interface Mediator {
	 public void add_individual(Individual individual);
     public void intersection(Individual individual);
     public void interactions();
     public ArrayList<Individual> get_individuals();
}
