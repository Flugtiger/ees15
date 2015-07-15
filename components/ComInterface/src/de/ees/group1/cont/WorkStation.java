package de.ees.group1.cont;

import de.ees.group1.bt.BT_manager;import de.ees.group1.com.IWorkStation;
import de.ees.group1.cont.Workstation_Control;
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
	 * Erzeugt eine neue Arbeitsstation, die die entsprechende Control-Klasse f�r sich erzeugt
	 * und sich der Control-Klasse bekannt macht.
	 * Setzt default Werte f�r die Parameter der Arbeitsstation
	 */
	public WorkStation(BT_manager btManager){
		this.btManager=btManager;
		this.btManager.register(ws);
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
	
	/*
	 * setzt das maximal von der Arbeitsstation zu bew�ltigende Qualit�tsniveau
	 */
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
	
	/*
	 * Gibt den aktuellen Arbeitsschritt zur�ck
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
	public void setType(WorkStationType type){
		this.type=type;
	}
	
	/*
	 * Gibt den Typ zur�ck
	 */
	public WorkStationType getType(){
		return type;
	}
}

	
	
	public void setModel(WorkStation model){
		this.model=model;
		
	}
	/*
	 * �berpr�ft, ob die Station geeignet ist um den aktuellen Schritt abzuarbeiten
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
	 * Die Methode simuliert den Arbeitsschritt ihr muss ein Boolean �bergeben werden, der sagt dass die Arbeit begonnen werden kann 
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