package de.ees.group1.model;

import de.ees.group1.cont.Workstation_Control;
import de.ees.group1.model.ProductionStep;
public class WorkStation {
	
	
	
	public enum Type {
		DRILL,
		LATHE,
	}
	
	private int status;
	private int maxQualityLevel;
	private ProductionStep currentStep;
	private Workstation_Control  control;
	
	/*
	 * Erzeugt eine neue Arbeitsstation, die die entsprechende Control-Klasse f�r sich erzeugt
	 * und sich der Control-Klasse bekannt macht.
	 * Setzt default Werte f�r die Parameter der Arbeitsstation
	 */
	public WorkStation(){
		control= new Workstation_Control();
		setModel();
		setMaxQualityLevel(1);
		setStatus(-1);
	}
	// �bergibt der Control-Klasse das aktuelle Modell
	public void setModel(){
		control.setModel(this);
	}
	//Gibt die maximale Qualit�t der Arbeitsstation zur�ck
	public int getMaxQualityLevel(){
		return maxQualityLevel;
	}
	
	
	public void setMaxQualityLevel(int maxQualityLevel){
		this.maxQualityLevel=maxQualityLevel;
	}
	
	/*
	 * Gibt den aktuellen Status der Arbeitsstation zur�ck
	 */
	public int getStatus(){
		return status;
	}
	
	/*
	 * Gibt den Status der Arbeitsstation zur�ck. -1...default, 0...bereit, 1...in Betrieb, 2...defekt 
	 */
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
