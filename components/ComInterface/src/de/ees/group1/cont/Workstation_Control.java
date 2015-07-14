package de.ees.group1.cont;


import de.ees.group1.bt.BT_manager;
import de.ees.group1.model.ProductionStep;
import de.ees.group1.model.WorkStation;

public class Workstation_Control {
	
	private WorkStation model; 
	
	
	public void setModel(WorkStation model){
		this.model=model;
		
	}
	/*
	 * Überprüft, ob die Station geeignet ist um den aktuellen Schritt abzuarbeiten
	 */
	public void enterWorkstation(ProductionStep currentStep){
		int maxQualityWS=model.getMaxQualityLevel();
		model.setStep(currentStep);
		if ((model.getStatus()==1) & (maxQualityWS>=currentStep.getMinQualityLevel())){
			transmitYes();
		}
		else{
			transmitNo;
		}
	}
	/*
	 * Die Methode simuliert den Arbeitsschritt ihr muss ein Boolean übergeben werden, der sagt dass die Arbeit begonnen werden kann 
	 */
	public void simulateWork(Boolean k){
			int time=model.getStep().getWorkTimeSeconds();
			time=time*1000;
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (model.getStatus()==1){
				transmitYes();
			}
			else{
				transmitNo;
		}
}
