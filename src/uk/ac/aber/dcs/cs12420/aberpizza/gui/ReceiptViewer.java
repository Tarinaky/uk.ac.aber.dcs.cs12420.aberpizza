package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;

public class ReceiptViewer {
	private JFrame frame = null;
	
	ReceiptViewer(Order order) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextArea receipt = new JTextArea(order.getReceipt() );
		frame.add(receipt);
		frame.pack();
		frame.show();
	}
}
