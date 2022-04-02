package client;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;

public class BoardPanel extends JPanel {
	public BoardPanel() {
		//setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		setLayout(new GridLayout(8, 8, 4, 4));
		
		add(new JLabel("This is the board panel"));
	
	}

}
