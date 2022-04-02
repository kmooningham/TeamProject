package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginController implements ActionListener {
	private JPanel container;
	
	public LoginController(JPanel container) {
		this.container = container;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		/* command control here
		if (command == "Cancel") {
		
		} else if (command == "Submit") {
		
		}
		*/
		
		//set view to board panel
		CardLayout cardLayout = (CardLayout)container.getLayout();
		cardLayout.show(container,  "board");
	}
}
