package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Opens a new {@link Order}.
 * @author Tarinaky
 *
 */
public class NewOrderListener implements ActionListener {
	private OrderPlacer view = null;

	public NewOrderListener(OrderPlacer orderPlacer) {
		view = orderPlacer;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.order().newOrder();

	}

}
