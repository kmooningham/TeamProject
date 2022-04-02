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

		//create the container, which uses a cardLayout to control which view is selected
	    CardLayout cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    
		//add the container to the center of the window
	    this.add(container, BorderLayout.CENTER);
	    
	    
	    //add a new view to contain the board
	    BoardController bc = new BoardController(container);
	    JPanel view1 = new BoardPanel(bc);
	    container.add(view1, "board");
	    
	    
	    //Create the action listener for the login panel
	    //add a new view to contain the login panel
	    LoginController lc = new LoginController(container);
	    JPanel view2 = new LoginPanel(lc);
	    container.add(view2, "login");
	    
	    
	    //start on view 2
	    cardLayout.show(container, "login");

	}


	public static void main(String[] args)
	{
		new ClientGUI("Checkers ClientGUI", 800, 800);
		//new ClientGUI(args[0]); //args[0] represents the title of the GUI
	}

}
