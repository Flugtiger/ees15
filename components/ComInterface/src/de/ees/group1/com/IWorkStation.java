package de.ees.group1.com;

import de.ees.group1.model.*;
public interface IWorkStation {


	void giveCurrentStep(ProductionStep step);
	
	
	//hat wartePos ererreicht f�r Auftragsabarbeitung
	void giveAcknowledgement (boolean answer);
	
	
	
	
	
}
