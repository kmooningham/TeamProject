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
		
		if (command == "Cancel") {
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "1");
		} else if (command == "Submit") {
			LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			//LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
			
			//if (data.getUsername().equals("") || data.getPassword().equals("")) {
			//	return;		
			//}
			
			//System.out.println("Username added: " + data.getUsername().toString());
			
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container,  "1");
			
		}
	}
}
