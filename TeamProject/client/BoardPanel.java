package client;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
<<<<<<< Upstream, based on branch 'master' of https://github.com/kmooningham/TeamProject.git
		boardPanel.setLayout(new GridLayout(8, 8, 0, 0));
			
		/*
			JButton btnNewButton_3 = new JButton("New button");
			boardPanel.add(btnNewButton_3);
=======
		GridLayout grid = new GridLayout(8,8,0,0);
		boardPanel.setLayout(grid);
>>>>>>> 9bd530d Added class for tiles
		
<<<<<<< Upstream, based on branch 'master' of https://github.com/kmooningham/TeamProject.git
			JLabel lblBoardGoesIn = new JLabel("Board goes in here");
			boardPanel.add(lblBoardGoesIn);
		*/
			 for (int index = 0; index < 64; index++) {
		            JButton button = new JButton();
		            button.setPreferredSize(new Dimension(64, 64));
		            boardPanel.add(button);
		        }
=======

		//add tiles, named by their coordinates	
		for(int col = 0;col<7;col++) {
			for(int row = 0;row<7;row++) {
				tiles[col][row] = new Tile(boardPanel,col,row);
				boardPanel.add(tiles[col][row]);
			}
		}
	
			
>>>>>>> 9bd530d Added class for tiles
	}

}
