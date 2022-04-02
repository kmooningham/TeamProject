package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardController implements ActionListener {
	private JPanel container;
	
	public BoardController(JPanel container) {
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		/* command control here
		if (command == "whatever") {		
		
		} else if (command == "some other command") {
				
		}
		*/
		
		//set view to login panel
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container,  "login");
		
	}
}
