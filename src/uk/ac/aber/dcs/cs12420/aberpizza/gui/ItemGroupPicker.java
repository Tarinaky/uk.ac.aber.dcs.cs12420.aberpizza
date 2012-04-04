package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import uk.ac.aber.dcs.cs12420.aberpizza.data.*;

@SuppressWarnings("serial")
public class ItemGroupPicker extends JDialog {
	
	private Order order = null;
	

	public ItemGroupPicker(Order order, ItemGroupButton group) {
		this.order = order;
		setModal(true);
				
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
				
		for (Item item : group.getList() ) {
			Double size = new Double(item.getSize() );
			JButton button = new JButton(size.toString() );
			button.addActionListener(new ItemGroupPickerListener(order,this,item));
			add(button);

				
		}
		
		pack();
		
	}
	
}
