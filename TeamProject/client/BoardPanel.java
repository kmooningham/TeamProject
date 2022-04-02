package client;

import javax.swing.*;

import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.Color;

//
public class BoardPanel extends JPanel {
	//array to hold tiles
	private Tile[][] tiles;
	
	public BoardPanel(BoardController bc) {
		tiles = new Tile[8][8];
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
		//this panel is added to the center of the boarder layout
		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(8, 8, 0, 0));
			
		

		//add tiles, named by their coordinates	
		for(int col = 0;col<8;col++) {
			for(int row = 0;row<8;row++) {
				tiles[col][row] = new Tile(tiles,boardPanel,col,row);
				boardPanel.add(tiles[col][row]);
			}
		}
		

			

	}

}
