
import java.util.ArrayList;


public class Fertigungsauftrag {
	public int  orderNumber; //Auftragsnummer
	public ArrayList<Bearbeitungsschritt> processStepQueue; //Warteschlange für die einzelnen Bearbeitungsschritte
	public Fertigungsauftrag(int orderNumber){
		this.orderNumber=orderNumber;
	}
	//Fügt einen Bearbeitungsschritt in die Liste ein
	public void insertWorkingStep(Bearbeitungsschritt newStep){
		int i=newStep.getNumber();
		processStepQueue.add(i++,newStep);
	}
	//Gibt die Auftragsnummer zurück
	public int getOrderNumber(){
		return orderNumber;
	}
}
