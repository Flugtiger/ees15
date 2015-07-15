package de.ees.group1.cont;
/*
 * Controller for ControlStation, which handles order tracking
 */

import de.ees.group1.bt.BT_manager;
import de.ees.group1.com.IControlStation;
import de.ees.group1.model.*;


public class ControlStation implements IControlStation{
	private ProductionOrder currentOrder;
	private ProductionStep currentStep;
	private int currentStepNumber;
	private ControlStation model;
	private WorkStation CurrentWorkStation;
	private OrderList list;
	private int statusNXT;
	private BT_manager btManager;
	private IControlStation cs;
	
	public ControlStation(){
		btManager=new BT_manager();
		btManager.register(cs);
		//Erzeugt die vier Arbeitsstationen
		for (int i = 0; i < 4; i++) {
			new WorkStation(btManager);
		}
		//Erzeugt OrderList
		list=new OrderList();
	}
	
	/*
	 * �bergibt den gerade an den NXT �bermittleten Auftrag an die ControlStation
	 */	
	public void setCurrentOrder(){
		currentOrder=list.getFirstOrder();
		currentStepNumber=0;
	}
	
	/*
	 * F�gt der Liste mit den ProductionOrder einen neuen Auftrag zu.
	 */
	public void addProductionOrder(ProductionOrder order){
		list.setProductionOrder(order);
	}
	
	/*
	 * Methode zur �bermittlung eines neuen Auftrags an den NXT. Ist als Methode dem Interafce zu �bergeben
	 */
	public void sendProductionOrder(){
		setCurrentOrder();
		btManager.transmitProductionOrder(currentOrder);
	}

	/*
	 * �bergibt den aktuellen Status des NXT an das Model. Ist als Methode dem Interface zu �bergeben
	 */
	public void setStatusNXT(int statusNXT){
		this.statusNXT=statusNXT;
	
	}
	
	public int getStatusNXT(){
		return statusNXT;
	}
	
	
	
	public void evaluateStatusNXT(){
		int status=getStatusNXT();
		if ((0<status) & (status<=22)){
			switch (status){
			case 1: case 5: case 9: case 13: case 17:
				//setWorkStation(1);
				break;
			case 2: case 6: case 10: case 14: case 18:
				//setWorkStation(2);
				break;
			case 3: case 7: case 11: case 15: case 19:
				//setWorkStation(3);
				break;
			case 4: case 8: case 12: case 16: case 20:
				//setWorkStation(4);
				break;
			case 21:
				//neuen Auftrag ansto�en
				break;
			case 22:
				//Meldung alles kaputt
				break;
			}
		}
		if ((0<status) & (status<=20)){
			switch (status){
			case 1: case 2: case 3: case 4: 
				//action to "Einfahrt");
				break;
			case 5: case 6: case 7: case 8: 
				//action to "Weiterfahrt";
				break;
			case 9: case 10: case 11: case 12: 
				//arbeit beginnen;
				break;
			case 13: case 14: case 15: case 16: 
				//Arbeit beendet;
				break;
			case 17: case 18: case 19: case 20: 
				//arbeit konnte nicht durchgef�hrt werden;
				break;
			}
		}
	}

	
	public void setCurrentStep(ProductionStep step) {
		currentStep=step;		
	}

	
	public ProductionStep getCurrentStep() {
		return currentStep;
	}
}
	
	
	
	


