package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			view.getTill().addOrder(view.order().getOrder());
			view.order().newOrder();

			JOptionPane.showMessageDialog(view.getComponent(),"Change: \u00A3"+amountTendered.subtract(total) );
		} else {
			JOptionPane.showMessageDialog(view.getComponent(),"Insuficient cash tendered.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
