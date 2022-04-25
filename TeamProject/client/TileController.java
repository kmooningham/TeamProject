package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TileController implements ActionListener {
	private Tile[][] tiles;
	private Tile thisTile;
	private Tile selected;

	
	public TileController(Tile[][] tiles, Tile tile, Tile selected) {
		this.tiles = tiles;
		this.thisTile = tile;
		this.selected = selected;

	}
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println(thisTile.getPiece() + thisTile.getRow() + thisTile.getCol());
		//thisTile.setText(null);
		//thisTile.setPiece("Blank");
		
		if(!thisTile.doesOwn()) { //if the user does not own the tile, they can not interact with it
			return;
		}

		//reset the bg color of all tiles
		for(Tile[] a : tiles) {
			for(Tile t : a) {
				t.setBackground(t.getBgColor());	
			}
		}

		
		
		//if selected can move to tile, tell the servdr to move it and return
		selected = thisTile.getSelected(); 
		
		if(selected != null) {
			if(selected.canMove(thisTile)) {
				sendMove(selected, thisTile);
				return;
			}
		}
		
		
		
		
		
		//select chosen tile and update action listener selected
		thisTile.select();
		this.selected = thisTile.getSelected();
		
		//update selected for all tiles
		for(Tile[] a : tiles) {
			for(Tile t : a) {
				t.select(this.selected);
			}
		}
		
		
		
		

		//System.out.println("This tile = (" + selected.getRow() + "," + selected.getCol());
		
		//ArrayList<Tile> legalMoves = new ArrayList<Tile>();
		//legalMoves.add(tiles[thisTile.getRow()][thisTile.getCol()]);

		
		//paint valid moves of selected tile
		if (selected.canMove("NW") ) {
			tiles[selected.getRow()-1][selected.getCol()-1].setBackground(Color.GREEN);	
		}
		
		if (selected.canMove("NE") ) {
			tiles[selected.getRow()-1][selected.getCol()+1].setBackground(Color.GREEN);	
		}
		
		if (selected.canMove("SW") ) {
			tiles[selected.getRow()+1][selected.getCol()-1].setBackground(Color.GREEN);	
		}
		
		if (selected.canMove("SE") ) {
			tiles[selected.getRow()+1][selected.getCol()+1].setBackground(Color.GREEN);	
		}
		
		
		
	}
	
	public void sendMove(Tile from, Tile to) {
		System.out.println("Server should move piece from " + from.getRow() + "," + from.getCol() + " to " + to.getRow() + "," + to.getCol());
	}
	
	public void sendJump(Tile from, Tile to) {
		System.out.println("not yet implimented");
	}
}
