package client;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class BoardPanel extends JPanel {
	public BoardPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblButtonsGoHere = new JLabel("Buttons go here");
		add(lblButtonsGoHere, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblBoardGoesIn = new JLabel("Board goes in here");
		panel.add(lblBoardGoesIn);
	
	}

}
