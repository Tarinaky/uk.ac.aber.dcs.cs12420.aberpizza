package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;

public class TillReviewer {
	private JFrame frame = null;
	private Till till = null;

	public TillReviewer(Till till) {
		this.till = till;
		
		frame = new JFrame("Review orders");
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {}
			public void windowClosed(WindowEvent arg0) {}
			public void windowClosing(WindowEvent arg0) {
				frame.dispose();
				new OrderPlacer();
			}
			public void windowDeactivated(WindowEvent arg0) {}
			public void windowDeiconified(WindowEvent arg0) {}
			public void windowIconified(WindowEvent arg0) {}
			public void windowOpened(WindowEvent arg0) {}
			
		});
		
		frame.pack();
		frame.setSize(800,480);
		frame.setVisible(true);
		
	}

}
