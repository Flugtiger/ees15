package de.ees.group1.model;

import de.ees.group1.model.ProductionStep;
public class WorkStation {
	
	public enum Type {
		DRILL,
		LATHE,
	}
	/*
	 * Gibt den Status der Arbeitsstation zurück. -1...default, 0...bereit, 1...in Betrieb, 2...defekt 
	 */
	private int status;
	private int maxQualityLevel;
	private ProductionStep currentStep;
	
	public int getMaxQualityLevel(){
		return maxQualityLevel;
	}
	
	public void setMaxQualityLevel(int maxQualityLevel){
		this.maxQualityLevel=maxQualityLevel;
	}
	
	public int getStatus(){
		return status;
	}
	
	public void setStatus(int status){
		this.status=status;
	}
	
	public ProductionStep getStep(){
		return currentStep;
	}
	
	public void setStep(ProductionStep step){
		currentStep=step;
	}
	public boolean work(ProductionStep step) {
		int time=step.getWorkTimeSeconds();
		time=time*1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (status==1){
			return true;
		}
		else{
			return false;
		}
		
	}
	

}
