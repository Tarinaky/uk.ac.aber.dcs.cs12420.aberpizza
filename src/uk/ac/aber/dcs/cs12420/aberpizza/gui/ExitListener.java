package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;

/**
 * When a Till is closed it should automatically serialise all data to disk. This
 * WindowListener attempts just that.
 * @author Tarinaky
 *
 */
public class ExitListener implements WindowListener {

	private JFrame frame;
	private Till till;
	
	public ExitListener(JFrame frame, Till till) {
		this.frame = frame;
		this.till = till;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			till.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.dispose();
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
