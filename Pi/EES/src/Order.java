
import java.util.ArrayList;


public class Order {
	public int  orderNumber; //Auftragsnummer
	public ArrayList<WorkingStep> processStepQueue; //Warteschlange für die einzelnen Bearbeitungsschritte
	public Order(int orderNumber){
		this.orderNumber=orderNumber;
	}
	//Fügt einen Bearbeitungsschritt in die Liste ein
	public void insertWorkingStep(WorkingStep newStep){
		int i=newStep.getNumber();
		processStepQueue.add(i++,newStep);
	}
	//Gibt die Auftragsnummer zurück
	public int getOrderNumber(){
		return orderNumber;
	}
}
