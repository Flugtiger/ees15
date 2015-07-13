package de.ees.group1.cont;


import de.ees.group1.model.ProductionStep;
import de.ees.group1.model.WorkStation;

public class Workstation_Control {
	
	public void enterWorkstation(ProductionStep currentStep){
		int maxQualityWS=getMaxQualityLevel();
		setStep(currentStep)
		if ((getStatus()==1) & (maxQualityWS>=currentStep.getMinQualityLevel())){
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
			int time=currentStep.getWorkTimeSeconds();
			time=time*1000;
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (status==1){
				transmitYes();
			}
			else{
				transmitNo;
			
		
		
		}
}
