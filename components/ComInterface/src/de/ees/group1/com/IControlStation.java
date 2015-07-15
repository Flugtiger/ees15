package de.ees.group1.com;




public interface IControlStation {
	
	

	//int ist letzter Step der abgearbeitet wurde
	void reachedParkingPosistionInd(int nextWorkingStep);
	
	//Arbeitsauftrag wurde erfolgreich übermittelt
	void giveAcknowledgement(boolean answer);
	
	void transmitActualState(int state);
	
	
}
