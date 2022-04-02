package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tile extends JButton {
	private int col;
	private int row;
	private JPanel panel;
	
	Tile(JPanel panel, int col, int row) {
		super(Integer.toString(col) + row);
		this.panel = panel;
		this.col = col;
		this.row = row;
	}
}
