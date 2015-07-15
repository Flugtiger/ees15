package de.ees.group1.com;

import de.ees.group1.model.ProductionOrder;
import de.ees.group1.model.ProductionStep;

public interface IControlStation {
	
	
	//Übergibt dem NXT den aktuellen Auftrag
	ProductionOrder sendProductionOrder();
	
	//Übergibt der Leitstation den aktuellen Bearbeitungsschritt
	void setCurrentStep(ProductionStep step);
	
	//Übergibt der GUI den aktuellen Schritt
	ProductionStep getCurrentStep();
	
	//Übergibt der Leitstation den aktuellen Status des NXT
	void setStatusNXT(int status);
	
	
	
	
}
