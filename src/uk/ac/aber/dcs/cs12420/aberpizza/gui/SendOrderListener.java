package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Finalises an order, sending it to the Till's log.
 * @author Tarinaky
 *
 */
public class SendOrderListener implements ActionListener {

	private OrderPlacer view = null;
	
	public SendOrderListener(OrderPlacer orderPlacer) {
		view = orderPlacer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String customerName = (String) JOptionPane.showInputDialog("Customer name..."); 
		view.order().getOrder().setCustomerName(customerName);

		String stringAmountTendered = (String) JOptionPane.showInputDialog("Enter amount tendered...");
		java.math.BigDecimal amountTendered = new java.math.BigDecimal(stringAmountTendered);

		java.math.BigDecimal total = view.order().getOrder().getSubtotal();

		if (amountTendered.compareTo(total) >=0) {
			//Save the amount discounted and finalise anything else.
			view.order().getOrder().finalise();
			//Add the order to the Till's log
			view.getTill().addOrder(view.order().getOrder());
			//Open the receipt for inspection
			new ReceiptViewer(view.order().getOrder());
			//Display the change to be tendered
			JOptionPane.showMessageDialog(view.getComponent(),"Change: \u00A3"+amountTendered.subtract(total) );
			//Clear the order builder for a new order.
			view.order().newOrder();
		} else {
			JOptionPane.showMessageDialog(view.getComponent(),"Insuficient cash tendered.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
