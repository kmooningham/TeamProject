package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame
{
	private JLabel status;
	private JButton connect;
	private JButton submit;
	private JButton stop;

	public ClientGUI(String title)
	{
		int i = 0;
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create status Label and make it red
		status = new JLabel("Not Connected");
		status.setForeground(Color.RED);

		//Create north panel for status
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		north.add(status);
		this.add(north, BorderLayout.NORTH);

		//Create buttons
		connect = new JButton("Connect");
		
		//Add action listener from window builder
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status.setText("Connect Button Pressed");
			
			}
		});
		
		submit = new JButton("Submit");
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status.setText("Submit Button Pressed");
			
			}
		});
		
		
		stop = new JButton("Stop");
		
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status.setText("Stop Button Pressed");
			
			}
		});
		


		//Create south panel for buttons, add them
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		south.add(connect);
		south.add(submit);
		south.add(stop);
		this.add(south, BorderLayout.SOUTH);
		
		//Add everything, make visible, set size
		this.setVisible(true);
		this.setSize(350, 400);



	}

	

	private void setFlowLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args)
	{
		new ClientGUI("Checkers ClientGUI");
		//new ClientGUI(args[0]); //args[0] represents the title of the GUI
	}

}
