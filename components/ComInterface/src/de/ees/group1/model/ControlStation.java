package de.ees.group1.model;

public class ControlStation {
	private int statusNXT;
	
	public ControlStation(){
		OrderList list=new OrderList();
	}
	
	public int getStatusNXT(){
		return statusNXT;
	}
	public void setStatusNXT(int statusNXT){
		this.statusNXT=statusNXT;
	}
}
