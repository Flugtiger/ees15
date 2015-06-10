import java.util.ArrayList;


public class Leitstation {
	public ArrayList<Fertigungsauftrag> orderQueue;
	public Leitstation(){
		orderQueue =new ArrayList<Fertigungsauftrag>();
	}
	public void addOrder(Fertigungsauftrag order){
		int i=order.getOrderNumber();
		orderQueue.add(i, order);
	}
	//Gibt den ersten Eintrag in der Queue aus und löscht diesen. 
	public Fertigungsauftrag newOrder(){
		
		Fertigungsauftrag order;
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
