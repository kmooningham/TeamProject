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
	private Tile selected;
	
	Tile(Tile[][] tiles, JPanel panel, int row, int col) {
		//set name to coords
		//super(Integer.toString(row) + "," +  col);
		
		this.selected = null;
		this.tiles = tiles;
		this.panel = panel;
		this.col = col;
		this.row = row;
		this.piece = "Blank";
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
				this.setText("♙");
			} else {
				
				this.piece = "White";
				this.setText("♟");
				
			}
		}
		
		//action listener for when the tile is clicked	
		//game stuff only happens on black tiles
		if (this.bgColor == Color.BLACK) {
			this.addActionListener(new TileController(tiles, this));
		}

	}
	
	public Color getBgColor() {
		return bgColor;
	}

	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public String getPiece() {
		return this.piece;
	}
	
	public void setPiece(String piece) {
		this.piece = piece;		
	}
	

	
	public boolean doesOwn(/*TODO: some client data here*/) {
		//if client data is the same as current piece color, then that client can control the chosen tile
		return true;
	}
	
	public void deselect() {
		selected = null;
	}
	public void select() {
		selected = this;
		System.out.println("Selected = (" + selected.getRow() + "," + selected.getCol());
	}
	
	public Tile getSelected() {
		return selected;
	}
	
	public boolean canMove(Tile to) {
		if(
			to.getPiece() == "Blank"
			&& Math.abs(to.getCol() - col) == 1
			&& Math.abs(to.getRow() - row) == 1
			) {
			return true;
		}
		
		return false;
	}
	
	public boolean canMove(String direction) {
		if (direction.equals("NW")) { //-,-
			if(row < 1 || col < 1) {
				return false;
			} else {
				return tiles[row-1][col-1].getPiece().equals("Blank");
			}
			
		} else if (direction.equals("NE")) { //-,+
			if(row < 1 || col > 5) {
				return false;
			} else {
				return tiles[row-1][col+1].getPiece().equals("Blank");
			}
			
		} else if (direction.equals("SW")) {
			if(row > 6 || col < 1) {
				return false;
			} else {
				return tiles[row+1][col-1].getPiece().equals("Blank");
			}
			
		} else if (direction.equals("SE")) {	
			if(row > 6 || col > 6) {
				return false;
			} else {
				return tiles[row+1][col+1].getPiece().equals("Blank");
			}
		} else {
			return false;
		}
	}
	
	public boolean canJump(String direction) { //if diagonal tile contains a different piece and next diagonal tile is blank

		
		if (direction.equals("NW")) { //-,-
			if(row < 2 || col < 2) {
				return false;
			} else {
				return (
						!tiles[row-1][col-1].getPiece().equals(this.piece) 
						&& !tiles[row-1][col-1].getPiece().equals("Blank") 
						&& tiles[row-2][col-2].getPiece().equals("Blank")
						);
			}
			
		} else if (direction.equals("NE")) { //-,+
			if(row < 2 || col > 5) {
				return false;
			} else {
				return (
						!tiles[row-1][col+1].getPiece().equals(this.piece) 
						&& !tiles[row-1][col+1].getPiece().equals("Blank")
						&& tiles[row-2][col+2].getPiece().equals("Blank")
						);
			}
			
		} else if (direction.equals("SW")) {
			if(row > 5 || col < 2) {
				return false;
			} else {
				return (
						!tiles[row+1][col-1].getPiece().equals(this.piece) 
						&& !tiles[row+1][col-1].getPiece().equals("Blank")
						&& tiles[row+2][col-2].getPiece().equals("Blank")
						);
			}
			
		} else if (direction.equals("SE")) {	
			if(row > 5 || col > 5) {
				return false;
			} else {
				return (
						!tiles[row+1][col+1].getPiece().equals(this.piece)
						&& !tiles[row+1][col+1].getPiece().equals("Blank")
						&& tiles[row+2][col+2].getPiece().equals("Blank")
						);
			}
		} else {
			return false;
		}
	}
}
