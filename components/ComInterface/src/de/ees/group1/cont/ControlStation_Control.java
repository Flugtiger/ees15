package de.ees.group1.cont;
/*
 * Controller for ControlStation, which handles order tracking
 */

import de.ees.group1.model.*;


public class ControlStation_Control {
	private ProductionOrder currentOrder;
	private ProductionStep currentStep;
	private int currentStepNumber;
	
	/*
	 * übergibt den gerade an den NXT übermittleten Auftrag an die ControlStation
	 */
	public void setCurrentOrder(){
		currentOrder=list.getFirstOrder;
		currentStepNumber=0;
	}
	/*
	 * Schreibt den nächsten Step auf currentStep und erhöht die currentStepNumber um 1
	 */
	public void setCurrentStep(ProductionStep step){
		currentStep =step;
		currentStepNumber ++;
	}
	
	public ProductionStep getCurrentStep(){
		return currentStep;
	}
	
	public ProductionOrder sendProductionOrder(){
		return currentOrder;
	}

	public void setStatusNXT(int statusNXT){
		setStatusNXT();
	}
	//Sollte int sein
	public void startWorkingStep(boolean start){
		setStatusNXT(1);
	}
	
	public void finishedWorkingStep(int finish){
		setStatusNXT(finish);
	}
	
	public boolean waitingPosition(int status){
		setStatusNXT(status);
		if (status==??){
			System.out.println("Auftrag beendet!");
			this.setCurrentOrder();
			return true;
		}
		else{
			System.out.println("Auftrag fehlgeschlagen, starten Sie das System neu!");
			return false;
		}
	}
	
	public void enterWorkingStation(int status){
		setStatusNXT(status);
	}
}
	
	


