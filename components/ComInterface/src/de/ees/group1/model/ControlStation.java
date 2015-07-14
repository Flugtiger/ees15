package de.ees.group1.model;

import de.ees.group1.cont.ControlStation_Control;

public class ControlStation {
	private int statusNXT;
	private OrderList list;
	private ControlStation_Control control;
	
	
	public ControlStation(){
		list=new OrderList();
		control= new ControlStation_Control(this);
	}
	
	public int getStatusNXT(){
		return statusNXT;
	}
	public void setStatusNXT(int statusNXT){
		this.statusNXT=statusNXT;
	}
	
	public OrderList getList(){
		return list;
	}
	
	
}
