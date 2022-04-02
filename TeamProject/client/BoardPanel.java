package client;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class BoardPanel extends JPanel {
	public BoardPanel(BoardController bc) {
		setLayout(new BorderLayout(0, 0));
		
		//panel to hold buttons
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.NORTH);
		
			//create a new button, add it to the panel, and add the controller as a listener
			JButton btnNewButton = new JButton("Logout");
			buttonPanel.add(btnNewButton);
			btnNewButton.addActionListener(bc);
			
			JButton btnNewButton_1 = new JButton("New button");
			buttonPanel.add(btnNewButton_1);
			btnNewButton_1.addActionListener(bc);
			
			JButton btnNewButton_2 = new JButton("New button");
			buttonPanel.add(btnNewButton_2);
			btnNewButton_2.addActionListener(bc);
		
		//panel to hold the board
		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(8, 8, 0, 0));
			
		/*
			JButton btnNewButton_3 = new JButton("New button");
			boardPanel.add(btnNewButton_3);
		
			JLabel lblBoardGoesIn = new JLabel("Board goes in here");
			boardPanel.add(lblBoardGoesIn);
		*/
			 for (int index = 0; index < 64; index++) {
		            JButton button = new JButton();
		            button.setPreferredSize(new Dimension(64, 64));
		            boardPanel.add(button);
		        }
	}

}
