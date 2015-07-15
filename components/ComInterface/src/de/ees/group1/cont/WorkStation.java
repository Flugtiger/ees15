package de.ees.group1.cont;

import de.ees.group1.bt.BT_manager;import de.ees.group1.com.IWorkStation;
import de.ees.group1.model.ProductionStep;
import de.ees.group1.model.WorkstationType;
public class WorkStation implements IWorkStation{
	
	
	
	public enum Type {
		DRILL,
		LATHE,
	}
	
	private int status;
	private int maxQualityLevel;
	private ProductionStep currentStep;
	private WorkstationType type;
	private BT_manager btManager;
	private IWorkStation ws;
	
	
	/*
	 * Erzeugt eine neue Arbeitsstation, die die entsprechende Control-Klasse für sich erzeugt
	 * und sich der Control-Klasse bekannt macht.
	 * Setzt default Werte für die Parameter der Arbeitsstation
	 */
	public WorkStation(BT_manager btManager){
		this.btManager=btManager;
		this.btManager.register(ws);
		setMaxQualityLevel(1);
		setStatus(-1);
	}
	
	//Gibt die maximale Qualität der Arbeitsstation zurück
	public int getMaxQualityLevel(){
		return maxQualityLevel;
	}
	
	/*
	 * setzt das maximal von der Arbeitsstation zu bewältigende Qualitätsniveau
	 */
	public void setMaxQualityLevel(int maxQualityLevel){
		this.maxQualityLevel=maxQualityLevel;
	}
	
	/*
	 * Gibt den aktuellen Status der Arbeitsstation zurück
	 */
	public int getStatus(){
		return status;
	}
	
	/*
	 * Gibt den Status der Arbeitsstation zurück. -1...default, 0...bereit, 1...in Betrieb, 2...defekt 
	 */
	public void setStatus(int status){
		this.status=status;
	}
	
	/*
	 * Gibt den aktuellen Arbeitsschritt zurück
	 */
	public ProductionStep getStep(){
		return currentStep;
	}
	
	/*
	 * Setzt den aktuellen Arbeitsschritt
	 */
	public void setStep(ProductionStep step){
		currentStep=step;
	}
	
	/*
	 * Setzt den Typ der Arbeitsstation
	 */
	public void setType(WorkstationType type){
		this.type=type;
	}
	
	/*
	 * Gibt den Typ zurück
	 */
	public WorkstationType getType(){
		return type;
	}

	
	/*
	 * Die Methode simuliert den Arbeitsschritt ihr muss ein Boolean übergeben werden, der sagt dass die Arbeit begonnen werden kann 
	 */
	public void simulateWork(){
			int time=getStep().getWorkTimeSeconds();
			time=time*1000;
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (getStatus()==1){
				btManager.transmitFinishedStep(true);
			}
			else{
				btManager.transmitFinishedStep(false);
		}
}

	
	public void giveCurrentStep(ProductionStep step) {
		int maxQualityWS=getMaxQualityLevel();
		currentStep=step;
		if ((status==1) & (maxQualityWS>=currentStep.getMinQualityLevel())){
			btManager.transmitYes();
		}
		else{
			btManager.transmitNo();
		}
		
	}

	//NXT hat Arbeitsposition und wartet auf abarbeitung des aktuellen Auftrags
	public void giveAcknowledgement(boolean answer) {
		simulateWork();
		
	}
}
