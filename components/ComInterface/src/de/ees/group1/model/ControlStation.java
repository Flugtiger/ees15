package de.ees.group1.model;

import java.util.List;

public class ControlStation {
	/**
	 * structured list containing all orders
	 */
	private List<ProductionOrder> _order;
	
	public void newProductionOrder(ProductionOrder order){
		int i=order.getId();
		_order.add(i, order);
	}
	
	public ProductionOrder getOrder(){
		ProductionOrder order=_order.get(0);
		_order.remove(0);
		return order;
	}
}
