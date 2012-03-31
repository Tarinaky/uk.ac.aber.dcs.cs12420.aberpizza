package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendOrderListener implements ActionListener {

	private OrderPlacer view = null;
	
	public SendOrderListener(OrderPlacer orderPlacer) {
		view = orderPlacer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.getTill().addOrder(view.order().getOrder());

	}

}
