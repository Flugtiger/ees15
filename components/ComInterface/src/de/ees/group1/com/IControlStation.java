package de.ees.group1.com;

import de.ees.group1.model.ProductionOrder;
import de.ees.group1.model.ProductionStep;

public interface IControlStation {
	
	
	//�bergibt dem NXT den aktuellen Auftrag
	ProductionOrder sendProductionOrder();
	
	//�bergibt der Leitstation den aktuellen Bearbeitungsschritt
	void setCurrentStep(ProductionStep step);
	
	//�bergibt der GUI den aktuellen Schritt
	ProductionStep getCurrentStep();
	
	//�bergibt der Leitstation den aktuellen Status des NXT
	void setStatusNXT(int status);
	
	
	
	
}
