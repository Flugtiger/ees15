package de.ees.group1.com;

import de.ees.group1.model.*;
public interface IWorkStation {
	/*
	 * Methode in der die Arbeitsstation dem NXT mitteilt, ob er an die Arbeitsstation ranfahren darf oder 
	 * weiterfahren muss, ihr muss die aktuelle Arbeitsstation mitgeteilt werden
	 */
	void enterWorkstation(ProductionStep currentStep);
	void simulateWork(Boolean k);
}
