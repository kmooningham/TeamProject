package client;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame
{
	public ClientGUI(String title, int w, int h)
	{
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(w, h);

		//create the container, which uses a cardLayout to control view
	    CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    
		//add the container to the center of the window
	    this.add(container, BorderLayout.CENTER);
	    
	    
	    //add a new view to contain the board
	    JPanel view1 = new BoardPanel();
	    container.add(view1, "1");
	    
	    //add a new view to contain the login
	    JPanel view2 = new LoginPanel();
	    container.add(view2, "2");
	    
	    
	    
	    
	    cardLayout.show(container, "2");

		//Add everything, make visible, set size
		



	}

	

	private void setFlowLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args)
	{
		new ClientGUI("Checkers ClientGUI", 800, 800);
		//new ClientGUI(args[0]); //args[0] represents the title of the GUI
	}

}
