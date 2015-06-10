import java.util.ArrayList;


public class ControlStation {
	public ArrayList<Order> orderQueue;
	public ControlStation(){
		orderQueue =new ArrayList<Order>();
	}
	public void addOrder(Order order){
		int i=order.getOrderNumber();
		orderQueue.add(i, order);
	}
	//Gibt den ersten Eintrag in der Queue aus und löscht diesen. 
	public Order newOrder(){
		
		Order order;
		if(orderQueue.isEmpty()==false){
			order=orderQueue.get(0);
			orderQueue.remove(0);	
		}
		else{
			order=null;
		}
		return order;
	}
}
