package de.ees.group1.com;

import de.ees.group1.model.ProductionOrder;
import de.ees.group1.model.ProductionStep;

public interface IControlStation {
	
	void reachedParkingPositionInd(int orderID ,int nextWorkingStep);

	ProductionOrder sendProductionOrder();
	void setCurrentStep(ProductionStep step);
	ProductionStep getCurrentStep();
	boolean waitingPosition(int status);
	void finishedWorkingStep(int finish);
	void startWorkingStep(boolean start);
	void enterWorkingStation(int status);
}
