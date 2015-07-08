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
	 * Gibt an ob der NXT die Arbeitsstation anfährt oder an ihr vorbeifährt true: fährt an; false: fährt weiter
	 */
	private boolean statusNXT;
	/*
	 * gibt die aktuelle Arbeitsstation an die der NXT anfragt
	 */
	private WorkStation workstation;
	
	/*
	 * übergibt den gerade an den NXT übermittleten Auftrag an die ControlStation
	 */
	public void setCurrentOrder(ProductionOrder order){
		currentOrder=order;
		currentStepNumber=0;
	}
	/*
	 * Schreibt den nächsten Step auf currentStep und erhöht die currentStepNumber um 1
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
	
	
	
	


