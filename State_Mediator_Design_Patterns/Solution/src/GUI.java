import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Button;

public class GUI extends JPanel implements ActionListener {
	Mediator mediator = new MediatorInteraction();
	ArrayList<Graph> graph_points = new ArrayList<Graph>();
	int timer_gui = 0;
	private JLabel label;
	private boolean play = true;
	private boolean add_one = false;
	private boolean add_bulk = false;
	
	public GUI()
	{
		for(int i = 0 ; i < 100 ; ++i)
		{
			if(i == 5)
			{
				Individual person = new Individual(mediator, false);
				mediator.add_individual(person);
			}
			else
			{
				Individual person = new Individual(mediator, true);
				mediator.add_individual(person);
			}
			
			
		}

		

		JButton button = new JButton("PLAY/PAUSE");
		button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					play = !play;
				}
				
		});

		JButton button2 = new JButton("a");
		button2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					add_one = true;
				}
				
		});
		
		JButton button3 = new JButton("b");
		button3.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					add_bulk = true;
				}
				
		});
	
		
		label = new JLabel(" ");
		label.setForeground(Color.RED);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBackground(Color.black);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JFrame frame = new JFrame(); //create new frame.
		frame.getContentPane().setBackground(Color.RED);
		frame.setSize(1020, 635); //Create 1000x600 canvas.
		frame.setVisible(true); //make it visible.
		frame.setTitle("Epidemic Simulation"); //set frame title.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when the x button is pressed.
		frame.setResizable(false); //reject resizing.
		frame.add(button, BorderLayout.NORTH);
		button2.setSize(5, 5);
		frame.add(button2, BorderLayout.EAST);
		frame.add(button3, BorderLayout.WEST);


		frame.add(this);
		frame.add(label, BorderLayout.SOUTH);
		
		frame.getContentPane().setBackground(Color.black);
		frame.add(this, BorderLayout.CENTER);

		
		frame.setLocationRelativeTo(null);
		Timer t = new Timer(8, this);
		t.restart();
		
		
	}
	/**
	 * Main paint method.
	 */
	public void paint(Graphics g)
	{

		if(add_one == true)
		{
			Individual person = new Individual(mediator, false);
			mediator.add_individual(person);
			add_one = false;
		}
		if(add_bulk == true)
		{
			for(int i = 0 ; i < 50 ; ++i)
			{
				Individual person = new Individual(mediator, false);
				mediator.add_individual(person);
			}
			
			add_bulk = false;
		}
		label.setText(Integer.toString(timer_gui));
		int infected_count = 0;
		int healthy_count = 0;
		int hospitalized_count = 0;
		int dead_count = 0;
		
		
		//https://stackoverflow.com/a/625624/10330277
		
			
		if (play)
		{
			//Individual person = new Individual(mediator, false);
			//mediator.add_individual(person);
			ArrayList<Individual> individuals = mediator.get_individuals();
			for(Individual i: individuals)
			{
				if(i.get_state_as_string() == "Infected Interacting"||
						   i.get_state_as_string() == "Infected Moving")
				{
					infected_count++;
				}
				if(i.get_state_as_string() == "Healthy Interacting"||
						   i.get_state_as_string() == "Healthy Moving")
				{
					healthy_count++;
				}
				if(i.get_state_as_string() == "Dead")
				{
					dead_count++;
				}
				if(i.get_state_as_string() == "Hospitalized")
				{
					hospitalized_count++;
				}	
			}
			timer_gui += 1;
			int seconds = (int) (timer_gui / 100) % 60 ;
			int minutes = (int) ((timer_gui / (100*60)) % 60);
			int hours   = (int) ((timer_gui / (100*60*60)) % 24);
			label.setText("Healthy: " + healthy_count+ "                                                   " + "Infected: " + infected_count +  "                                                      " +  Integer.toString(hours) +":" +Integer.toString(minutes) +":"+ Integer.toString(seconds) +"                           " + "Hospitalized: " + hospitalized_count +"                                     "+ "Death Count: " + dead_count );
			super.paintComponent(g);
			super.setBackground(Color.BLACK);
		}
			
		ArrayList<Individual> individuals = mediator.get_individuals();
		for(Individual i: individuals)
		{
			if(i.get_state_as_string() == "Infected Interacting"||
			   i.get_state_as_string() == "Infected Moving")
			{
				infected_count++;
			}

			
			if (play)
				i.paint(g);
		}
			
		graph_points.add(new Graph(timer_gui / 32, infected_count));
		if (play)
		{
			mediator.interactions();
			for(Graph _g: graph_points)
			{
				g.fillOval(_g.time + 1, 500 - _g.value, 3, 3);
				
			}
		}
		
	}

	/**
	 * Refreshes frame.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();	
		//Hospital.hospital_status();
		//System.out.println(this.mediator);
	}
	
	
}
