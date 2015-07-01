package de.ees.group1.cont;
/*
 * Controller for ControlStation, which handles order tracking
 */

import de.ees.group1.model.*;


public class ControlStation {
	private ProductionOrder currentOrder;
	private ProductionStep currentStep;
	private int currentStepNumber;
	
	/*
	 * �bergibt den gerade an den NXT �bermittleten Auftrag an die ControlStation
	 */
	public void getCurrentOrder(ProductionOrder order){
		currentOrder=order;
		currentStepNumber=0;
	}
	
	public void getCurrentStep(){
		currentStep =currentOrder.getStep(currentStepNumber);
	}
	

}
