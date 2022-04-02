package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tile extends JButton {
	private int col;
	private int row;
	private JPanel panel;
	private Tile[][] tiles;
	private Color bgColor;
	
	Tile(Tile[][] tiles, JPanel panel, int col, int row) {
		//set name to coords
		super(Integer.toString(col) + "," +  row);
		
		this.panel = panel;
		this.col = col;
		this.row = row;
		
		//text color
		this.setForeground(Color.WHITE);
		
		//color background based on position
		this.setOpaque(true);
		if((col + row) % 2 == 0) {
			bgColor = Color.RED;
		} else {
			bgColor = Color.BLACK;
		}
			
		this.setBackground(bgColor);
		
		//action listener for when the tile is clicked
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				//example of action listener functionality, color diagonal tiles blue when clicked
				for(int col = 0;col<8;col++) {
					for(int row = 0;row<8;row++) {
						tiles[col][row].setBackground(tiles[col][row].getBgColor());
					}
				}
				
				try {
					tiles[col+1][row+1].setBackground(Color.BLUE);
				} catch (ArrayIndexOutOfBoundsException error) {}
				
				try {
					tiles[col+1][row-1].setBackground(Color.BLUE);
				} catch (ArrayIndexOutOfBoundsException error) {}
				
				try {
					tiles[col-1][row+1].setBackground(Color.BLUE);
				} catch (ArrayIndexOutOfBoundsException error) {}
				
				try {
					tiles[col-1][row-1].setBackground(Color.BLUE);
				} catch (ArrayIndexOutOfBoundsException error) {}
				
				
			}
		});
		
	}
	
	public Color getBgColor() {
		return bgColor;
	}

}
