package client;
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;

public class Tile extends JButton {
	private int col;
	private int row;
	private JPanel panel;
	private Tile[][] tiles;
	private Color bgColor;
	private String piece;
	
	Tile(Tile[][] tiles, JPanel panel, int col, int row) {
		//set name to coords
		//super(Integer.toString(col) + "," +  row);
		
		
		this.panel = panel;
		this.col = col;
		this.row = row;
		this.piece = null;
		this.setFont(new Font("Serif", Font.PLAIN, 40));
		
		//icon location
		ImageIcon icon = new ImageIcon("checker.png");
		//Resize icon by casting to "Icon" and scaling, then converting back to "ImageIcon"
		ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
	//	this.setIcon(scaledIcon);
		
		
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
		
		if(this.bgColor == Color.BLACK && this.row != 4 && this.row != 3) {
			if(this.row > 3) {
				this.piece = "Red";
				this.setText("♟");
			} else {
				
				this.piece = "White";
				this.setText("♙");
			}
		}
		
		
		
		
		//
		//action listener for when the tile is clicked
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//example of functionality, set icon to piece texture when clicked
				System.out.println(tiles[col][row].piece);
				
				//example of action listener functionality, color diagonal tiles blue when clicked
				for(int row = 0;row<8;row++) {
					for(int col = 0;col<8;col++) {
					
						tiles[col][row].setBackground(tiles[col][row].getBgColor());
					}
				}
				

				
			}
		});

	}
	
	public Color getBgColor() {
		return bgColor;
	}

	//public void paint(Graphics g) {
	//	Graphics2D g2d = (Graphics2D) g;
	//	g2d.drawOval(0, 0, 10, 10);
	//}
}
