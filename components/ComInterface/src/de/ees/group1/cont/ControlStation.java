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
	 * Gibt an ob der NXT die Arbeitsstation anf�hrt oder an ihr vorbeif�hrt true: f�hrt an; false: f�hrt weiter
	 */
	private boolean statusNXT;
	/*
	 * gibt die aktuelle Arbeitsstation an die der NXT anfragt
	 */
	private WorkStation workstation;
	
	/*
	 * �bergibt den gerade an den NXT �bermittleten Auftrag an die ControlStation
	 */
	public void setCurrentOrder(ProductionOrder order){
		currentOrder=order;
		currentStepNumber=0;
	}
	/*
	 * Schreibt den n�chsten Step auf currentStep und erh�ht die currentStepNumber um 1
	 */
	public void setCurrentStep(){
		currentStep =currentOrder.getStep(currentStepNumber);
		currentStepNumber++;
	}
	
	public ProductionStep getCurrentStep(){
		return currentStep;
	}
	
	public void setStatusNXT(boolean statusNXT){
		this.statusNXT=statusNXT;
	}
	
	public void setCurrentWorkstation(WorkStation workstation){
		this.workstation=workstation;
	}
	
	public WorkStation getCurrentWorkstation(){
		return workstation;
	}
	
	public boolean getStatusNXT(){
		return statusNXT;
	}
	
		
}
	
	
	
	


