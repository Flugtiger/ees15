package de.ees.group1.cont;
/*
 * Controller for ControlStation, which handles order tracking
 */

import de.ees.group1.model.*;


public class ControlStation_Control {
	private ProductionOrder currentOrder;
	private ProductionStep currentStep;
	private int currentStepNumber;
	private ControlStation model;
	private WorkStation CurrentWorkStation;
	
	public  ControlStation_Control(ControlStation model){
		 this.model=model;
	
	}
	
	/*
	 * übergibt den gerade an den NXT übermittleten Auftrag an die ControlStation
	 */	
	public void setCurrentOrder(){
		currentOrder=model.getList().getFirstOrder();
		currentStepNumber=0;
	}
	
	/*
	 * Fügt der Liste mit den ProductionOrder einen neuen Auftrag zu.
	 */
	public void addProductionOrder(ProductionOrder order){
		model.getList().setProductionOrder(order);
	}
	
	/*
	 * Methode zur Übermittlung eines neuen Auftrags an den NXT. Ist als Methode dem Interafce zu übergeben
	 */
	public ProductionOrder sendProductionOrder(){
		setCurrentOrder();
		return currentOrder;
	}

	/*
	 * Übergibt den aktuellen Status des NXT an das Model. Ist als Methode dem Interface zu übergeben
	 */
	public void setStatusNXT(int statusNXT){
		model.setStatusNXT(statusNXT);
	
	}
	
	public int getStatusNXT(){
		return model.getStatusNXT();
	}
	
	
	
	public void evaluateStatusNXT(){
		int status=model.getStatusNXT();
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
				//neuen Auftrag anstoßen
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
				//arbeit konnte nicht durchgeführt werden;
				break;
			}
		}
	}
}
	
	
	
	


