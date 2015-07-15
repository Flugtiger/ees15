package de.ees.group1.com;

import de.ees.group1.model.*;
public interface IWorkStation {
	/*
	 * Methode in der die Arbeitsstation dem NXT mitteilt, ob er an die Arbeitsstation ranfahren darf oder 
	 * weiterfahren muss, ihr muss die aktuelle Arbeitsstation mitgeteilt werden
	 */
	void enterWorkstation(ProductionStep currentStep);
	
	/*
	 * Simuliert den Arbeitsschritt wenn ihr True �bermittelt wurde, sollte aufgerufen werden, wenn das Fahrzeug an der Arbeitsstation steht.
	 * Gibt True zur�ck wenn Arbeit korrekt ausgef�hrt wurde.
	 */
	void simulateWork(Boolean k);
}
